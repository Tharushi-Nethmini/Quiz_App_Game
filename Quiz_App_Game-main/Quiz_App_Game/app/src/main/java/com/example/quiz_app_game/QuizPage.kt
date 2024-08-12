package com.example.quiz_app_game


import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizPage : AppCompatActivity(), View.OnClickListener {
    private lateinit var questionTextView: TextView
    private lateinit var totalQuestionTextView: TextView
    private lateinit var ansA: Button
    private lateinit var ansB: Button
    private lateinit var ansC: Button
    private lateinit var ansD: Button
    private lateinit var btnSubmit: Button

    private lateinit var sharedPreferences: SharedPreferences
    private var score = 0
    private var totalQuestion = 0
    private var currentQuestionIndex = 0
    private var selectedAnswer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_page)

        sharedPreferences = getSharedPreferences("QuizPrefs", Context.MODE_PRIVATE)

        totalQuestionTextView = findViewById(R.id.total_question)
        questionTextView = findViewById(R.id.question)
        ansA = findViewById(R.id.ans_a)
        ansB = findViewById(R.id.ans_b)
        ansC = findViewById(R.id.ans_c)
        ansD = findViewById(R.id.ans_d)
        btnSubmit = findViewById(R.id.btn_submit)

        ansA.setOnClickListener(this)
        ansB.setOnClickListener(this)
        ansC.setOnClickListener(this)
        ansD.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        // Load score from shared preferences
        score = sharedPreferences.getInt("score", 0)
        totalQuestion = QuestionAnswer.question.size

        totalQuestionTextView.text = "Total question: $totalQuestion"

        loadNewQuestion()
    }

    private fun loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz()
            return
        }
        questionTextView.text = QuestionAnswer.question[currentQuestionIndex]
        ansA.text = QuestionAnswer.choices[currentQuestionIndex][0]
        ansB.text = QuestionAnswer.choices[currentQuestionIndex][1]
        ansC.text = QuestionAnswer.choices[currentQuestionIndex][2]
        ansD.text = QuestionAnswer.choices[currentQuestionIndex][3]

        selectedAnswer = ""
    }

    private fun finishQuiz() {
        val passStatus = if (score >= totalQuestion * 0.6) "Passed" else "Failed"
        AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Your Score is $score Out of $totalQuestion")
            .setPositiveButton("Restart") { _, _ -> restartQuiz() }
            .setCancelable(false)
            .show()
    }

    private fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion()
    }

    override fun onClick(view: View) {
        ansA.setBackgroundColor(Color.WHITE)
        ansB.setBackgroundColor(Color.WHITE)
        ansC.setBackgroundColor(Color.WHITE)
        ansD.setBackgroundColor(Color.WHITE)

        val clickedButton = view as Button

        if (clickedButton.id == R.id.btn_submit) {
            if (selectedAnswer.isNotEmpty()) {
                if (selectedAnswer == QuestionAnswer.correctAnswers[currentQuestionIndex]) {
                    score++
                    // Update score in shared preferences
                    sharedPreferences.edit().putInt("score", score).apply()
                } else {
                    clickedButton.setBackgroundColor(Color.MAGENTA)
                }
                currentQuestionIndex++
                loadNewQuestion()
            }
        } else {
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.YELLOW)
        }
    }
}
