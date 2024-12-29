package com.siaptekno.tahsinmqi.ui.alquran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.siaptekno.tahsinmqi.data.AlquranRepository
import com.siaptekno.tahsinmqi.data.retrofit.AlquranApiConfig
import com.siaptekno.tahsinmqi.databinding.FragmentAlquranBinding

class AlquranFragment : Fragment() {

    private var _binding: FragmentAlquranBinding? = null
    private val binding get() = _binding!!
    private lateinit var alquranViewModel: AlquranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlquranBinding.inflate(inflater, container, false)
        val repository = AlquranRepository(AlquranApiConfig.getApiService())
        alquranViewModel = ViewModelProvider(this, AlquranViewModelFactory(repository))[AlquranViewModel::class.java]

        setupRecyclerView()
        observeViewModel()

        alquranViewModel.fetchListSurah()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvAlquran.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAlquran.adapter = AlquranAdapter(emptyList()) // Initially empty
    }

    private fun observeViewModel() {
        alquranViewModel.listSurah.observe(viewLifecycleOwner) { listSurah ->
            (binding.rvAlquran.adapter as AlquranAdapter).updateData(listSurah)
        }

        alquranViewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}