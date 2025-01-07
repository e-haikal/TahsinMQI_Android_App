package com.siaptekno.tahsinmqi.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.material.Material
import com.siaptekno.tahsinmqi.databinding.FragmentHomeBinding
import com.siaptekno.tahsinmqi.ui.materi.MaterialAdapter
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_materi_home)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val materials = listOf(
            Material(1, getString(R.string.material_title_1), getString(R.string.material_desc_1)),
            Material(2, getString(R.string.material_title_2), getString(R.string.material_desc_2)),
            Material(3, getString(R.string.material_title_3), getString(R.string.material_desc_3)),
            Material(4, getString(R.string.material_title_4), getString(R.string.material_desc_4)),
            Material(5, getString(R.string.material_title_5), getString(R.string.material_desc_5)),
            Material(6, getString(R.string.material_title_6), getString(R.string.material_desc_6)),
            Material(7, getString(R.string.material_title_7), getString(R.string.material_desc_7)),
            Material(8, getString(R.string.material_title_8), getString(R.string.material_desc_8)),
            Material(9, getString(R.string.material_title_9), getString(R.string.material_desc_9)),
            Material(10, getString(R.string.material_title_10), getString(R.string.material_desc_10)),
            Material(11, getString(R.string.material_title_11), getString(R.string.material_desc_11))
        )

        val adapter = MaterialAdapter(materials) { material ->
            // Handle item click here
            when (material.id) {
                1 -> findNavController().navigate(R.id.navigation_home_to_subMaterialChapterOneFragment)
                2 -> findNavController().navigate(R.id.navigation_home_to_subMaterialChapterTwoFragment)
                3 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterThreeFragment)
                4 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterFourFragment)
                5 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterFiveFragment)
                6 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterSixFragment)
                7 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterSevenFragment)
                8 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterEightFragment)
                9 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterNineFragment)
                10 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterTenFragment)
                11 -> findNavController().navigate(R.id.navigation_home_to_MaterialChapterElevenFragment)

                // Add more cases for additional materials
            }
        }

        recyclerView.adapter = adapter

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}