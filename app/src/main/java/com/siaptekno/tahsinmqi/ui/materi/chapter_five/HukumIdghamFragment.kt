package com.siaptekno.tahsinmqi.ui.materi.chapter_five

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.ItemMateriHukumIdghamBinding

class HukumIdghamFragment : Fragment() {

    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : ItemMateriHukumIdghamBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null
    private var mediaPlayer3: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using the binding class
        _binding = ItemMateriHukumIdghamBinding.inflate(inflater, container, false)

        val playButton1 = binding.ivBtnPlay1
        val playButton2 = binding.ivBtnPlay2
        val playButton3 = binding.ivBtnPlay3

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.mutamatsilain)
        mediaPlayer2 = MediaPlayer.create(requireContext(), R.raw.mutajanisain)
        mediaPlayer3 = MediaPlayer.create(requireContext(), R.raw.mutaqaribain)

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
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        // Hide the BottomNavigationView when the user is in this fragment.
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigationView.visibility = View.GONE
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

        val navController = findNavController()
        val destinationId = navController.currentDestination?.id
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)

        // Show BottomNavigationView only if navigating to the HomeFragment.
        if (destinationId == R.id.navigation_home) {
            bottomNavigationView.visibility = View.VISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
        }
        _binding = null
    }
}