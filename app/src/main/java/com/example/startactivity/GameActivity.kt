package com.example.startactivity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.startactivity.data.Constants
import com.example.startactivity.databinding.ActivityGameBinding
import com.example.startactivity.databinding.ActivityStartBinding
import com.google.android.material.snackbar.Snackbar

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val questions = Constants.provideQuestions().shuffled()
    var currentQuestionId = -1
    var selectedAnswerId = -1
    var schet = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, ResultActivity::class.java)
        currentQuestionId = 0
        setQuestion()

        binding.apply {
            btnOptionOne.setOnClickListener {
                optionSelected(btnOptionOne)
                selectedAnswerId = 0
            }

            btnOptionTwo.setOnClickListener {
                optionSelected(btnOptionTwo)
                selectedAnswerId = 1
            }

            btnOptionThree.setOnClickListener {
                optionSelected(btnOptionThree)
                selectedAnswerId = 2
            }

            btnOptionFour.setOnClickListener {
                optionSelected(btnOptionFour)
                selectedAnswerId = 3
            }

            btnOptionSubmit.setOnClickListener {
                when(btnOptionSubmit.text){
                    getString(R.string.text_finish) -> {
                    intent.putExtra("Data", schet.toString())
                    startActivity(intent)
                        finish()
                }
                    getString(R.string.text_submit) -> checkAnswer()

                    getString(R.string.text_continue) -> {
                        currentQuestionId++
                        lpi.progress = currentQuestionId
                        setQuestion()
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val currentQuestion = questions[currentQuestionId]

        binding.tvTablo.text = (currentQuestionId + 1).toString() + "/10"
        binding.apply {
            tvQuestion.text = currentQuestion.question
            btnOptionOne.text = currentQuestion.answers[0]
            btnOptionTwo.text = currentQuestion.answers[1]
            btnOptionThree.text = currentQuestion.answers[2]
            btnOptionFour.text = currentQuestion.answers[3]

            btnOptionOne.isEnabled = true
            btnOptionTwo.isEnabled = true
            btnOptionThree.isEnabled = true
            btnOptionFour.isEnabled = true

            btnOptionSubmit.text = getString(R.string.text_submit)

            btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
        }
    }

    private fun optionSelected(button: Button) {

        binding.apply {
            btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
        }

        button.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.color_option_selected)
        )

    }

    private fun checkAnswer() {
        val currentQuestion = questions[currentQuestionId]

        if (currentQuestion.correctAnswerId == selectedAnswerId) schet++
        if (selectedAnswerId == -1){
            Snackbar.make(
                binding.btnOptionSubmit,
                "Please, select option",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }
        if(selectedAnswerId == 99) return

        binding.apply {
            when(selectedAnswerId) {
                0 -> {
                    btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_error))
                }
                1 -> {
                    btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_error))
                }
                2 -> {
                    btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_error))
                }
                3 -> {
                    btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_error))
                }
            }

            when(currentQuestion.correctAnswerId) {
                0 -> {
                    btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_right))
                }
                1 -> {
                    btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_right))
                }
                2 -> {
                    btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_right))
                }
                3 -> {
                    btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.color_right))
                }
            }

            selectedAnswerId = 99

            btnOptionSubmit.text = getString(R.string.text_continue)
            if(currentQuestionId == 9){
                btnOptionSubmit.text = getString(R.string.text_finish)
                lpi.progress++
            }

            btnOptionOne.isEnabled = false
            btnOptionTwo.isEnabled = false
            btnOptionThree.isEnabled = false
            btnOptionFour.isEnabled = false
       }

    }

}
