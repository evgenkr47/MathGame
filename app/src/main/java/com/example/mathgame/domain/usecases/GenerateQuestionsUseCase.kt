package com.example.mathgame.domain.usecases

import com.example.mathgame.domain.entity.Questions
import com.example.mathgame.domain.repository.GameRepository

class GenerateQuestionsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Questions{
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object{
        private const val COUNT_OF_OPTIONS = 6
    }
}