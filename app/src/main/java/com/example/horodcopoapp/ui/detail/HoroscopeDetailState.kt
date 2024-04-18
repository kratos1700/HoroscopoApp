package com.example.horodcopoapp.ui.detail

import com.example.horodcopoapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading : HoroscopeDetailState()
    //si porta parametres ha de ser una data class sino data object
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val prediction:String,
                       val sign:String,
                       val horoscopeModel: HoroscopeModel
    ):HoroscopeDetailState()
}