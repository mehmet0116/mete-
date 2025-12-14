package com.mete.braingame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mete.braingame.data.GameData
import com.mete.braingame.data.GameState
import com.mete.braingame.data.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    private val _currentQuestions = MutableStateFlow<List<Question>>(emptyList())
    val currentQuestions: StateFlow<List<Question>> = _currentQuestions.asStateFlow()

    private val _selectedCategoryId = MutableStateFlow<Int?>(null)
    val selectedCategoryId: StateFlow<Int?> = _selectedCategoryId.asStateFlow()

    fun selectCategory(categoryId: Int) {
        viewModelScope.launch {
            _selectedCategoryId.value = categoryId
            val questions = GameData.getQuestionsForCategory(categoryId)
            _currentQuestions.value = questions
            _gameState.value = GameState(totalQuestions = questions.size)
        }
    }

    fun selectAnswer(answerIndex: Int) {
        val currentState = _gameState.value
        val currentQuestions = _currentQuestions.value
        
        if (currentState.currentQuestionIndex >= currentQuestions.size) return
        
        val currentQuestion = currentQuestions[currentState.currentQuestionIndex]
        val isCorrect = answerIndex == currentQuestion.correctAnswer
        
        viewModelScope.launch {
            _gameState.value = currentState.copy(
                selectedAnswer = answerIndex,
                isAnswerCorrect = isCorrect,
                score = if (isCorrect) currentState.score + 1 else currentState.score
            )
        }
    }

    fun nextQuestion() {
        val currentState = _gameState.value
        val nextIndex = currentState.currentQuestionIndex + 1
        
        viewModelScope.launch {
            _gameState.value = if (nextIndex >= currentState.totalQuestions) {
                currentState.copy(
                    isGameOver = true,
                    selectedAnswer = null,
                    isAnswerCorrect = null
                )
            } else {
                currentState.copy(
                    currentQuestionIndex = nextIndex,
                    selectedAnswer = null,
                    isAnswerCorrect = null
                )
            }
        }
    }

    fun resetGame() {
        viewModelScope.launch {
            _gameState.value = GameState(
                totalQuestions = _currentQuestions.value.size
            )
        }
    }

    fun getCurrentQuestion(): Question? {
        val state = _gameState.value
        val questions = _currentQuestions.value
        
        return if (state.currentQuestionIndex < questions.size) {
            questions[state.currentQuestionIndex]
        } else {
            null
        }
    }

    fun getStars(): Int {
        val state = _gameState.value
        val percentage = if (state.totalQuestions > 0) {
            state.score.toFloat() / state.totalQuestions.toFloat()
        } else {
            0f
        }
        
        return when {
            percentage >= 0.8f -> 3
            percentage >= 0.5f -> 2
            else -> 1
        }
    }
}