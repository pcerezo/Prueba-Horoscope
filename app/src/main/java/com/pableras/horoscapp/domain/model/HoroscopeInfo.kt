package com.pableras.horoscapp.domain.model

import com.pableras.horoscapp.R

sealed class HoroscopeInfo(val img: Int, val name: Int) {
    object Aries: HoroscopeInfo(R.drawable.aries, R.string.aries)
    object Tauro: HoroscopeInfo(R.drawable.tauro, R.string.taurus)
    object Geminis: HoroscopeInfo(R.drawable.geminis, R.string.geminis)
    object Cancer: HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    object Leo: HoroscopeInfo(R.drawable.leo, R.string.leo)
    object Virgo: HoroscopeInfo(R.drawable.virgo, R.string.virgo)
    object Libra: HoroscopeInfo(R.drawable.libra, R.string.libra)
    object Escorpio: HoroscopeInfo(R.drawable.escorpio, R.string.escorpio)
    object Sagitario: HoroscopeInfo(R.drawable.sagitario, R.string.sagitario)
    object Capricornio: HoroscopeInfo(R.drawable.capricornio, R.string.capricornio)
    object Aquario: HoroscopeInfo(R.drawable.aquario, R.string.aquario)
    object Piscis: HoroscopeInfo(R.drawable.piscis, R.string.piscis)

}