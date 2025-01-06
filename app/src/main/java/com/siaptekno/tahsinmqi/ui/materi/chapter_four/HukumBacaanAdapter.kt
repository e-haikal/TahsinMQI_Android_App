package com.siaptekno.tahsinmqi.ui.materi.chapter_four

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siaptekno.tahsinmqi.ui.materi.chapter_four.fragment.MimMatiFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_four.fragment.NunMatiFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_three.fragment.BerlawananFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_three.fragment.TidakBerlawananFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.AinFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.GhainFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.HaBesarFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.HaKecilFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.HamzahFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_halq.fragment.KhaFragment


class HukumBacaanAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        NunMatiFragment(),
        MimMatiFragment()
        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}