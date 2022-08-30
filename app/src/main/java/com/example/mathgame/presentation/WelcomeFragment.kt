package com.example.mathgame.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mathgame.R
import com.example.mathgame.databinding.FragmentWelcomeBinding



class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding?= null
    private val mBinding get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.buttonUnderstand.setOnClickListener {
            launchChooseLevelFragment()
        }
    }

    private fun launchChooseLevelFragment(){
        findNavController().navigate(R.id.action_welcomeFragment2_to_chooseLevelFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}