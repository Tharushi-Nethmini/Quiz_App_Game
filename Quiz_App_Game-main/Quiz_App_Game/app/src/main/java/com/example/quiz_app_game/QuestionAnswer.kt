package com.example.quiz_app_game

class QuestionAnswer {
    var question = arrayOf(
        "What is the square root of 64 ?",
        "What is the capital of Franc?",
        "what is 12*9 ?",
        "who is the founder of SpaceX?",
        "In the given options, which is the Example of System Software?"
    )
    var choices = arrayOf(
        arrayOf("3", "8", "10", "4"),
        arrayOf("Toulouse", "Nice", "Paris", "None of the above"),
        arrayOf("96", "84", "102", "108"),
        arrayOf("Jeff Bezos", "Elon Musk", "Steve Jobs", "Bill Gates"),
        arrayOf("Windows", "Linux", "MacOS", "All of the above")
    )
    var correctAnswers = arrayOf(
        "8",
        "Paris",
        "108",
        "Elon Musk",
        "All of the above"
    )

    companion object {
        val question: Array<String> = arrayOf(
            "What is the square root of 64 ?",
            "What is the capital of Franc?",
            "what is 12*9 ?",
            "who is the founder of SpaceX?",
            "In the given options, which is the Example of System Software?"
        )
        val choices: Array<Array<String>> = arrayOf(
            arrayOf("3", "8", "10", "4"),
            arrayOf("Toulouse", "Nice", "Paris", "None of the above"),
            arrayOf("96", "84", "102", "108"),
            arrayOf("Jeff Bezos", "Elon Musk", "Steve Jobs", "Bill Gates"),
            arrayOf("Windows", "Linux", "MacOS", "All of the above")
        )
        val correctAnswers: Array<String> = arrayOf(
            "8",
            "Paris",
            "108",
            "Elon Musk",
            "All of the above"
        )
    }
}