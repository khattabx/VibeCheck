package com.elgang.vibecheck

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class AudioAnalysisActivity : AppCompatActivity() {

    private lateinit var containerAudioInput: LinearLayout
    private lateinit var tvTapToRecord: TextView
    private lateinit var tvRecordTimer: TextView
    private lateinit var tvRecordingInfo: TextView
    private lateinit var btnPlayPause: TextView

    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null

    private var isRecording = false
    private var isPlaying = false

    private var startTimeMs: Long = 0
    private var outputFile: String? = null

    private val timerRunnable = object : Runnable {
        override fun run() {
            if (!isRecording) return
            val elapsed = SystemClock.elapsedRealtime() - startTimeMs
            val seconds = (elapsed / 1000).toInt()
            val min = seconds / 60
            val sec = seconds % 60
            tvRecordTimer.text = String.format("%02d:%02d", min, sec)
            tvRecordTimer.postDelayed(this, 500)
        }
    }

    companion object {
        private const val REQ_RECORD_AUDIO = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_analysis)

        val toolbar = findViewById<Toolbar>(R.id.toolbarAudio)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        containerAudioInput = findViewById(R.id.containerAudioInput)
        tvTapToRecord = findViewById(R.id.tvTapToRecord)
        tvRecordTimer = findViewById(R.id.tvRecordTimer)
        tvRecordingInfo = findViewById(R.id.tvRecordingInfo)
        btnPlayPause = findViewById(R.id.btnPlayPause)

        // ضغط مستمر للتسجيل
        containerAudioInput.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (checkAudioPermission()) {
                        startRecording()
                    } else {
                        requestAudioPermission()
                    }
                    true
                }
                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_CANCEL -> {
                    stopRecording()
                    true
                }
                else -> false
            }
        }

        // تشغيل / إيقاف التسجيل المسجّل
        btnPlayPause.setOnClickListener {
            if (outputFile == null) {
                Toast.makeText(this, "No recording to play", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (isPlaying) {
                stopPlaying()
            } else {
                startPlaying()
            }
        }
    }

    // === Permission Handling ===

    private fun checkAudioPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestAudioPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            REQ_RECORD_AUDIO
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQ_RECORD_AUDIO) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    this,
                    "Microphone permission granted. Hold again to record.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Microphone permission is required to record audio.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // === Recording logic ===

    private fun startRecording() {
        if (isRecording) return

        // لو في تشغيل شغال، وقفه
        if (isPlaying) {
            stopPlaying()
        }

        outputFile = "${externalCacheDir?.absolutePath}/temp_record.3gp"

        mediaRecorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(this)
        } else {
            MediaRecorder()
        }

        mediaRecorder?.apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            setOutputFile(outputFile)

            try {
                prepare()
                start()
                isRecording = true
                updateUIRecordingStarted()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    this@AudioAnalysisActivity,
                    "Failed to start recording",
                    Toast.LENGTH_SHORT
                ).show()
                releaseRecorder()
            }
        }
    }

    private fun stopRecording() {
        if (!isRecording) return

        val elapsed = SystemClock.elapsedRealtime() - startTimeMs
        val seconds = (elapsed / 1000).toFloat()

        try {
            mediaRecorder?.stop()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        releaseRecorder()
        isRecording = false
        updateUIRecordingStopped()

        // عرض مدة التسجيل
        val info = String.format("Recorded: %.1f seconds", seconds)
        tvRecordingInfo.text = info
        btnPlayPause.text = "Play"
    }

    private fun releaseRecorder() {
        mediaRecorder?.reset()
        mediaRecorder?.release()
        mediaRecorder = null
    }

    // === Playing logic ===

    private fun startPlaying() {
        val filePath = outputFile ?: return

        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(filePath)
                prepare()
                start()
                // isPlaying = false

                btnPlayPause.text = "Pause"
                // أضف "Playing..." من غير ما نعيد إسناد val
                val baseText = tvRecordingInfo.text.toString()
                if (!baseText.contains("Playing...")) {
                    tvRecordingInfo.text = "$baseText\nPlaying..."
                }
                setOnCompletionListener {
                    stopPlaying()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    this@AudioAnalysisActivity,
                    "Failed to play recording",
                    Toast.LENGTH_SHORT
                ).show()
                stopPlaying()
            }
        }
    }

    private fun stopPlaying() {
        try {
            mediaPlayer?.stop()
        } catch (_: Exception) { }
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying = false
        btnPlayPause.text = "Play"

        // شيل كلمة "Playing..." لو كانت موجودة
        val currentText = tvRecordingInfo.text.toString()
        tvRecordingInfo.text = currentText.replace("\nPlaying...", "")
    }

    // === UI helpers ===

    private fun updateUIRecordingStarted() {
        tvTapToRecord.text = "Recording... release to stop"
        tvRecordTimer.visibility = View.VISIBLE
        startTimeMs = SystemClock.elapsedRealtime()
        tvRecordTimer.removeCallbacks(timerRunnable)
        tvRecordTimer.post(timerRunnable)

        containerAudioInput.setBackgroundColor(
            ContextCompat.getColor(this, R.color.secondary_color)
        )
    }

    private fun updateUIRecordingStopped() {
        tvTapToRecord.text = "Tap & hold to record"
        tvRecordTimer.visibility = View.GONE
        tvRecordTimer.removeCallbacks(timerRunnable)

        containerAudioInput.background =
            ContextCompat.getDrawable(this, R.drawable.bg_card_white)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRecording) {
            stopRecording()
        }
        if (isPlaying) {
            stopPlaying()
        }
    }
}