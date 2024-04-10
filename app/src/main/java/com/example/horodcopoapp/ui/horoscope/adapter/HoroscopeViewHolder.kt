package com.example.horodcopoapp.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horodcopoapp.databinding.ItemHoroscopeBinding
import com.example.horodcopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo:HoroscopeInfo){
        val context = binding.ivHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvname.text = context.getString(horoscopeInfo.name)
    }
}