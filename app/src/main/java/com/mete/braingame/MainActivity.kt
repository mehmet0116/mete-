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
import com.mete.braingame.data.Screen
import com.mete.braingame.ui.GameViewModel
import com.mete.braingame.ui.screens.CategorySelectionScreen
import com.mete.braingame.ui.screens.GameScreen
import com.mete.braingame.ui.screens.ResultsScreen
import com.mete.braingame.ui.screens.WelcomeScreen
import com.mete.braingame.ui.theme.MeteBrainGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeteBrainGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BrainGameApp()
                }
            }
        }
    }
}

@Composable
fun BrainGameApp() {
    val viewModel: GameViewModel = viewModel()

    val currentScreen by viewModel.currentScreen.collectAsState()
    val gameState by viewModel.gameState.collectAsState()

    when (currentScreen) {
        is Screen.Welcome -> {
            WelcomeScreen(
                onStartClick = {
                    viewModel.navigateTo(Screen.CategorySelection)
                }
            )
        }
        is Screen.CategorySelection -> {
            CategorySelectionScreen(
                categories = GameData.categories,
                onCategorySelected = { categoryId ->
                    viewModel.selectCategory(categoryId)
                },
                onBackPressed = {
                    viewModel.navigateTo(Screen.Welcome)
                }
            )
        }
        is Screen.Game -> {
            GameScreen(
                viewModel = viewModel,
                onGameComplete = {
                    viewModel.navigateTo(Screen.Results)
                }
            )
        }
        is Screen.Results -> {
            ResultsScreen(
                score = gameState.score,
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