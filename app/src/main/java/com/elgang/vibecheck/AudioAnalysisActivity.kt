package com.elgang.vibecheck

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class AudioAnalysisActivity : AppCompatActivity() {

    private lateinit var containerAudioInput: LinearLayout
    private lateinit var tvHappy: TextView
    private lateinit var tvSad: TextView
    private lateinit var tvFear: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_analysis)

        val toolbar = findViewById<Toolbar>(R.id.toolbarAudio)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        containerAudioInput = findViewById(R.id.containerAudioInput)
        tvHappy = findViewById(R.id.tvHappyAudio)
        tvSad = findViewById(R.id.tvSadAudio)
        tvFear = findViewById(R.id.tvFearAudio)

        containerAudioInput.setOnClickListener {
            // TODO: تسجيل + تحليل الصوت
            // مثال: نخلي Sad نشط
            setSentiment(Sentiment.SAD)
        }
    }

    private fun setSentiment(sentiment: Sentiment) {
        setNeutral(tvHappy)
        setNeutral(tvSad)
        setNeutral(tvFear)

        when (sentiment) {
            Sentiment.HAPPY -> setActive(tvHappy)
            Sentiment.SAD -> setActive(tvSad)
            Sentiment.FEAR -> setActive(tvFear)
            else -> {}
        }
    }

    private fun setNeutral(textView: TextView) {
        textView.background = ContextCompat.getDrawable(this, R.drawable.bg_result_neutral)
    }

    private fun setActive(textView: TextView) {
        textView.background = ContextCompat.getDrawable(this, R.drawable.bg_result_active)
    }
}