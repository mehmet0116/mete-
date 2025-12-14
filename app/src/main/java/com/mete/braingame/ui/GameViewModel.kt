package com.mete.braingame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mete.braingame.data.Category
import com.mete.braingame.data.GameData
import com.mete.braingame.data.GameEvent
import com.mete.braingame.data.GameScreen
import com.mete.braingame.data.GameState
import com.mete.braingame.data.Question
import com.mete.braingame.data.UserAnswer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameState())
    val uiState: StateFlow<GameState> = _uiState.asStateFlow()

    private val _currentScreen = MutableStateFlow<GameScreen>(GameScreen.Welcome)
    val currentScreen: StateFlow<GameScreen> = _currentScreen.asStateFlow()

    private var currentQuestions: List<Question> = emptyList()

    fun handleEvent(event: GameEvent) {
        when (event) {
            is GameEvent.StartGame -> {
                _currentScreen.value = GameScreen.CategorySelection
            }

            is GameEvent.SelectCategory -> {
                startGameWithCategory(event.category)
            }

            is GameEvent.AnswerQuestion -> {
                handleAnswer(event.answer)
            }

            is GameEvent.NextQuestion -> {
                nextQuestion()
            }

            is GameEvent.FinishGame -> {
                finishGame()
            }

            is GameEvent.RestartGame -> {
                restartGame()
            }

            is GameEvent.NavigateToCategories -> {
                _currentScreen.value = GameScreen.CategorySelection
                _uiState.value = GameState()
            }
        }
    }

    private fun startGameWithCategory(category: Category) {
        viewModelScope.launch {
            currentQuestions = GameData.getQuestionsForCategory(category.id)
            
            _uiState.update { state ->
                state.copy(
                    selectedCategory = category,
                    currentQuestionIndex = 0,
                    score = 0,
                    totalQuestions = currentQuestions.size,
                    isGameCompleted = false,
                    userAnswers = emptyList()
                )
            }
            
            _currentScreen.value = GameScreen.Game
        }
    }

    private fun handleAnswer(answer: String) {
        val currentState = _uiState.value
        val currentQuestion = currentQuestions.getOrNull(currentState.currentQuestionIndex) ?: return
        
        val isCorrect = answer == currentQuestion.correctAnswer
        val newScore = if (isCorrect) currentState.score + 1 else currentState.score
        
        val userAnswer = UserAnswer(
            questionId = currentQuestion.id,
            selectedAnswer = answer,
            isCorrect = isCorrect
        )
        
        _uiState.update { state ->
            state.copy(
                score = newScore,
                userAnswers = state.userAnswers + userAnswer
            )
        }
    }

    private fun nextQuestion() {
        val currentState = _uiState.value
        val nextIndex = currentState.currentQuestionIndex + 1
        
        if (nextIndex >= currentState.totalQuestions) {
            finishGame()
        } else {
            _uiState.update { state ->
                state.copy(currentQuestionIndex = nextIndex)
            }
        }
    }

    private fun finishGame() {
        _uiState.update { state ->
            state.copy(isGameCompleted = true)
        }
        _currentScreen.value = GameScreen.Results
    }

    private fun restartGame() {
        val currentCategory = _uiState.value.selectedCategory
        if (currentCategory != null) {
            startGameWithCategory(currentCategory)
        } else {
            _currentScreen.value = GameScreen.CategorySelection
            _uiState.value = GameState()
        }
    }

    fun getCurrentQuestion(): Question? {
        return currentQuestions.getOrNull(_uiState.value.currentQuestionIndex)
    }

    fun getStarRating(): Int {
        val state = _uiState.value
        if (state.totalQuestions == 0) return 0
        
        val percentage = state.score.toFloat() / state.totalQuestions.toFloat()
        
        return when {
            percentage >= 0.9f -> 3
            percentage >= 0.7f -> 2
            percentage >= 0.5f -> 1
            else -> 0
        }
    }
}