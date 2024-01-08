package com.pableras.horoscapp.domain

interface Repository {
    suspend fun getPrediction(sign: String)
}