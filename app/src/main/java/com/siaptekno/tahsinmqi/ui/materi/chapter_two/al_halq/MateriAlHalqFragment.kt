package com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.siaptekno.tahsinmqi.R

class MateriAlHalqFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_materi_al_halq, container, false)

        val viewPager = view.findViewById<ViewPager2>(R.id.vp_material_chapter_two)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        // Set up adapter for ViewPager2
        val adapter = MateriAlHalqAdapter(requireActivity())
        viewPager.adapter = adapter

        // Set up TabLayout with ViewPager2
        val tabTitles = listOf(
            getString(R.string.alif_sub_title),
            getString(R.string.ha_tebal_sub_title)
            // Add more titles if you add more fragments in the adapter
        )
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        return view
    }
}
