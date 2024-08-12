package com.example.quiz_app_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startbutton)
        startButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        // Handle button clicks here
        when (view.id) {
            R.id.startbutton -> {
                // Start the QuizPage activity when startButton is clicked
                startActivity(Intent(this, QuizPage::class.java))
            }
        }
    }
}