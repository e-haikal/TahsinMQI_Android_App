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
import com.siaptekno.tahsinmqi.databinding.ItemMateriNunMatiBinding
import com.siaptekno.tahsinmqi.databinding.ItemMateriSifatBerlawananBinding
import com.siaptekno.tahsinmqi.databinding.ItemMateriSifatTidakBerlawananBinding

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
        return binding.root

        val playButton1 = binding.ivBtnPlay1
        val playButton2 = binding.ivBtnPlay2
        val playButton3 = binding.ivBtnPlay3
        val playButton4 = binding.ivBtnPlay4
        val playButton5 = binding.ivBtnPlay5

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.nun_mati_audio)
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
}