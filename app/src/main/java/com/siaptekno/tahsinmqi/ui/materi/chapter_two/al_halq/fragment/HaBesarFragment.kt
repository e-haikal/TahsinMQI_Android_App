package com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.siaptekno.tahsinmqi.R

class HaBesarFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_materi_alhalq_ha_besar, container, false)

        val audioButton = view.findViewById<Button>(R.id.btn_audio)
//        val contohButton = view.findViewById<Button>(R.id.btn_contoh)
        val stopButton = view.findViewById<Button>(R.id.btn_stop)

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ha_besar_audio)

        audioButton.setOnClickListener {
            if (mediaPlayer?.isPlaying == false) {
                mediaPlayer?.start()
            }
        }

        stopButton.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.hamzah_audio)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}