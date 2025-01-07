package com.siaptekno.tahsinmqi.ui.materi.chapter_seven

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siaptekno.tahsinmqi.ui.materi.chapter_seven.fragment.MadFariFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_seven.fragment.MadThabiiFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_three.fragment.BerlawananFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_three.fragment.TidakBerlawananFragment


class MateriHukumMadAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        MadThabiiFragment(),
        MadFariFragment()
        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}