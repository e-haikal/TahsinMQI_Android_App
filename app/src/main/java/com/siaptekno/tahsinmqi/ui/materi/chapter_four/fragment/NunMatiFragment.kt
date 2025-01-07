package com.siaptekno.tahsinmqi.ui.materi.chapter_four.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.ItemMateriNunMatiBinding

class NunMatiFragment : Fragment() {

    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : ItemMateriNunMatiBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null
    private var mediaPlayer3: MediaPlayer? = null
    private var mediaPlayer4: MediaPlayer? = null
    private var mediaPlayer5: MediaPlayer? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using the binding class
        _binding = ItemMateriNunMatiBinding.inflate(inflater, container, false)

        val playButton1 = binding.ivBtnPlay1
        val playButton2 = binding.ivBtnPlay2
        val playButton3 = binding.ivBtnPlay3
        val playButton4 = binding.ivBtnPlay4
        val playButton5 = binding.ivBtnPlay5

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.idzhar)
        mediaPlayer2 = MediaPlayer.create(requireContext(), R.raw.bighunnah)
        mediaPlayer3 = MediaPlayer.create(requireContext(), R.raw.bilaghunnah)
        mediaPlayer4 = MediaPlayer.create(requireContext(), R.raw.iqlab)
        mediaPlayer5 = MediaPlayer.create(requireContext(), R.raw.ikhfa)

        playButton1.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer?.isPlaying == false) {
                mediaPlayer?.start()
            }
        }
        playButton2.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer2?.isPlaying == false) {
                mediaPlayer2?.start()
            }
        }
        playButton3.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer3?.isPlaying == false) {
                mediaPlayer3?.start()
            }
        }
        playButton4.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer4?.isPlaying == false) {
                mediaPlayer4?.start()
            }
        }
        playButton5.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer5?.isPlaying == false) {
                mediaPlayer5?.start()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.toolbar.setNavigationOnClickListener {
//            findNavController().navigateUp()
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

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
        mediaPlayer3?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer4?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer5?.let {
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
        mediaPlayer3?.release()
        mediaPlayer3 = null
        mediaPlayer4?.release()
        mediaPlayer4 = null
        mediaPlayer5?.release()
        mediaPlayer5 = null
    }
}