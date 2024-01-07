package com.pableras.horoscapp.ui.detail

sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState() // <-- Sencillo, no requiere parámetros
    data class Error(val error:String): HoroscopeDetailState() // <-- Cuando hay que pasarle parámetros
    data class Success(val data:String): HoroscopeDetailState()
}