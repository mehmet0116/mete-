package com.mete.braingame.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mete.braingame.ui.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel,
    onGameComplete: (Int) -> Unit
) {
    val currentQuestion = viewModel.currentQuestion.value
    val gameState = viewModel.gameState.value
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Progress indicator
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Soru: ${gameState.currentQuestionIndex + 1}/${gameState.totalQuestions}",
                fontSize = 16.sp
            )
            Text(
                text = "Puan: ${gameState.score}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        if (currentQuestion != null) {
            // Question
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = currentQuestion.text,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 32.dp)
                    )
                    
                    // Options
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        currentQuestion.options.forEach { option ->
                            Button(
                                onClick = {
                                    val isCorrect = option == currentQuestion.correctAnswer
                                    viewModel.answerQuestion(isCorrect)
                                    if (gameState.currentQuestionIndex == gameState.totalQuestions - 1) {
                                        onGameComplete(gameState.score + if (isCorrect) 1 else 0)
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = option, fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Soru yükleniyor...", fontSize = 20.sp)
            }
        }
    }
}