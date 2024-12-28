package com.siaptekno.tahsinmqi.ui.schedule

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.siaptekno.tahsinmqi.R

class JadwalSholatFragment : Fragment() {

    companion object {
        fun newInstance() = JadwalSholatFragment()
    }

    private val viewModel: JadwalSholatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_jadwal_sholat, container, false)
    }
}