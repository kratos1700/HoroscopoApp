package com.example.horodcopoapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.example.horodcopoapp.databinding.FragmentHoroscopeBinding
import com.example.horodcopoapp.domain.model.HoroscopeInfo.*
import com.example.horodcopoapp.domain.model.HoroscopeModel
import com.example.horodcopoapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var _adapter :HoroscopeAdapter
    /**
     * binding al fragment
     */
    private var _binding:FragmentHoroscopeBinding? = null
    private  val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        initRecyclerViewList()
        initUiState()
    }

    private fun initRecyclerViewList() {
        _adapter = HoroscopeAdapter(onItemSelected = {
         val type =    when(it){
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagittarius -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }

            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity()
            )
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = _adapter
        }


    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscope.collect{
                   _adapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater,container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


}