package com.siaptekno.tahsinmqi.ui.alqurandetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.siaptekno.tahsinmqi.data.AlquranDetailRepository
import com.siaptekno.tahsinmqi.data.retrofit.AlquranDetailApiConfig
import com.siaptekno.tahsinmqi.databinding.FragmentSurahDetailBinding

class AlquranDetailFragment : Fragment() {

    private var _binding: FragmentSurahDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AlquranDetailViewModel
    private var surahNumber: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            surahNumber = it.getInt("SURAH_NUMBER", 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurahDetailBinding.inflate(inflater, container, false)

        // Create repository instance
        val repository = AlquranDetailRepository(AlquranDetailApiConfig.getApiService())

        // Create the ViewModel with the repository
        val factory = AlquranDetailFactory(repository)
        viewModel = ViewModelProvider(this, factory)[AlquranDetailViewModel::class.java]

        setupRecyclerView()
        observeViewModel()
        viewModel.fetchSurahDetail(surahNumber)
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvDetailSurah.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        // Observe Surah detail data
        viewModel.surahDetail.observe(viewLifecycleOwner) { detail ->
            // Update UI with the fetched data
//            binding.tvSurahName.text = detail.name.transliteration.id
//            binding.tvSurahInfo.text =
//                "Surah ${detail.name.translation.id} • ${detail.revelation.id} • ${detail.numberOfVerses} Ayat"
            binding.rvDetailSurah.adapter = AlquranDetailAdapter(detail.verses)
            binding.progressBar.visibility = View.GONE // Hide progress bar once data is loaded
        }

        // Observe error messages
        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            Log.d("AlquranDetailFragment", "Error message: $message")
            binding.progressBar.visibility = View.GONE // Hide progress bar on error
        }

        // Show progress bar while data is being fetched
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
