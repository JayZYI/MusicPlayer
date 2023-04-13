package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class NowPlaying : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_now_playing)
        supportActionBar?.hide()
        val backButton = findViewById<ImageView>(R.id.imageView6)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        // Pop the current fragment from the back stack to go back to the previous fragment
        supportFragmentManager.popBackStack()
    }
}