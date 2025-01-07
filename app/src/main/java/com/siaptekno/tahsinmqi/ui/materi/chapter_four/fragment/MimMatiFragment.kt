package com.siaptekno.tahsinmqi.ui.materi.chapter_four.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.FragmentJadwalSholatBinding
import com.siaptekno.tahsinmqi.databinding.FragmentMateriBinding
import com.siaptekno.tahsinmqi.databinding.FragmentSubMateriChapter1Binding
import com.siaptekno.tahsinmqi.databinding.ItemMateriMimMatiBinding
import com.siaptekno.tahsinmqi.databinding.ItemMateriNunMatiBinding
import com.siaptekno.tahsinmqi.databinding.ItemMateriSifatBerlawananBinding
import com.siaptekno.tahsinmqi.databinding.ItemMateriSifatTidakBerlawananBinding

class MimMatiFragment : Fragment() {

    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : ItemMateriMimMatiBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null
    private var mediaPlayer3: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using the binding class
        _binding = ItemMateriMimMatiBinding.inflate(inflater, container, false)

        val playButton1 = binding.ivBtnPlay1
        val playButton2 = binding.ivBtnPlay2
        val playButton3 = binding.ivBtnPlay3

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.idgham_mimi)
        mediaPlayer2 = MediaPlayer.create(requireContext(), R.raw.ikhfa_syafawi)
        mediaPlayer3 = MediaPlayer.create(requireContext(), R.raw.idzhar_syafawi)

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.toolbar.setNavigationOnClickListener {
//            findNavController().navigateUp()
//        }
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
    }
    override fun onDestroyView() {
        super.onDestroyView()
        // Release both MediaPlayers
        mediaPlayer?.release()
        mediaPlayer = null
        mediaPlayer2?.release()
        mediaPlayer2 = null
        mediaPlayer3?.release()
        mediaPlayer3 = null

        _binding = null
    }
}