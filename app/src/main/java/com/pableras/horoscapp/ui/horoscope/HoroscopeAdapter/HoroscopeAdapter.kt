package com.pableras.horoscapp.ui.horoscope.HoroscopeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pableras.horoscapp.R
import com.pableras.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var listaHoroscopeInfo: List<HoroscopeInfo> = emptyList(),
                       private val onItemSelected: (HoroscopeInfo) -> Unit) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(listaActualizada : List<HoroscopeInfo>) {
        listaHoroscopeInfo = listaActualizada
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount(): Int = listaHoroscopeInfo.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(listaHoroscopeInfo[position], onItemSelected)
    }

}