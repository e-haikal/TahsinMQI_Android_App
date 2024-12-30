package com.siaptekno.tahsinmqi.ui.alquran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.response.DataItem
import com.siaptekno.tahsinmqi.databinding.ItemSurahListBinding

class AlquranAdapter(private val listSurah: List<DataItem>, private val onItemClick: (DataItem) -> Unit) :
    RecyclerView.Adapter<AlquranAdapter.SurahViewHolder>() {

    inner class SurahViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemSurahListBinding.bind(view)
        fun bind(dataItem: DataItem) {
            binding.tvSurahName.text = dataItem.name.transliteration.id
            binding.tvSurahTotalVerse.text = "${dataItem.numberOfVerses} ayat"
            itemView.setOnClickListener { onItemClick(dataItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_surah_list, parent, false)
        return SurahViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        holder.bind(listSurah[position])
    }

    override fun getItemCount() = listSurah.size
}