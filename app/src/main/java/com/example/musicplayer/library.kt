package com.example.musicplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [library.newInstance] factory method to
 * create an instance of this fragment.
 */
class LibraryFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var fragmentContainer: FrameLayout
    private lateinit var tracksButton: Button
    private lateinit var playlistButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_library, container, false)

        // Get the TabLayout, FrameLayout, and Button references
        tabLayout = view.findViewById(R.id.tab_layout)
        fragmentContainer = view.findViewById(R.id.fragment_container)
        tracksButton = view.findViewById(R.id.tracks_button)
        playlistButton = view.findViewById(R.id.playlist_button)

        // Create and add tabs to the TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Tracks"))
        tabLayout.addTab(tabLayout.newTab().setText("Playlist"))

        // Set the TabLayout OnTabSelectedListener
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Get the selected tab position and load the corresponding fragment
                val position = tab?.position
                when (position) {
                    0 -> {
                        loadFragment(TracksFragment())
                    }
                    1 -> {
                        loadFragment(PlaylistFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // Load the initial fragment (TracksFragment)
        loadFragment(TracksFragment())

        // Set onClickListener for tracksButton to load the TracksFragment
        tracksButton.setOnClickListener {
            loadFragment(TracksFragment())
            tabLayout.getTabAt(0)?.select()
        }

        // Set onClickListener for playlistButton to load the PlaylistFragment
        playlistButton.setOnClickListener {
            loadFragment(PlaylistFragment())
            tabLayout.getTabAt(1)?.select()
        }

        return view
    }

    // Load the specified fragment into the FrameLayout
    private fun loadFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
