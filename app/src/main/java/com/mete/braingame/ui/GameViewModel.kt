package com.mete.braingame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mete.braingame.data.Category
import com.mete.braingame.data.GameData
import com.mete.braingame.data.GameScreen
import com.mete.braingame.data.GameState
import com.mete.braingame.data.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameState())
    val uiState: StateFlow<GameState> = _uiState.asStateFlow()

    private val _currentScreen = MutableStateFlow(GameScreen.WELCOME)
    val currentScreen: StateFlow<GameScreen> = _currentScreen.asStateFlow()

    private var currentQuestions: List<Question> = emptyList()

    fun navigateTo(screen: GameScreen) {
        _currentScreen.value = screen
    }

    fun selectCategory(category: Category) {
        viewModelScope.launch {
            currentQuestions = GameData.getQuestionsForCategory(category.id).shuffled().take(5)
            
            _uiState.update { state ->
                state.copy(
                    currentCategory = category,
                    currentQuestionIndex = 0,
                    score = 0,
                    correctAnswers = 0,
                    totalQuestions = currentQuestions.size,
                    isGameActive = true,
                    isGameFinished = false,
                    selectedAnswer = null,
                    isAnswerCorrect = null
                )
            }
            
            navigateTo(GameScreen.GAME)
        }
    }

    fun selectAnswer(answerIndex: Int) {
        val currentQuestion = getCurrentQuestion() ?: return
        
        _uiState.update { state ->
            val isCorrect = answerIndex == currentQuestion.correctAnswer
            val newScore = state.score + if (isCorrect) 10 else 0
            val newCorrectAnswers = state.correctAnswers + if (isCorrect) 1 else 0
            
            state.copy(
                selectedAnswer = answerIndex,
                isAnswerCorrect = isCorrect,
                score = newScore,
                correctAnswers = newCorrectAnswers
            )
        }
    }

    fun nextQuestion() {
        _uiState.update { state ->
            val nextIndex = state.currentQuestionIndex + 1
            
            if (nextIndex >= state.totalQuestions) {
                state.copy(
                    isGameFinished = true,
                    isGameActive = false
                ).also {
                    navigateTo(GameScreen.RESULTS)
                }
            } else {
                state.copy(
                    currentQuestionIndex = nextIndex,
                    selectedAnswer = null,
                    isAnswerCorrect = null
                )
            }
        }
    }

    fun finishGame() {
        _uiState.update { state ->
            state.copy(
                isGameFinished = true,
                isGameActive = false
            )
        }
        navigateTo(GameScreen.RESULTS)
    }

    fun restartGame() {
        _uiState.update { state ->
            state.copy(
                currentQuestionIndex = 0,
                score = 0,
                correctAnswers = 0,
                isGameActive = true,
                isGameFinished = false,
                selectedAnswer = null,
                isAnswerCorrect = null
            )
        }
        navigateTo(GameScreen.GAME)
    }

    fun resetToMenu() {
        _uiState.update { GameState() }
        navigateTo(GameScreen.CATEGORY_SELECTION)
    }

    fun getCurrentQuestion(): Question? {
        val state = _uiState.value
        return if (state.currentQuestionIndex < currentQuestions.size) {
            currentQuestions[state.currentQuestionIndex]
        } else {
            null
        }
    }

    fun getEncouragementMessage(): String {
        val percentage = if (_uiState.value.totalQuestions > 0) {
            _uiState.value.correctAnswers.toFloat() / _uiState.value.totalQuestions
        } else 0f
        
        return when {
            percentage >= 0.9f -> "Mükemmel! Süpersin Mete!"
            percentage >= 0.7f -> "Harika! Çok iyi gidiyorsun!"
            percentage >= 0.5f -> "Güzel! Devam et!"
            else -> "Pekala, biraz daha çalışalım!"
        }
    }

    fun getStarRating(): Int {
        val percentage = if (_uiState.value.totalQuestions > 0) {
            _uiState.value.correctAnswers.toFloat() / _uiState.value.totalQuestions
        } else 0f
        
        return when {
            percentage >= 0.8f -> 3
            percentage >= 0.6f -> 2
            else -> 1
        }
    }
}