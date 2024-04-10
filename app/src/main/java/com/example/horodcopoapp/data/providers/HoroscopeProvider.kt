package com.example.horodcopoapp.data.providers

import com.example.horodcopoapp.domain.model.HoroscopeInfo
import com.example.horodcopoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {

        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Pisces,
            Capricorn,
            Aquarius
        )
    }
}