package com.siaptekno.tahsinmqi.ui.materi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.material.Material
import com.siaptekno.tahsinmqi.databinding.FragmentJadwalSholatBinding
import com.siaptekno.tahsinmqi.databinding.FragmentMateriBinding

class MaterialFragment : Fragment() {
    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : FragmentMateriBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using the binding class
        _binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_materi_all)
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
                1 -> findNavController().navigate(R.id.action_materialFragment_to_subMaterialChapterOneFragment)
                2 -> findNavController().navigate(R.id.action_materialFragment_to_subMaterialChapterTwoFragment)
                3 -> findNavController().navigate(R.id.action_materialFragment_to_MaterialChapterThreeFragment)
                // Add more cases for additional materials
            }
        }

        recyclerView.adapter = adapter

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        // Hide the BottomNavigationView when the user is in this fragment.
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigationView.visibility = View.GONE
    }

    // Called when the fragment's view is destroyed, ensuring cleanup and visibility adjustments.
    override fun onDestroyView() {
        super.onDestroyView()
        val navController = findNavController()
        val destinationId = navController.currentDestination?.id
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)

        // Show BottomNavigationView only if navigating to the HomeFragment.
        if (destinationId == R.id.navigation_home) {
            bottomNavigationView.visibility = View.VISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
        }
        _binding = null
    }
}
