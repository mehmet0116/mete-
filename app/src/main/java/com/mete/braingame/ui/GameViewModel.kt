package com.mete.braingame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mete.braingame.data.Category
import com.mete.braingame.data.GameData
import com.mete.braingame.data.GameState
import com.mete.braingame.data.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    // Screen navigation state
    private val _currentScreen = MutableStateFlow(Screen.WELCOME)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()
    
    // Game state
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()
    
    // Categories
    val categories: List<Category> = GameData.categories
    
    // Selected category
    private val _selectedCategory = MutableStateFlow<Category?>(null)
    val selectedCategory: StateFlow<Category?> = _selectedCategory.asStateFlow()
    
    // Current question
    private val _currentQuestion = MutableStateFlow<Question?>(null)
    val currentQuestion: StateFlow<Question?> = _currentQuestion.asStateFlow()
    
    // Game score
    private val _gameScore = MutableStateFlow(0)
    val gameScore: StateFlow<Int> = _gameScore.asStateFlow()
    
    // Navigation functions
    fun navigateToWelcome() {
        _currentScreen.value = Screen.WELCOME
    }
    
    fun navigateToCategorySelection() {
        _currentScreen.value = Screen.CATEGORY_SELECTION
        resetGame()
    }
    
    fun navigateToGame() {
        _currentScreen.value = Screen.GAME
        startNewGame()
    }
    
    fun navigateToResults() {
        _currentScreen.value = Screen.RESULTS
    }
    
    // Game functions
    fun selectCategory(category: Category) {
        _selectedCategory.value = category
    }
    
    fun setGameScore(score: Int) {
        _gameScore.value = score
    }
    
    private fun startNewGame() {
        viewModelScope.launch {
            val category = _selectedCategory.value
            if (category != null) {
                // Get questions for the selected category
                val questions = GameData.getQuestionsForCategory(category.id)
                if (questions.isNotEmpty()) {
                    _currentQuestion.value = questions.first()
                    _gameState.value = GameState(
                        currentQuestionIndex = 0,
                        totalQuestions = questions.size,
                        score = 0,
                        questions = questions
                    )
                }
            }
        }
    }
    
    fun answerQuestion(isCorrect: Boolean) {
        val currentState = _gameState.value
        val questions = currentState.questions
        
        if (currentState.currentQuestionIndex < questions.size - 1) {
            // Move to next question
            val newScore = if (isCorrect) currentState.score + 1 else currentState.score
            _gameState.value = currentState.copy(
                currentQuestionIndex = currentState.currentQuestionIndex + 1,
                score = newScore
            )
            _currentQuestion.value = questions[currentState.currentQuestionIndex + 1]
        } else {
            // Game complete
            val finalScore = if (isCorrect) currentState.score + 1 else currentState.score
            _gameScore.value = finalScore
            navigateToResults()
        }
    }
    
    private fun resetGame() {
        _selectedCategory.value = null
        _currentQuestion.value = null
        _gameState.value = GameState()
        _gameScore.value = 0
    }
}