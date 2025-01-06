package com.siaptekno.tahsinmqi.ui.materi.chapter_two

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.material.chapterTwo.SubMaterialChapterTwo
import com.siaptekno.tahsinmqi.databinding.FragmentMateriBinding
import com.siaptekno.tahsinmqi.databinding.FragmentSubMateriChapter2Binding
import com.siaptekno.tahsinmqi.ui.materi.MaterialAdapter

class SubMaterialChapterTwoFragment : Fragment() {
    // Binding for the fragment's layout. Nullable to handle lifecycle management properly.
    private var _binding : FragmentSubMateriChapter2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubMateriChapter2Binding.inflate(inflater, container, false)
        return binding.root
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

        val adapter = SubMaterialChapterTwoAdapter(materials) { material ->
            when (material.id) {
                1 -> findNavController().navigate(R.id.action_subMaterialChapterTwoFragment_to_sub_material_chapter_two_al_jauf)
                2 -> findNavController().navigate(R.id.action_subMaterialChapterTwoFragment_to_sub_material_chapter_two_al_halq)
                3 -> findNavController().navigate(R.id.action_subMaterialChapterTwoFragment_to_sub_material_chapter_two_al_lisan_depan)

            }

        }

        recyclerView.adapter = adapter

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
