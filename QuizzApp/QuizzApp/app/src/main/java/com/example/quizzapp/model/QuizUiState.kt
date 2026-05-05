package com.example.quizzapp.model

data class QuizUiState(
    val currentQuestionIndex: Int = 0,
    val questions: List<Question> = emptyList(),
    val selectedOptionIndex: Int? = null,
    val score: Int = 0,
    val isAnswerValidated: Boolean = false,
    val isAnswerCorrect: Boolean = false,
    val isQuizFinished: Boolean = false
)