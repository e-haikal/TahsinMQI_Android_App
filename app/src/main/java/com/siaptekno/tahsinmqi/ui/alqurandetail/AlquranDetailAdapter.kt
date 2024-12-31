package com.siaptekno.tahsinmqi.ui.alqurandetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.data.responsedetail.VersesItem
import com.siaptekno.tahsinmqi.databinding.ItemSurahDetailBinding

class AlquranDetailAdapter(private val verses: List<VersesItem>) :
    RecyclerView.Adapter<AlquranDetailAdapter.VerseViewHolder>() {

    inner class VerseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemSurahDetailBinding.bind(view)
        fun bind(verse: VersesItem) {
            binding.tvVerseNumber.text = verse.number.inSurah.toString()
            binding.tvPlaceholderVerse.text = verse.text.arab
            binding.tvVerseTranslation.text = verse.translation.id

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_surah_detail, parent, false)
        return VerseViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        holder.bind(verses[position])
    }

    override fun getItemCount() = verses.size
}