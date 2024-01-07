package com.pableras.horoscapp.ui.horoscope.HoroscopeAdapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.pableras.horoscapp.databinding.ItemHoroscopeBinding
import com.pableras.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val contexto = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = contexto.getString(horoscopeInfo.name)

        binding.layoutViewHolder.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope, funcionLambda = {onItemSelected(horoscopeInfo)})
        }
    }

    private fun startRotationAnimation(view: View, funcionLambda: () -> Unit) {
        view.animate().apply {
            duration = 300
            interpolator = LinearInterpolator()
            scaleY(0.8f)
            scaleX(0.8f)
            withEndAction {
                scaleY(1f)
                scaleX(1f)
                funcionLambda()
            } // <-- Como función lambda, se ejecuta después ejecutar la animación
            start()
        }
    }
}