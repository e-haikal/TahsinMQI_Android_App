package com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.HaBesarFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.HamzahFragment


class MateriAlHalqAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        HamzahFragment(),
        HaBesarFragment()
        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}