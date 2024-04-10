package com.example.horodcopoapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horodcopoapp.databinding.ItemHoroscopeBinding
import com.example.horodcopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.ivHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvname.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, onNewItemSelected = {

                onItemSelected(horoscopeInfo)
            })
        }
    }

    private fun startRotationAnimation(view: View, onNewItemSelected: () -> Unit) {
        view.animate().apply {
            duration = 500   // milis
            interpolator = LinearInterpolator()
            rotationBy(360f) // 1 volta sancera
            withEndAction {
                onNewItemSelected()
            }
            start()
        }


    }

}