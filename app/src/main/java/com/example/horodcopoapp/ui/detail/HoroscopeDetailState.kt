package com.example.horodcopoapp.ui.detail

sealed class HoroscopeDetailState {
    data object Loading : HoroscopeDetailState()
    //si porta parametres ha de ser una data class sino data object
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val data: String) : HoroscopeDetailState()
}