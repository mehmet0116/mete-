package com.mete.braingame.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mete.braingame.data.GameCategory
import com.mete.braingame.data.GameData
import com.mete.braingame.data.Question

sealed class Screen {
    data object Welcome : Screen()
    data object CategorySelection : Screen()
    data object Game : Screen()
    data object Results : Screen()
}

class GameViewModel : ViewModel() {
    var currentScreen by mutableStateOf<Screen>(Screen.Welcome)
        private set
    
    var selectedCategory by mutableStateOf<GameCategory?>(null)
        private set
    
    var currentQuestions by mutableStateOf<List<Question>>(emptyList())
        private set
    
    var finalScore by mutableIntStateOf(0)
        private set
    
    var totalQuestions by mutableIntStateOf(0)
        private set
    
    fun navigateToCategories() {
        currentScreen = Screen.CategorySelection
    }
    
    fun selectCategory(category: GameCategory) {
        selectedCategory = category
        currentQuestions = GameData.getQuestionsByCategory(category.id)
        currentScreen = Screen.Game
    }
    
    fun finishGame(score: Int, total: Int) {
        finalScore = score
        totalQuestions = total
        currentScreen = Screen.Results
    }
    
    fun playAgain() {
        selectedCategory?.let { category ->
            currentQuestions = GameData.getQuestionsByCategory(category.id)
            currentScreen = Screen.Game
        }
    }
    
    fun backToCategories() {
        selectedCategory = null
        currentQuestions = emptyList()
        currentScreen = Screen.CategorySelection
    }
    
    fun backFromGame() {
        selectedCategory = null
        currentQuestions = emptyList()
        currentScreen = Screen.CategorySelection
    }
}
