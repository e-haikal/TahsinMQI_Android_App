package com.siaptekno.tahsinmqi.ui.materi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.material.Material

class MaterialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_materi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_materi_all)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val materials = listOf(
            Material(1, getString(R.string.material_title_1), getString(R.string.material_desc_1)),
            Material(2, getString(R.string.material_title_2), getString(R.string.material_desc_2)),
            Material(3, getString(R.string.material_title_3), getString(R.string.material_desc_3)),
            Material(4, getString(R.string.material_title_4), getString(R.string.material_desc_4)),
            Material(5, getString(R.string.material_title_5), getString(R.string.material_desc_5)),
            Material(6, getString(R.string.material_title_6), getString(R.string.material_desc_6)),
            Material(7, getString(R.string.material_title_7), getString(R.string.material_desc_7)),
            Material(8, getString(R.string.material_title_8), getString(R.string.material_desc_8)),
            Material(9, getString(R.string.material_title_9), getString(R.string.material_desc_9)),
            Material(10, getString(R.string.material_title_10), getString(R.string.material_desc_10)),
            Material(11, getString(R.string.material_title_11), getString(R.string.material_desc_11))
        )

        val adapter = MaterialAdapter(materials)
        recyclerView.adapter = adapter
    }
}
