package com.example.quizzapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizzapp.viewmodel.QuizViewModel

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    viewModel: QuizViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.questions.isEmpty()) {
        Text("Cargando...", modifier = modifier)
        return
    }

    val question = uiState.questions[uiState.currentQuestionIndex]

    Column(modifier = modifier.padding(16.dp)) {

        Text("Quiz Android")

        Text("Pregunta ${uiState.currentQuestionIndex + 1} de ${uiState.questions.size}")

        Spacer(modifier = Modifier.height(16.dp))

        Text(question.question)

        Spacer(modifier = Modifier.height(16.dp))

        question.options.forEachIndexed { index, option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.selectOption(index) }
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = uiState.selectedOptionIndex == index,
                    onClick = { viewModel.selectOption(index) }
                )
                Text(option)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.validateAnswer() },
            enabled = uiState.selectedOptionIndex != null && !uiState.isAnswerValidated
        ) {
            Text("Validar")
        }

        if (uiState.isAnswerValidated) {
            Text(
                if (uiState.isAnswerCorrect) "Correcto"
                else "Incorrecto"
            )

            Button(onClick = { viewModel.nextQuestion() }) {
                Text("Siguiente")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Puntaje: ${uiState.score}")
    }

    // ✅ ALERT FINAL
    if (uiState.isQuizFinished) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                Button(onClick = { viewModel.restartQuiz() }) {
                    Text("Reiniciar")
                }
            },
            title = {
                Text("Resultado final")
            },
            text = {
                Text("Puntaje: ${uiState.score}/${uiState.questions.size}")
            }
        )
    }
}