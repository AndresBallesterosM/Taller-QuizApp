package com.example.quizzapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quizzapp.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class QuizViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(QuizUiState(questions = loadQuestions()))
    val uiState: StateFlow<QuizUiState> = _uiState

    private fun loadQuestions(): List<Question> {
        return listOf(
            Question("¿Lenguaje oficial Android?", listOf("Java", "Kotlin", "Swift", "Dart"), 1),
            Question("¿Quién conserva estado?", listOf("Activity", "Fragment", "ViewModel", "Intent"), 2),
            Question("¿Paradigma de Compose?", listOf("Imperativo", "Declarativo", "Procedural", "Estructurado"), 1),
            Question("¿Qué es StateFlow?", listOf("UI", "BD", "Flujo de estado", "API"), 2),
            Question("¿UI en Compose usa?", listOf("XML", "JSON", "Kotlin", "CSS"), 2)
        )
    }

    fun selectOption(index: Int) {
        _uiState.update { it.copy(selectedOptionIndex = index) }
    }

    fun validateAnswer() {
        val state = _uiState.value
        val correctIndex = state.questions[state.currentQuestionIndex].correctAnswerIndex

        val isCorrect = state.selectedOptionIndex == correctIndex

        _uiState.update {
            it.copy(
                isAnswerValidated = true,
                isAnswerCorrect = isCorrect,
                score = if (isCorrect) it.score + 1 else it.score
            )
        }
    }

    fun nextQuestion() {
        val state = _uiState.value
        val nextIndex = state.currentQuestionIndex + 1

        if (nextIndex < state.questions.size) {
            _uiState.update {
                it.copy(
                    currentQuestionIndex = nextIndex,
                    selectedOptionIndex = null,
                    isAnswerValidated = false
                )
            }
        } else {
            _uiState.update { it.copy(isQuizFinished = true) }
        }
    }

    fun restartQuiz() {
        _uiState.value = QuizUiState(questions = loadQuestions())
    }
}