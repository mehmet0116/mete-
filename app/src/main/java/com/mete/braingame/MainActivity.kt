package com.mete.braingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
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
    
    when (viewModel.currentScreen) {
        Screen.WELCOME -> WelcomeScreen(
            onContinue = { viewModel.navigateToCategorySelection() }
        )
        Screen.CATEGORY_SELECTION -> CategorySelectionScreen(
            categories = viewModel.categories,
            onCategorySelected = { category ->
                viewModel.selectCategory(category)
                viewModel.navigateToGame()
            }
        )
        Screen.GAME -> GameScreen(
            viewModel = viewModel,
            onGameComplete = { score ->
                viewModel.setGameScore(score)
                viewModel.navigateToResults()
            }
        )
        Screen.RESULTS -> ResultsScreen(
            score = viewModel.gameScore,
            onPlayAgain = { viewModel.navigateToCategorySelection() },
            onExit = { viewModel.navigateToWelcome() }
        )
    }
}

enum class Screen {
    WELCOME,
    CATEGORY_SELECTION,
    GAME,
    RESULTS
}