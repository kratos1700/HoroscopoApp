package com.example.horodcopoapp.domain.model

import com.google.gson.annotations.SerializedName

data class PredictionModel(
    val horoscope: String,
    val sign: String,
)