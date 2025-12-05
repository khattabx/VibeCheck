package com.elgang.vibecheck

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class TextAnalysisActivity : AppCompatActivity() {

    private lateinit var etInputText: EditText
    private lateinit var btnAnalyze: Button
    private lateinit var tvHappy: TextView
    private lateinit var tvSad: TextView
    private lateinit var tvFear: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_analysis)

        val toolbar = findViewById<Toolbar>(R.id.toolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        etInputText = findViewById(R.id.etInputText)
        btnAnalyze = findViewById(R.id.btnAnalyzeText)
        tvHappy = findViewById(R.id.tvHappy)
        tvSad = findViewById(R.id.tvSad)
        tvFear = findViewById(R.id.tvFear)

        btnAnalyze.setOnClickListener {
            // TODO: منطق الموديل الحقيقي
            // مثال: نخلي Happy نشط
            setSentiment(Sentiment.HAPPY)
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

enum class Sentiment {
    HAPPY, SAD, FEAR, NONE
}