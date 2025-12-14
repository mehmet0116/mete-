package com.mete.braingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mete.braingame.data.GameData
import com.mete.braingame.data.LearningData
import com.mete.braingame.data.Screen
import com.mete.braingame.ui.GameViewModel
import com.mete.braingame.ui.screens.CategorySelectionScreen
import com.mete.braingame.ui.screens.GameScreen
import com.mete.braingame.ui.screens.LearningScreen
import com.mete.braingame.ui.screens.ResultsScreen
import com.mete.braingame.ui.screens.WelcomeScreen
import com.mete.braingame.ui.theme.MeteBrainGameTheme
import com.mete.braingame.util.VoiceManager

class MainActivity : ComponentActivity() {
    private lateinit var voiceManager: VoiceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize VoiceManager
        voiceManager = VoiceManager(this)
        
        setContent {
            MeteBrainGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BrainGameApp(voiceManager)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        voiceManager.shutdown()
    }
}

@Composable
fun BrainGameApp(voiceManager: VoiceManager) {
    val viewModel: GameViewModel = viewModel()

    val currentScreen by viewModel.currentScreen.collectAsState()
    val gameState by viewModel.gameState.collectAsState()

    when (currentScreen) {
        is Screen.Welcome -> {
            WelcomeScreen(
                onStartClick = {
                    viewModel.navigateTo(Screen.CategorySelection)
                },
                onVoiceWelcome = {
                    voiceManager.speak("Mete hoşgeldin! Hadi birlikte öğrenelim ve eğlenelim!")
                }
            )
        }
        is Screen.CategorySelection -> {
            CategorySelectionScreen(
                categories = GameData.categories,
                onCategorySelected = { categoryId ->
                    val category = GameData.categories.find { it.id == categoryId }
                    category?.let {
                        voiceManager.speak("${it.displayName} kategorisine hoş geldin! Hadi öğrenelim!")
                    }
                    viewModel.selectCategory(categoryId)
                },
                onBackPressed = {
                    viewModel.navigateTo(Screen.Welcome)
                }
            )
        }
        is Screen.Learning -> {
            val screen = currentScreen as Screen.Learning
            val category = GameData.getCategoryById(screen.categoryId)
            val learningItems = category?.let { LearningData.getLearningItems(it.name) } ?: emptyList()
            
            LearningScreen(
                categoryName = category?.displayName ?: "",
                learningItems = learningItems,
                onComplete = {
                    viewModel.startGameAfterLearning()
                },
                onBack = {
                    viewModel.navigateTo(Screen.CategorySelection)
                },
                onItemClick = { item ->
                    voiceManager.stop()
                    voiceManager.speak(item.soundText ?: item.nameTr)
                },
                childName = "Mete"
            )
        }
        is Screen.Game -> {
            GameScreen(
                viewModel = viewModel,
                voiceManager = voiceManager,
                onGameComplete = {
                    viewModel.navigateTo(Screen.Results)
                },
                onBackPressed = {
                    viewModel.navigateTo(Screen.CategorySelection)
                }
            )
        }
        is Screen.Results -> {
            ResultsScreen(
                score = gameState.score,
                correctAnswers = gameState.correctAnswers,
                totalQuestions = gameState.totalQuestions,
                voiceManager = voiceManager,
                onPlayAgain = {
                    viewModel.resetGame()
                    viewModel.navigateTo(Screen.CategorySelection)
                },
                onExit = {
                    viewModel.resetGame()
                    viewModel.navigateTo(Screen.Welcome)
                }
            )
        }
    }
}