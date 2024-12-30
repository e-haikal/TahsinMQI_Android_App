package com.siaptekno.tahsinmqi.ui.alqurandetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.siaptekno.tahsinmqi.databinding.FragmentSurahDetailBinding
import com.siaptekno.tahsinmqi.data.Result
import com.siaptekno.tahsinmqi.data.responsedetail.AlquranDetailResponse


class AlquranDetailFragment : Fragment() {

    private var _binding: FragmentSurahDetailBinding? = null
    private val binding get() = _binding!!
    private val alquranDetailViewModel: AlquranDetailViewModel by viewModels {
        AlquranDetailFactory() // Use ViewModelFactory to inject the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSurahDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example Surah ID, ideally passed through arguments or navigation
        val surahId = 1 // Example: Surah 1 (Al-Fatiha)

        // Observe the AlquranDetail data from the ViewModel
        alquranDetailViewModel.alquranDetail.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE // Show progress bar while loading
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE // Hide progress bar when data is loaded
                    displaySurahDetail(result.data) // Display the Surah details
                }
                is Result.Error -> {
                    binding.progressBar.visibility = View.GONE // Hide progress bar on error
                    showError(result.error) // Show error message
                }
            }
        })

        // Fetch Surah details when fragment is created
        alquranDetailViewModel.getSurahDetail(surahId)
    }

    // Function to display the Surah details
    private fun displaySurahDetail(response: AlquranDetailResponse) {
        val verse = response.data.verses[0] // Example: Display the first verse

        binding.tvVerseNumber.text = verse.number.inSurah.toString() // Set verse number
        binding.tvPlaceholderVerse.text = verse.text.arab // Set Arabic verse text
        binding.tvVerseTranslation.text = verse.translation.en // Set verse translation
    }

    // Function to handle error
    private fun showError(message: String) {
        // Handle error display (e.g., show a Toast or Snackbar)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Clean up binding when the view is destroyed
    }
}