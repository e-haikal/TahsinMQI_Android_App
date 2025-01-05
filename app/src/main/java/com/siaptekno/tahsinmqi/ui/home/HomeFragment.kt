package com.siaptekno.tahsinmqi.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.FragmentHomeBinding
import com.siaptekno.tahsinmqi.ui.tanyaaitahsin.ChatActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Observe current time and update the TextView
        homeViewModel.currentTime.observe(viewLifecycleOwner) { time ->
            binding.tvPlaceholderClock.text = time
        }

        // Set up the click listener for the schedule menu item
        binding.layoutClickSchedule.setOnClickListener {
            findNavController().navigate(R.id.navigation_schedule) // Ensure the ID matches the navigation graph
        }
//        binding.layoutClickAlquran.setOnClickListener {
//            findNavController().navigate(R.id.navigation_alquran) // Ensure the ID matches the navigation graph
//        }
        // Set up the click listener for the Chat Activity navigation
        binding.layoutClickAlquran.setOnClickListener {
            val intent = Intent(requireContext(), ChatActivity::class.java)
            startActivity(intent)
        }

        binding.layoutClickMaterial.setOnClickListener {
            findNavController().navigate(R.id.navigation_material) // Ensure the ID matches the navigation graph
        }

        binding.tvSeeMore.setOnClickListener {
            findNavController().navigate(R.id.navigation_material) // Ensure the ID matches the navigation graph
        }


        // Hide the ActionBar when this fragment is created
        requireActivity().actionBar?.hide()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}