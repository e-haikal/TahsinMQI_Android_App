package com.siaptekno.tahsinmqi.ui.schedule

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.FragmentJadwalSholatBinding

class JadwalSholatFragment : Fragment() {

    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : FragmentJadwalSholatBinding? = null
    private val binding get() = _binding!!

    private val viewModel: JadwalSholatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using the binding class
        _binding = FragmentJadwalSholatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()

        // Fetch the schedule when the fragment is created
        viewModel.fetchSchedule()
    }

    private fun observeViewModel() {
        viewModel.schedule.observe(viewLifecycleOwner) { schedule ->
            // Update UI with fetched data
            binding.tvPlaceholderLocation.text = schedule.data.lokasi
            binding.tvPlaceholderCurrentDate.text = schedule.data.jadwal.tanggal
            binding.tvPlaceholderImsakTime.text = schedule.data.jadwal.imsak
            binding.tvPlaceholderShubuhTime.text = schedule.data.jadwal.subuh
            binding.tvPlaceholderSyurukTime.text = schedule.data.jadwal.terbit
            binding.tvPlaceholderDzuhurTime.text = schedule.data.jadwal.dzuhur
            binding.tvPlaceholderAsharTime.text = schedule.data.jadwal.ashar
            binding.tvPlaceholderMaghribTime.text = schedule.data.jadwal.maghrib
            binding.tvPlaceholderIsyaTime.text = schedule.data.jadwal.isya
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}