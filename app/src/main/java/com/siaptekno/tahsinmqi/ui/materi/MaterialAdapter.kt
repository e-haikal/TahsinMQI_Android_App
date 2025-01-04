package com.siaptekno.tahsinmqi.ui.materi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.material.Material

class MaterialAdapter(private val materialList: List<Material>) :
    RecyclerView.Adapter<MaterialAdapter.MaterialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_materi, parent, false)
        return MaterialViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val material = materialList[position]
        holder.bind(material)
    }

    override fun getItemCount(): Int = materialList.size

    class MaterialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tv_item_name)
        private val descTextView: TextView = itemView.findViewById(R.id.tv_item_description)

        fun bind(material: Material) {
            titleTextView.text = material.title
            descTextView.text = material.description
        }
    }
}
