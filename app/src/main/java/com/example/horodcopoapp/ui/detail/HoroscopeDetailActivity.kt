package com.example.horodcopoapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horodcopoapp.R
import com.example.horodcopoapp.databinding.ActivityHoroscopeDetailBinding
import com.example.horodcopoapp.domain.model.HoroscopeModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel : HoroscopeDetailViewModel by viewModels()
    private val args:HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailViewModel.getHoroscope(args.type)
        initUi()

    }

    private fun initUi() {
        initListeners()
        initUiState()
    }

    private fun initListeners() {
        binding.ivBackDetail.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUiState() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()

                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun errorState() {
        binding.pbLoaddingDet.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pbLoaddingDet.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

      val image : Int =  when(state.horoscopeModel){
            HoroscopeModel.Aries -> R.drawable.detail_aries
            HoroscopeModel.Taurus -> R.drawable.detail_taurus
            HoroscopeModel.Gemini -> R.drawable.detail_gemini
            HoroscopeModel.Cancer -> R.drawable.detail_cancer
            HoroscopeModel.Leo -> R.drawable.detail_leo
            HoroscopeModel.Virgo -> R.drawable.detail_virgo
            HoroscopeModel.Libra -> R.drawable.detail_libra
            HoroscopeModel.Scorpio -> R.drawable.detail_scorpio
            HoroscopeModel.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopeModel.Pisces -> R.drawable.detail_pisces
            HoroscopeModel.Capricorn -> R.drawable.detail_capricorn
            HoroscopeModel.Aquarius -> R.drawable.detail_aquarius

        }
            binding.ivDetail.setImageResource(image)
    }

    private fun loadingState() {
        binding.pbLoaddingDet.isVisible = true
    }
}