package com.example.mathgame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mathgame.R
import com.example.mathgame.databinding.FragmentGameFinishedBinding
import com.example.mathgame.databinding.FragmentWelcomeBinding
import com.example.mathgame.domain.entity.GameResult


class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()


    private var _binding: FragmentGameFinishedBinding?= null
    private val mBinding get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        mBinding.gameResult = args.gameResult
    }


    private fun setupClickListeners() {
        mBinding.buttonRetry.setOnClickListener {
            retryGame()
    }
}




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun retryGame(){
        findNavController().popBackStack()
    }

}