package com.mete.braingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mete.braingame.data.GameData
import com.mete.braingame.data.LearningData
import com.mete.braingame.data.ProgressManager
import com.mete.braingame.ui.GameViewModel
import com.mete.braingame.ui.Screen
import com.mete.braingame.ui.screens.CategorySelectionScreen
import com.mete.braingame.ui.screens.GameScreen
import com.mete.braingame.ui.screens.LearningScreen
import com.mete.braingame.ui.screens.ProgressScreen
import com.mete.braingame.ui.screens.ResultsScreen
import com.mete.braingame.ui.screens.WelcomeScreen
import com.mete.braingame.ui.theme.MeteBrainGameTheme
import com.mete.braingame.util.SoundManager
import com.mete.braingame.util.VoiceManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteBrainGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameApp()
                }
            }
        }
    }
}

@Composable
fun GameApp() {
    val viewModel: GameViewModel = viewModel()
    val context = LocalContext.current
    val voiceManager = remember { VoiceManager(context) }
    val soundManager = remember { SoundManager(context) }
    val progressManager = remember { ProgressManager(context) }
    
    DisposableEffect(Unit) {
        onDispose {
            voiceManager.shutdown()
            soundManager.release()
        }
    }
    
    when (viewModel.currentScreen) {
        is Screen.Welcome -> {
            WelcomeScreen(
                onStart = {
                    voiceManager.speak("Harika! Hadi başlayalım Mete!")
                    viewModel.navigateToCategories()
                },
                onVoiceGreeting = {
                    voiceManager.speak("Selam Mete! Hadi birlikte öğrenelim!")
                }
            )
        }
        
        is Screen.CategorySelection -> {
            CategorySelectionScreen(
                categories = GameData.categories,
                onCategorySelected = { category ->
                    voiceManager.speak("${category.name} seçtik Mete! Harika seçim!")
                    viewModel.selectCategory(category)
                },
                onProgressClick = {
                    viewModel.navigateToProgress()
                }
            )
        }
        
        is Screen.Learning -> {
            val learningItems = viewModel.selectedCategory?.let { category ->
                LearningData.getLearningItems(category.id)
            } ?: emptyList()
            
            LearningScreen(
                categoryName = viewModel.selectedCategory?.name ?: "",
                learningItems = learningItems,
                childName = "Mete", // Configurable child name
                onComplete = {
                    voiceManager.speak("Çok iyi öğrendin Mete! Şimdi test zamanı!")
                    viewModel.completeLearning()
                },
                onBack = {
                    viewModel.backFromGame()
                },
                onItemClick = { item ->
                    // Play sound for the item
                    item.soundText?.let { soundText ->
                        voiceManager.speak(soundText)
                    }
                }
            )
        }
        
        is Screen.Game -> {
            GameScreen(
                questions = viewModel.currentQuestions,
                categoryName = viewModel.selectedCategory?.name ?: "",
                onFinish = { score, total ->
                    // Save progress
                    viewModel.selectedCategory?.let { category ->
                        progressManager.updateProgress(
                            categoryId = category.id,
                            questionsAnswered = total,
                            correctAnswers = score,
                            newMasteredWords = emptySet() // Will be populated in advanced version
                        )
                    }
                    viewModel.finishGame(score, total)
                },
                onBack = {
                    viewModel.backFromGame()
                },
                onQuestionVoice = { text ->
                    voiceManager.speak(text)
                },
                onCorrectVoice = {
                    val praises = listOf(
                        "Bravo Mete! Çok iyi!",
                        "Aferin Mete! Harikasın!",
                        "Süpersin Mete!",
                        "Mükemmel Mete!",
                        "Tebrikler Mete!"
                    )
                    voiceManager.speak(praises.random())
                },
                onWrongVoice = {
                    voiceManager.speak("Tekrar dene Mete, sen yapabilirsin!")
                },
                onItemClick = { item ->
                    // Play sound when clicking on items (especially animals)
                    soundManager.getAnimalSoundText(item)?.let { soundText ->
                        voiceManager.speak(soundText)
                    }
                }
            )
        }
        
        is Screen.Results -> {
            ResultsScreen(
                score = viewModel.finalScore,
                total = viewModel.totalQuestions,
                onPlayAgain = {
                    voiceManager.speak("Harika! Tekrar oynayalım Mete!")
                    viewModel.playAgain()
                },
                onBackToCategories = {
                    voiceManager.speak("Başka bir kategori seçelim!")
                    viewModel.backToCategories()
                }
            )
        }
        
        is Screen.Progress -> {
            val userProgress = progressManager.getUserProgress()
            val categoryNames = GameData.categories.associate { it.id to it.name }
            
            ProgressScreen(
                userProgress = userProgress,
                categoryNames = categoryNames,
                onBack = {
                    viewModel.backFromProgress()
                }
            )
        }
    }
}
