package com.siaptekno.tahsinmqi.ui.materi.chapter_two

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.material.Material
import com.siaptekno.tahsinmqi.data.material.chapterTwo.SubMaterialChapterTwo

class SubMaterialChapterTwoAdapter(private val subMaterialList: List<SubMaterialChapterTwo>,
                                   private val onItemClick: (SubMaterialChapterTwo) -> Unit
) :
    RecyclerView.Adapter<SubMaterialChapterTwoAdapter.SubMaterialChapterTwoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubMaterialChapterTwoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sub_materi_chapter_2, parent, false)
        return SubMaterialChapterTwoViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: SubMaterialChapterTwoViewHolder, position: Int) {
        val subMaterial = subMaterialList[position]
        holder.bind(subMaterial)
    }

    override fun getItemCount(): Int = subMaterialList.size

    class SubMaterialChapterTwoViewHolder(itemView: View, private val onItemClick: (SubMaterialChapterTwo) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tv_item_name)
        private val descTextView: TextView = itemView.findViewById(R.id.tv_item_description)

        fun bind(subMaterial: SubMaterialChapterTwo) {
            titleTextView.text = subMaterial.title
            descTextView.text = subMaterial.description

            // Set the click listener for the item view
            itemView.setOnClickListener {
                onItemClick(subMaterial)
            }
        }
    }
}
