package com.pableras.horoscapp.data.network

import com.pableras.horoscapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeAPIService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign")sign: String): PredictionResponse
}