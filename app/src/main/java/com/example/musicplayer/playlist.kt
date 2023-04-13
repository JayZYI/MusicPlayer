package com.example.musicplayer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [playlist.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlaylistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Assuming you have a button with the id 'playlistButton' in your layout
        val playlistButton = view.findViewById<FrameLayout>(R.id.playlist_item)
        val playlistCreate = view.findViewById<LinearLayout>(R.id.playlist_create)

        playlistButton.setOnClickListener {
            val intent = Intent(requireContext(), playlistOpen::class.java)
            startActivity(intent)
        }
        playlistCreate.setOnClickListener {
            val intent = Intent(requireContext(), CreatePlaylist::class.java)
            startActivity(intent)
        }
    }

//    fun blurImageView(context: Context, imageView: ImageView, radius: Float) {
//        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.background_image)
//        val blurBitmap = blurBitmap(context, bitmap, radius)
//        imageView.setImageBitmap(blurBitmap)
//    }

    private fun blurBitmap(context: Context, bitmap: Bitmap, radius: Float): Bitmap {
        val renderScript = RenderScript.create(context)
        val input = Allocation.createFromBitmap(renderScript, bitmap)
        val output = Allocation.createTyped(renderScript, input.type)
        val blur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))
        blur.setInput(input)
        blur.setRadius(radius)
        blur.forEach(output)
        output.copyTo(bitmap)
        renderScript.destroy()
        return bitmap
    }
}
