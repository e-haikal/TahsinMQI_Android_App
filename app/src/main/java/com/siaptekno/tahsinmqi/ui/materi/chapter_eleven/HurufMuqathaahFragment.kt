package com.siaptekno.tahsinmqi.ui.materi.chapter_eleven

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
import com.siaptekno.tahsinmqi.databinding.FragmentMateriHurufMuqathaahBinding
import com.siaptekno.tahsinmqi.databinding.FragmentMateriLamTarifBinding
import com.siaptekno.tahsinmqi.databinding.FragmentMateriTandaWaqafBinding
import com.siaptekno.tahsinmqi.databinding.ItemMateriHukumIdghamBinding

class HurufMuqathaahFragment : Fragment() {

    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : FragmentMateriHurufMuqathaahBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer1:MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null
    private var mediaPlayer3: MediaPlayer? = null
    private var mediaPlayer4: MediaPlayer? = null
    private var mediaPlayer5: MediaPlayer? = null
    private var mediaPlayer6:MediaPlayer? = null
    private var mediaPlayer7: MediaPlayer? = null
    private var mediaPlayer8: MediaPlayer? = null
    private var mediaPlayer9: MediaPlayer? = null
    private var mediaPlayer10: MediaPlayer? = null
    private var mediaPlayer11:MediaPlayer? = null
    private var mediaPlayer12: MediaPlayer? = null
    private var mediaPlayer13: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using the binding class
        _binding = FragmentMateriHurufMuqathaahBinding.inflate(inflater, container, false)

        val playButton1 = binding.ivBtnPlay1
        val playButton2 = binding.ivBtnPlay2
        val playButton3 = binding.ivBtnPlay3
        val playButton4 = binding.ivBtnPlay4
        val playButton5 = binding.ivBtnPlay5
        val playButton6 = binding.ivBtnPlay6
        val playButton7 = binding.ivBtnPlay7
        val playButton8 = binding.ivBtnPlay8
        val playButton9 = binding.ivBtnPlay9
        val playButton10 = binding.ivBtnPlay10
        val playButton11 = binding.ivBtnPlay11
        val playButton12 = binding.ivBtnPlay12
        val playButton13 = binding.ivBtnPlay13

        mediaPlayer1 = MediaPlayer.create(requireContext(), R.raw.alif_lam_mim)
        mediaPlayer2 = MediaPlayer.create(requireContext(), R.raw.alif_lam_mim_sad)
        mediaPlayer3 = MediaPlayer.create(requireContext(), R.raw.alif_lam_ra)
        mediaPlayer4 = MediaPlayer.create(requireContext(), R.raw.alif_lam_mim_ra)
        mediaPlayer5 = MediaPlayer.create(requireContext(), R.raw.kaf_ha_ya_ain_shod)
        mediaPlayer6 = MediaPlayer.create(requireContext(), R.raw.taha)
        mediaPlayer7 = MediaPlayer.create(requireContext(), R.raw.tho_sim_mim)
        mediaPlayer8 = MediaPlayer.create(requireContext(), R.raw.tho_sin)
        mediaPlayer9 = MediaPlayer.create(requireContext(), R.raw.yasin)
        mediaPlayer10 = MediaPlayer.create(requireContext(), R.raw.sod)
        mediaPlayer11 = MediaPlayer.create(requireContext(), R.raw.ha_mim_ain_sin_qaf)
        mediaPlayer12 = MediaPlayer.create(requireContext(), R.raw.qaf)
        mediaPlayer13 = MediaPlayer.create(requireContext(), R.raw.nun)

        playButton1.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer1?.isPlaying == false) {
                mediaPlayer1?.start()
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
        playButton6.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer6?.isPlaying == false) {
                mediaPlayer6?.start()
            }
        }
        playButton7.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer7?.isPlaying == false) {
                mediaPlayer7?.start()
            }
        }
        playButton8.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer8?.isPlaying == false) {
                mediaPlayer8?.start()
            }
        }
        playButton9.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer9?.isPlaying == false) {
                mediaPlayer9?.start()
            }
        }
        playButton10.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer10?.isPlaying == false) {
                mediaPlayer10?.start()
            }
        }
        playButton11.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer11?.isPlaying == false) {
                mediaPlayer11?.start()
            }
        }
        playButton12.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer12?.isPlaying == false) {
                mediaPlayer12?.start()
            }
        }
        playButton13.setOnClickListener {
            stopAllAudio()
            if (mediaPlayer13?.isPlaying == false) {
                mediaPlayer13?.start()
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
        mediaPlayer6?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer7?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer8?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer9?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer10?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer11?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer12?.let {
            if (it.isPlaying) {
                it.stop()
                it.prepare() // Reset to allow replaying
            }
        }
        mediaPlayer13?.let {
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
        mediaPlayer6?.release()
        mediaPlayer6 = null
        mediaPlayer7?.release()
        mediaPlayer7 = null
        mediaPlayer8?.release()
        mediaPlayer8 = null
        mediaPlayer9?.release()
        mediaPlayer9 = null
        mediaPlayer10?.release()
        mediaPlayer10 = null
        mediaPlayer11?.release()
        mediaPlayer11 = null
        mediaPlayer12?.release()
        mediaPlayer12 = null
        mediaPlayer13?.release()
        mediaPlayer13 = null

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