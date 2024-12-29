package com.siaptekno.tahsinmqi.ui.alquran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.response.DataItem
import com.siaptekno.tahsinmqi.databinding.ItemSurahBinding

class AlquranAdapter(private var listSurah: List<DataItem>) :
    RecyclerView.Adapter<AlquranAdapter.SurahViewHolder>() {

    inner class SurahViewHolder(private val binding: ItemSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: DataItem) {
            binding.tvSurahName.text = surah.name.translation.en
            binding.tvSurahNumber.text = surah.number.toString()
            binding.tvVerseCount.text = "${surah.numberOfVerses} Ayahs"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val binding = ItemSurahBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SurahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        holder.bind(listSurah[position])
    }

    override fun getItemCount() = listSurah.size

    fun updateData(newList: List<DataItem>) {
        listSurah = newList
        notifyDataSetChanged()
    }
}
