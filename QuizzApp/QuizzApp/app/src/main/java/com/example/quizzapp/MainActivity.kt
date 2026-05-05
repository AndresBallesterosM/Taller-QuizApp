package com.example.quizzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizzapp.ui.QuizScreen
import com.example.quizzapp.ui.theme.QuizzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizzAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    QuizScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuiz() {
    QuizzAppTheme {
        QuizScreen()
    }
}