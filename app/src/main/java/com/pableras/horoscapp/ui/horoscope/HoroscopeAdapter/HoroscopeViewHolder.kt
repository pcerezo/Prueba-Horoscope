package com.pableras.horoscapp.ui.horoscope.HoroscopeAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pableras.horoscapp.databinding.ItemHoroscopeBinding
import com.pableras.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo) {

    }
}