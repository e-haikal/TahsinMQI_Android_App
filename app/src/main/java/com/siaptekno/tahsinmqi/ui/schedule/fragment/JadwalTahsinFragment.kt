package com.siaptekno.tahsinmqi.ui.schedule.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.siaptekno.tahsinmqi.databinding.ItemJadwalTahsinBinding

class JadwalTahsinFragment: Fragment () {
    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : ItemJadwalTahsinBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using the binding class
        _binding = ItemJadwalTahsinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}
