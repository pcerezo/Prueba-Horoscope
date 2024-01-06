package com.pableras.horoscapp.data.providers

import com.pableras.horoscapp.domain.model.HoroscopeInfo
import com.pableras.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){ // <-- Permite esta clase ser inyectada en otras clases
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries, Tauro, Geminis, Aquario, Cancer, Capricornio,
            Escorpio, Leo, Libra, Piscis, Sagitario, Virgo
        )
    }
}