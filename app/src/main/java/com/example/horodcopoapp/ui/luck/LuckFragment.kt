package com.example.horodcopoapp.ui.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.example.horodcopoapp.R
import com.example.horodcopoapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

@AndroidEntryPoint
class LuckFragment : Fragment() {


    /**
     * binding al fragment
     */
    private var _binding: FragmentLuckBinding? = null
    private  val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        initListeners()
    }

    private fun initListeners() {
        binding.ivRuleta.setOnClickListener {
            spinRuleta()
        }
    }

    // animacion de la ruleta
    private fun spinRuleta() {
        val random = Random()
        val degrees = random.nextInt(1440)+360 // en caso de dar valor 0 se suma 360, 1440 = 360*4
        val animator = ObjectAnimator
            .ofFloat(binding.ivRuleta,
                View.ROTATION,
                0f,
                degrees.toFloat() )
        animator.setDuration(2000).interpolator = DecelerateInterpolator()
        // cuando finaliza la animacion
        animator.doOnEnd {
            slideCard()
        }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(),
            R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                binding.ivreverse.isVisible= true
            }

            override fun onAnimationEnd(p0: Animation?) {}

            override fun onAnimationRepeat(p0: Animation?) {}

        })
        binding.ivreverse.startAnimation(slideUpAnimation)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater,container, false)

        // Inflate the layout for this fragment
        return binding.root
    }


}