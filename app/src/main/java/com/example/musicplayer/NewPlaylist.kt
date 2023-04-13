package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class NewPlaylist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_playlist)

        supportActionBar?.hide()
        val backButton = findViewById<ImageView>(R.id.imageView6)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

}