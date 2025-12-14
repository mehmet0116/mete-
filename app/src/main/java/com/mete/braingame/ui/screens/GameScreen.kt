package com.mete.braingame.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mete.braingame.ui.GameViewModel
import com.mete.braingame.util.VoiceManager
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    viewModel: GameViewModel,
    voiceManager: VoiceManager,
    onGameComplete: () -> Unit,
    onBackPressed: () -> Unit
) {
    val gameState = viewModel.gameState.collectAsState().value
    val questions = viewModel.questions.collectAsState().value
    val currentQuestion = questions.getOrNull(gameState.currentQuestionIndex)

    // Read the question when it changes
    LaunchedEffect(currentQuestion?.id) {
        currentQuestion?.let {
            voiceManager.speak(it.text)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Soru: ${gameState.currentQuestionIndex + 1}/${gameState.totalQuestions}",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Geri"
                        )
                    }
                },
                actions = {
                    Text(
                        text = "Puan: ${gameState.score}",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(end = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Only show question if it exists
            currentQuestion?.let { question ->
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
                            text = question.text,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 32.dp)
                        )

                        // Options
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            itemsIndexed(question.options) { index, option ->
                                Button(
                                    onClick = {
                                        val isCorrect = index == question.correctAnswer
                                        viewModel.selectAnswer(index)
                                        
                                        // Stop question reading and provide answer feedback
                                        voiceManager.stop()
                                        if (isCorrect) {
                                            val praises = listOf(
                                                "Süpersin Mete! Çok iyi! 🌟",
                                                "Harikasın Mete! Bravo! 👏",
                                                "Aferin Mete! Mükemmel! ⭐",
                                                "Çok akıllısın Mete! 🎯",
                                                "İşte bu! Doğru cevap Mete! 🎉",
                                                "Eline sağlık Mete! Süper! 💪"
                                            )
                                            voiceManager.speak(praises[Random.nextInt(praises.size)])
                                        } else {
                                            val encouragements = listOf(
                                                "Sorun değil Mete! Tekrar deneyelim! 💪",
                                                "Güzel deneme Mete! Bir daha bakalım! 🌟",
                                                "Hadi Mete, sen yaparsın! 🎯",
                                                "İyi gidiyorsun Mete! Devam et! ⭐",
                                                "Her şey öğrenmekle başlar Mete! 📚"
                                            )
                                            voiceManager.speak(encouragements[Random.nextInt(encouragements.size)])
                                        }
                                        
                                        val isLast = gameState.currentQuestionIndex >= gameState.totalQuestions - 1
                                        if (isLast) {
                                            onGameComplete()
                                        } else {
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
            }
        }
    }
}