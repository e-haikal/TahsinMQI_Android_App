package com.siaptekno.tahsinmqi.ui.materi.chapter_two

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.material.chapterTwo.SubMaterialChapterTwo
import com.siaptekno.tahsinmqi.ui.materi.MaterialAdapter

class SubMaterialChapterTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub_materi_chapter_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_sub_materi_chapter_2_all)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val materials = listOf(
            SubMaterialChapterTwo(1, getString(R.string.sub_material_title_1), getString(R.string.sub_material_desc_1)),
            SubMaterialChapterTwo(2, getString(R.string.sub_material_title_2), getString(R.string.sub_material_desc_2)),
            SubMaterialChapterTwo(3, getString(R.string.sub_material_title_3), getString(R.string.sub_material_desc_3)),
            SubMaterialChapterTwo(4, getString(R.string.sub_material_title_4), getString(R.string.sub_material_desc_4)),
            SubMaterialChapterTwo(5, getString(R.string.sub_material_title_5), getString(R.string.sub_material_desc_5)),
            SubMaterialChapterTwo(6, getString(R.string.sub_material_title_6), getString(R.string.sub_material_desc_6)),
            SubMaterialChapterTwo(7, getString(R.string.sub_material_title_7), getString(R.string.sub_material_desc_7))

        )

        val adapter = SubMaterialChapterTwoAdapter(materials)
        recyclerView.adapter = adapter
    }
}
