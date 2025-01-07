package com.siaptekno.tahsinmqi.ui.materi.chapter_ten

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.FragmentMateriAyatGharibahBinding
import com.siaptekno.tahsinmqi.databinding.FragmentMateriLamTarifBinding
import com.siaptekno.tahsinmqi.databinding.FragmentMateriTandaWaqafBinding
import com.siaptekno.tahsinmqi.databinding.ItemMateriHukumIdghamBinding

class AyatGharibahFragment : Fragment() {

    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : FragmentMateriAyatGharibahBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer2: MediaPlayer? = null
    private var mediaPlayer3: MediaPlayer? = null
    private var mediaPlayer4: MediaPlayer? = null
    private var mediaPlayer5: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using the binding class
        _binding = FragmentMateriAyatGharibahBinding.inflate(inflater, container, false)

        val playButton2 = binding.ivBtnPlay2
        val playButton3 = binding.ivBtnPlay3
        val playButton4 = binding.ivBtnPlay4
        val playButton5 = binding.ivBtnPlay5

        mediaPlayer2 = MediaPlayer.create(requireContext(), R.raw.isymam)
        mediaPlayer3 = MediaPlayer.create(requireContext(), R.raw.imalah)
        mediaPlayer4 = MediaPlayer.create(requireContext(), R.raw.tashil)
        mediaPlayer5 = MediaPlayer.create(requireContext(), R.raw.naql)

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
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        // Hide the BottomNavigationView when the user is in this fragment.
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigationView.visibility = View.GONE
    }

    // Stop all audio and reset the players
    private fun stopAllAudio() {
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
    override fun onDestroyView() {
        super.onDestroyView()
        // Release both MediaPlayers
        mediaPlayer2?.release()
        mediaPlayer2 = null
        mediaPlayer3?.release()
        mediaPlayer3 = null
        mediaPlayer4?.release()
        mediaPlayer4 = null
        mediaPlayer5?.release()
        mediaPlayer5 = null

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