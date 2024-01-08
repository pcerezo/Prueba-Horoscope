package com.pableras.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String, // <-- SerializedName indica el campo json de la respuesta para meterlo en la variable
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String)