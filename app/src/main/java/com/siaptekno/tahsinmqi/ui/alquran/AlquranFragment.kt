package com.siaptekno.tahsinmqi.ui.alquran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.FragmentSurahListBinding

class AlquranFragment : Fragment() {

    private var _binding: FragmentSurahListBinding? = null
    private val binding get() = _binding!!
    private lateinit var alquranViewModel: AlquranViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurahListBinding.inflate(inflater, container, false)
        alquranViewModel = ViewModelProvider(this).get(AlquranViewModel::class.java)
        setupRecyclerView()
        observeViewModel()
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvListSurah.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        alquranViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }

        alquranViewModel.listSurah.observe(viewLifecycleOwner) { listSurah ->
            val adapter = AlquranAdapter(listSurah) { dataItem ->
                // Add navigation to Surah Detail here
                val bundle = Bundle().apply {
                    putInt("SURAH_NUMBER", dataItem.number)
                }
                findNavController().navigate(R.id.action_alquranFragment_to_alquranDetailFragment, bundle)
            }
            binding.rvListSurah.adapter = adapter
        }

        alquranViewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}