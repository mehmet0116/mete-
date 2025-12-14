package com.mete.braingame.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    val gameState = viewModel.gameState.collectAsState().value
    val currentQuestion = viewModel.getCurrentQuestion()

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
                        currentQuestion.options.forEachIndexed { index, option ->
                            Button(
                                onClick = {
                                    // Seçim yap
                                    viewModel.selectAnswer(index)

                                    // Son soruda mıyız?
                                    val isLast = gameState.currentQuestionIndex >= gameState.totalQuestions - 1
                                    if (isLast) {
                                        // Oyun tamamlandı
                                        onGameComplete(viewModel.gameState.value.score)
                                    } else {
                                        // Sonraki soruya geç
                                        viewModel.nextQuestion()
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