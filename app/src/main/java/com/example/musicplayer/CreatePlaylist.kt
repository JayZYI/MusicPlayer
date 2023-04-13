package com.example.musicplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView

class CreatePlaylist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_playlist)

            supportActionBar?.hide()

            val backButton = findViewById<ImageView>(R.id.imageView8)
            backButton.setOnClickListener {
                onBackPressed()
            }

        val editText = findViewById<EditText>(R.id.editTextTextPersonName)

        editText.setOnEditorActionListener { textView, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // User pressed the 'Done' button
                val intent = Intent(this, NewPlaylist::class.java)
                startActivity(intent)
                true // Return true to indicate we've handled the event
            } else {
                false // Return false to indicate we haven't handled the event
            }
        }
        }
        override fun onBackPressed() {
            super.onBackPressed()
            // Pop the current fragment from the back stack to go back to the previous fragment
            supportFragmentManager.popBackStack()
        }
}