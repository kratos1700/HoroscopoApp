package com.example.horodcopoapp.data.network.response

import com.example.horodcopoapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName


data class PredictionResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("horoscope")
    val horoscope: String,
    @SerializedName("sign")
    val sign: String,


) {

    fun toDomanin(): PredictionModel? {
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}

