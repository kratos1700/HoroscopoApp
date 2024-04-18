package com.example.horodcopoapp.data

import com.example.horodcopoapp.data.network.HoroscopeApiService
import com.example.horodcopoapp.data.network.response.PredictionResponse
import com.example.horodcopoapp.domain.Repository
import com.example.horodcopoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService: HoroscopeApiService): Repository {
    override suspend fun getPrediction(sing: String): PredictionModel? {
       runCatching {
            apiService.getHoroscope(sing)
        }
           .onSuccess {return it.toDomanin()  }
           .onFailure{ return null}
        return null
    }

}