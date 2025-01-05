package com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MateriAlLisanDepanAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        TaFragment(),
        DalFragment(),
        ThoFragment(),
        TsaFragment(),
        DzalFragment(),
        DzoFragment(),
        SinFragment(),
        ZaiFragment(),
        ShodFragment()
        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}