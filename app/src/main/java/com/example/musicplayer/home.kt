package com.example.musicplayer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Assuming you have a button with the id 'playlistButton' in your layout
        val playlistButton = view.findViewById<LinearLayout>(R.id.playlist_item)
        val songButton = view.findViewById<ImageView>(R.id.song_item)

        playlistButton.setOnClickListener {
            val intent = Intent(requireContext(), playlistOpen::class.java)
            startActivity(intent)
        }

        songButton.setOnClickListener {
            val intent = Intent(requireContext(), NowPlaying::class.java)
            startActivity(intent)
        }
    }


}

