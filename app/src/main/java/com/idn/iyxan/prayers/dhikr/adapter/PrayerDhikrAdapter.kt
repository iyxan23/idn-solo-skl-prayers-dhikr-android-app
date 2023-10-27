package com.idn.iyxan.prayers.dhikr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.iyxan.prayers.dhikr.databinding.RowItemDzikirDoaBinding
import com.idn.iyxan.prayers.dhikr.model.PrayerDhikrItem

class PrayerDhikrAdapter(
    private val data: List<PrayerDhikrItem>
) : RecyclerView.Adapter<PrayerDhikrAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RowItemDzikirDoaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position].apply {
            holder.desc.text = desc
            holder.lafadz.text = lafadz
            holder.translation.text = translation
        }
    }

    inner class ViewHolder(binding: RowItemDzikirDoaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val lafadz = binding.tvLafaz
        val desc = binding.tvDesc
        val translation = binding.tvTerjemah
    }
}