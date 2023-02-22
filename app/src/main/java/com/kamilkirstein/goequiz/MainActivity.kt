package com.kamilkirstein.goequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton : Button
    private lateinit var falseButton : Button
    private lateinit var nextButton : Button

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
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)

        // set Listeners:
        trueButton.setOnClickListener { view : View ->
            // do something
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()
        }

        falseButton.setOnClickListener { view : View ->
            //do something
            Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}