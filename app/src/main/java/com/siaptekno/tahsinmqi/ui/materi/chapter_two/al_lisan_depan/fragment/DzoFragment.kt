package com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.siaptekno.tahsinmqi.R

class DzoFragment : Fragment() {
    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_materi_lisan_depan_dzo, container, false)

        val audioButton = view.findViewById<Button>(R.id.btn_audio)
        val contohButton = view.findViewById<Button>(R.id.btn_contoh)
        val stopButton = view.findViewById<Button>(R.id.btn_stop)

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.dzo_audio)
        mediaPlayer2 = MediaPlayer.create(requireContext(), R.raw.dzo_syair_audio)


        // Play the first audio
        audioButton.setOnClickListener {
            stopAllAudio() // Stop any currently playing audio
            if (mediaPlayer?.isPlaying == false) {
                mediaPlayer?.start()
            }
        }

        // Play the second audio
        contohButton.setOnClickListener {
            stopAllAudio() // Stop any currently playing audio
            if (mediaPlayer2?.isPlaying == false) {
                mediaPlayer2?.start()
            }
        }

        // Stop both audios
        stopButton.setOnClickListener {
            stopAllAudio()
        }

        return view
    }

    // Stop all audio and reset the players
    private fun stopAllAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer2?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release both MediaPlayers
        mediaPlayer?.release()
        mediaPlayer = null
        mediaPlayer2?.release()
        mediaPlayer2 = null
    }
}