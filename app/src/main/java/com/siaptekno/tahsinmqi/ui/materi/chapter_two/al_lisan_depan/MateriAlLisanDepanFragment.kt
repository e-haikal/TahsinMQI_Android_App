package com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.FragmentMateriAlHalqBinding
import com.siaptekno.tahsinmqi.databinding.FragmentMateriAlLisanDepanBinding

class MateriAlLisanDepanFragment : Fragment() {

    // Binding for the fragment's layout
    private var _binding: FragmentMateriAlLisanDepanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using View Binding
        _binding = FragmentMateriAlLisanDepanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up ViewPager2 and TabLayout
        val adapter = MateriAlLisanDepanAdapter(requireActivity())
        binding.vpMaterialChapterTwo.adapter = adapter

        val tabTitles = listOf(
            getString(R.string.ta_sub_title),
            getString(R.string.dal_sub_title),
            getString(R.string.tho_sub_title),
            getString(R.string.tsa_sub_title),
            getString(R.string.dzal_sub_title),
            getString(R.string.dzo_sub_title),
            getString(R.string.sin_sub_title),
            getString(R.string.zai_sub_title),
            getString(R.string.shod_sub_title)
        )
        TabLayoutMediator(binding.tabLayout, binding.vpMaterialChapterTwo) { tab, position ->
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
