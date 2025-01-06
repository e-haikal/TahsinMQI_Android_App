package com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_belakang

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_belakang.fragment.KafFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_belakang.fragment.QofFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.DalFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.DzalFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.DzoFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.ShodFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.SinFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.TaFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.ThoFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.TsaFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.ZaiFragment

class MateriAlLisanBelakangAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        KafFragment(),
        QofFragment()

        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}