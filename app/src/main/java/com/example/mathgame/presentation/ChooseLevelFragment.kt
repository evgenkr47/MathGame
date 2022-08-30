package com.example.mathgame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mathgame.R
import com.example.mathgame.databinding.FragmentChooseLevelBinding
import com.example.mathgame.databinding.FragmentWelcomeBinding
import com.example.mathgame.domain.entity.Level


class ChooseLevelFragment : Fragment() {
    private var _binding: FragmentChooseLevelBinding?= null
    private val mBinding get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(mBinding){
            buttonLevelTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }

            buttonLevelEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }

            buttonLevelNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }

            buttonLevelNormal.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: Level) {

        findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}