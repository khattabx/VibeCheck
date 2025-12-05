package com.elgang.vibecheck

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class TextAnalysisActivity : AppCompatActivity() {

    private lateinit var etInputText: EditText
    private lateinit var btnAnalyze: Button
    private lateinit var tvResultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_analysis)

        val toolbar = findViewById<Toolbar>(R.id.toolbarText)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        etInputText = findViewById(R.id.etInputText)
        btnAnalyze = findViewById(R.id.btnAnalyzeText)
        tvResultText = findViewById(R.id.tvResultText)

        btnAnalyze.setOnClickListener {
            val text = etInputText.text.toString().trim()

            if (text.isEmpty()) {
                tvResultText.text = "Please enter some text first."
                return@setOnClickListener
            }

            // TODO: هنا هتربط بالموديل الحقيقي / API
            // مؤقتًا مثال بسيط يبان في البوكس
            val fakeResult = analyzeLocally(text)
            tvResultText.text = fakeResult
        }
    }

    // مثال مؤقت لعرض نتيجة شكلها منطقي لحد ما تربط بالموديل
    private fun analyzeLocally(input: String): String {
        // مجرد مثال غبي: لو فيه "happy" اعتبره سعيد، لو "sad" اعتبره حزين
        val lower = input.lowercase()
        return when {
            "happy" in lower || "love" in lower || "good" in lower ->
                "Predicted: HAPPY\nConfidence: 0.85\n\nText: \"$input\""
            "sad" in lower || "bad" in lower || "hate" in lower ->
                "Predicted: SAD\nConfidence: 0.80\n\nText: \"$input\""
            else ->
                "Predicted: NEUTRAL\nConfidence: 0.60\n\nText: \"$input\""
        }
    }
}