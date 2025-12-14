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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
    val navController = rememberNavController()

    val gameState by viewModel.gameState.collectAsState()
    val selectedCategoryId by viewModel.selectedCategoryId.collectAsState()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("category") {
            CategorySelectionScreen(
                navController = navController,
                onCategorySelected = { categoryId ->
                    viewModel.selectCategory(categoryId)
                }
            )
        }
        composable(
            route = "game/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId")
            if (categoryId != null && selectedCategoryId != categoryId) {
                viewModel.selectCategory(categoryId)
            }
            GameScreen(
                viewModel = viewModel,
                onGameComplete = {
                    navController.navigate("results")
                }
            )
        }
        composable("results") {
            ResultsScreen(
                score = gameState.score,
                onPlayAgain = {
                    viewModel.resetGame()
                    navController.navigate("category")
                },
                onExit = {
                    viewModel.resetGame()
                    navController.navigate("welcome")
                }
            )
        }
    }
}
