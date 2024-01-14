package com.example.horodcopoapp.ui.luck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.horodcopoapp.databinding.FragmentLuckBinding


class LuckFragment : Fragment() {

    /**
     * binding al fragment
     */
    private var _binding: FragmentLuckBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater,container, false)

        // Inflate the layout for this fragment
        return binding.root
    }


}