package com.example.horodcopoapp.domain.usecase

import com.example.horodcopoapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}