package com.siaptekno.tahsinmqi.ui.materi.chapter_two.asy_syafatan

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.DalFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.DzalFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.DzoFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.ShodFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.SinFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.TaFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.ThoFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.TsaFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_depan.fragment.ZaiFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_tengah.fragment.DhodFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_tengah.fragment.JimFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_tengah.fragment.LamFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_tengah.fragment.NunFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_tengah.fragment.RoFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_tengah.fragment.SyinFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.al_lisan_tengah.fragment.YaFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.asy_syafatan.fragment.BaFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.asy_syafatan.fragment.FaFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.asy_syafatan.fragment.MimFragment
import com.siaptekno.tahsinmqi.ui.materi.chapter_two.asy_syafatan.fragment.WawFragment

class MateriAsySyafatanAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        FaFragment(),
        BaFragment(),
        MimFragment(),
        WawFragment()
        // Add more fragments as needed
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}