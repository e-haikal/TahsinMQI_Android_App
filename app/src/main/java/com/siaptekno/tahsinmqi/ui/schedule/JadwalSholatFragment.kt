package com.siaptekno.tahsinmqi.ui.schedule

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.siaptekno.tahsinmqi.databinding.FragmentJadwalSholatBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class JadwalSholatFragment : Fragment() {

    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : FragmentJadwalSholatBinding? = null
    private val binding get() = _binding!!

    private val viewModel: JadwalSholatViewModel by viewModels()

    private val handler = Handler(Looper.getMainLooper())
    private val timeUpdater = object : Runnable {
        override fun run() {
            setCurrentTime()
            // Repeat this runnable every second
            handler.postDelayed(this, 1000)
        }
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

        // Start updating the current time
        handler.post(timeUpdater)

        observeViewModel()

        // Fetch the schedule when the fragment is created
        viewModel.fetchSchedule()

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

    }

    private fun setCurrentTime() {
        // Get current time
        val currentTime = Calendar.getInstance().time
        // Format the current time into a readable format (HH:mm:ss)
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val formattedTime = timeFormat.format(currentTime)

        // Set the formatted time to the TextView
        binding.tvPlaceholderCurrentTime.text = formattedTime
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }

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

        // Stop the time updater when the view is destroyed
        handler.removeCallbacks(timeUpdater)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}