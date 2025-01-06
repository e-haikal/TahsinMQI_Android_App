package com.siaptekno.tahsinmqi.ui.materi.chapter_four.fragment

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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using the binding class
        _binding = ItemMateriMimMatiBinding.inflate(inflater, container, false)
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
}