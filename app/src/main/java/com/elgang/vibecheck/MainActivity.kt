package com.elgang.vibecheck

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var cardTextAnalysis: LinearLayout
    private lateinit var cardAudioAnalysis: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarMain)
        setSupportActionBar(toolbar)
        // we use our own title TextView
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // LEFT: team logo → go directly to TeamMembersActivity
        val ivTeamIcon = findViewById<ImageView>(R.id.ivTeamIcon)
        ivTeamIcon.setOnClickListener {
            startActivity(Intent(this, TeamMembersActivity::class.java))
        }

        // MAIN CARDS
        cardTextAnalysis = findViewById(R.id.cardTextAnalysis)
        cardAudioAnalysis = findViewById(R.id.cardAudioAnalysis)

        cardTextAnalysis.setOnClickListener {
            startActivity(Intent(this, TextAnalysisActivity::class.java))
        }

        cardAudioAnalysis.setOnClickListener {
            startActivity(Intent(this, AudioAnalysisActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // RIGHT: about icon in menu → will navigate to SupervisionActivity
        menuInflater.inflate(R.menu.menu_main_top, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // DIRECT NAVIGATION to supervision page
            R.id.action_supervision -> {
                startActivity(Intent(this, SupervisionActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}