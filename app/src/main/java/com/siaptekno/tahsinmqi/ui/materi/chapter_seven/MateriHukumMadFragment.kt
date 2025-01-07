package com.siaptekno.tahsinmqi.ui.materi.chapter_seven

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.FragmentMateriHukumMadBinding

class MateriHukumMadFragment : Fragment() {

    // Binding for the fragment's layout
    private var _binding: FragmentMateriHukumMadBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using View Binding
        _binding = FragmentMateriHukumMadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up ViewPager2 and TabLayout
        val adapter = MateriHukumMadAdapter(requireActivity())
        binding.vpMaterialChapterSeven.adapter = adapter

        val tabTitles = listOf(
            getString(R.string.mad_thabii),
            getString(R.string.mad_fari)
        )
        TabLayoutMediator(binding.tabLayout, binding.vpMaterialChapterSeven) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        // Set up navigation for the toolbar
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp() // Navigate back to the previous fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
