package com.pableras.horoscapp.data

import com.pableras.horoscapp.data.network.HoroscopeAPIService
import com.pableras.horoscapp.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeAPIService): Repository {
    override suspend fun getPrediction(sign: String) {
        // Petición a Internet por Retrofit
        kotlin.runCatching { apiService.getHoroscope(sign) } // <--- Especie de try/catch.
                                                            // Captura cualquier excepción del bloque de código que recibe por parámetro
    }
}