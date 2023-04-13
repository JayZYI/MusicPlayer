package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class playlistOpen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_open)


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