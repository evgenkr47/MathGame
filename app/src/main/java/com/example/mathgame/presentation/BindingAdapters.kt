package com.example.mathgame.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mathgame.R
import com.example.mathgame.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun minCountOfRightAnswer(textView: TextView, count: Int){
    textView.text = String.format(
                textView.context.getString(R.string.required_score),
                count
            )
}

@BindingAdapter("scoreAnswers")
fun countOfRightAnswers(textView: TextView, count: Int){
                textView.text = String.format(
                textView.context.getString(R.string.score_answers),
                count
            )
}

@BindingAdapter("requiredPercentage")
fun minPercentOfRightAnswer(textView: TextView, count: Int){
                textView.text = String.format(
                textView.context.getString(R.string.required_percentage),
                count
            )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult){
                textView.text = String.format(
                    textView.context.getString(R.string.score_percentage),
                    getPercentOfRightAnswers(gameResult)
                )
}

@BindingAdapter("resultEmoji")
fun bindResultEmoji(imageView: ImageView, winner: Boolean){
    imageView.setImageResource(getSmileResId(winner))
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}


