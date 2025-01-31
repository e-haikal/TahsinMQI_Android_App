package com.siaptekno.tahsinmqi.ui.schedule

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siaptekno.tahsinmqi.ui.materi.chapter_three.fragment.BerlawananFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_three.fragment.TidakBerlawananFragment
import com.siaptekno.tahsinmqi.ui.schedule.fragment.JadwalSholatFragment
import com.siaptekno.tahsinmqi.ui.schedule.fragment.JadwalTahsinFragment


class JadwalAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments: List<Fragment> = listOf(
        JadwalSholatFragment(),
        JadwalTahsinFragment()
        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}