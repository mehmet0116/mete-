package com.mete.braingame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mete.braingame.data.Category
import com.mete.braingame.data.GameData
import com.mete.braingame.data.GameResult
import com.mete.braingame.data.GameState
import com.mete.braingame.data.Question
import com.mete.braingame.data.Screen
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val _currentScreen = MutableStateFlow<Screen>(Screen.Welcome)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    private val _selectedCategory = MutableStateFlow<Category?>(null)
    val selectedCategory: StateFlow<Category?> = _selectedCategory.asStateFlow()

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions.asStateFlow()

    private val _gameResult = MutableStateFlow<GameResult?>(null)
    val gameResult: StateFlow<GameResult?> = _gameResult.asStateFlow()

    private var timerJob: Job? = null

    fun navigateTo(screen: Screen) {
        _currentScreen.value = screen
    }

    fun selectCategory(categoryId: Int) {
        val category = GameData.getCategoryById(categoryId)
        _selectedCategory.value = category
        val questions = GameData.getQuestionsForCategory(categoryId)
        _questions.value = questions
        startGame(questions)
    }

    private fun startGame(questions: List<Question>) {
        _gameState.update {
            it.copy(
                currentQuestionIndex = 0,
                score = 0,
                correctAnswers = 0,
                totalQuestions = questions.size,
                timeRemaining = questions.firstOrNull()?.timeLimit ?: 30,
                isGameActive = true,
                selectedAnswer = null,
                isAnswered = false,
                feedbackMessage = ""
            )
        }
        startTimer()
        navigateTo(Screen.Game(selectedCategory.value?.id ?: 1))
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_gameState.value.isGameActive && _gameState.value.timeRemaining > 0) {
                delay(1000)
                _gameState.update { state ->
                    if (state.isAnswered) {
                        state
                    } else {
                        val newTime = state.timeRemaining - 1
                        if (newTime <= 0) {
                            handleTimeout()
                            state.copy(timeRemaining = 0)
                        } else {
                            state.copy(timeRemaining = newTime)
                        }
                    }
                }
            }
        }
    }

    fun selectAnswer(answerIndex: Int) {
        if (_gameState.value.isAnswered) return

        val currentQuestion = _questions.value.getOrNull(_gameState.value.currentQuestionIndex)
        if (currentQuestion == null) {
            finishGame()
            return
        }

        val isCorrect = answerIndex == currentQuestion.correctAnswer
        val points = if (isCorrect) currentQuestion.points else 0

        _gameState.update { state ->
            state.copy(
                selectedAnswer = answerIndex,
                isAnswered = true,
                score = state.score + points,
                correctAnswers = if (isCorrect) state.correctAnswers + 1 else state.correctAnswers,
                feedbackMessage = if (isCorrect) "Doğru!" else "Yanlış!"
            )
        }

        // Speak feedback
        // voiceManager.speak(if (isCorrect) "Bravo Mete!" else "Tekrar deneyelim!")
    }

    private fun handleTimeout() {
        _gameState.update { state ->
            state.copy(
                isAnswered = true,
                feedbackMessage = "Süre doldu!"
            )
        }
    }

    fun nextQuestion() {
        val nextIndex = _gameState.value.currentQuestionIndex + 1
        if (nextIndex >= _questions.value.size) {
            finishGame()
        } else {
            val nextQuestion = _questions.value[nextIndex]
            _gameState.update { state ->
                state.copy(
                    currentQuestionIndex = nextIndex,
                    timeRemaining = nextQuestion.timeLimit,
                    selectedAnswer = null,
                    isAnswered = false,
                    feedbackMessage = ""
                )
            }
            startTimer()
        }
    }

    private fun finishGame() {
        timerJob?.cancel()
        
        val state = _gameState.value
        val stars = calculateStars(state.score, state.totalQuestions)
        val feedback = getFeedback(stars)
        
        _gameResult.value = GameResult(
            score = state.score,
            correctAnswers = state.correctAnswers,
            totalQuestions = state.totalQuestions,
            timeSpent = calculateTimeSpent(),
            stars = stars,
            feedback = feedback
        )
        
        _gameState.update { it.copy(isGameActive = false) }
        navigateTo(Screen.Results)
    }

    private fun calculateStars(score: Int, totalQuestions: Int): Int {
        val percentage = if (totalQuestions > 0) score.toFloat() / (totalQuestions * 10) else 0f
        return when {
            percentage >= 0.8f -> 3
            percentage >= 0.6f -> 2
            else -> 1
        }
    }

    private fun getFeedback(stars: Int): String {
        return when (stars) {
            3 -> "Mükemmel! Mete!"
            2 -> "Harika! Çok iyisin!"
            else -> "İyi gidiyorsun!"
        }
    }

    private fun calculateTimeSpent(): Int {
        val totalTime = _questions.value.sumOf { it.timeLimit }
        return totalTime - _gameState.value.timeRemaining
    }

    fun resetGame() {
        timerJob?.cancel()
        _gameState.value = GameState()
        _gameResult.value = null
        _selectedCategory.value = null
        _questions.value = emptyList()
        navigateTo(Screen.Welcome)
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}