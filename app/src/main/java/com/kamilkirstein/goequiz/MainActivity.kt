package com.kamilkirstein.goequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.StringRes
import com.kamilkirstein.goequiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // using viewBinding
    private lateinit var binding : ActivityMainBinding


    // create the List of Questions we will use in our app

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_asia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set Listeners:
        binding.trueButton.setOnClickListener { _ : View ->
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener { _ : View ->
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener { _ : View ->
            currentIndex = ((currentIndex + 1) % questionBank.size)
            updateQuestion()
        }

        binding.prevButton.setOnClickListener { _ : View ->
            currentIndex = Math.floorMod(currentIndex - 1, questionBank.size)
            updateQuestion()
        }
        // get the  question for the text view from questionBank
        updateQuestion()
    }

    private fun updateQuestion() {
        binding.questionTextView.setText(questionBank[currentIndex].textResId)
    }
    private fun checkAnswer(userAnswer : Boolean)
    {
        @StringRes val stringResForToast : Int = if (userAnswer == questionBank[currentIndex].answer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(
            this,
            stringResForToast,
            Toast.LENGTH_SHORT
        ).show()
    }

}