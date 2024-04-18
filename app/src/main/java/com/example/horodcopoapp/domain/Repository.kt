package com.example.horodcopoapp.domain


import com.example.horodcopoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sing: String): PredictionModel?
}