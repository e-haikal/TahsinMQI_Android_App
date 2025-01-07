package com.siaptekno.tahsinmqi.ui.materi.chapter_eight

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siaptekno.tahsinmqi.ui.materi.chapter_eight.fragment.TafkhimFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_eight.fragment.TarqiqFragment

class MateriTafkhimTarqiqAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        TafkhimFragment(),
        TarqiqFragment()
        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}