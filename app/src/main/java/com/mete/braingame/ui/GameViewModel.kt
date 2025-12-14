package com.mete.braingame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mete.braingame.data.Category
import com.mete.braingame.data.GameData
import com.mete.braingame.data.GameResult
import com.mete.braingame.data.GameState
import com.mete.braingame.data.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    
    // UI state
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    
    // Game state
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()
    
    // Categories
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories.asStateFlow()
    
    // Current questions
    private val _currentQuestions = MutableStateFlow<List<Question>>(emptyList())
    val currentQuestions: StateFlow<List<Question>> = _currentQuestions.asStateFlow()
    
    // Game result
    private val _gameResult = MutableStateFlow<GameResult?>(null)
    val gameResult: StateFlow<GameResult?> = _gameResult.asStateFlow()
    
    init {
        loadCategories()
    }
    
    private fun loadCategories() {
        _categories.value = GameData.categories
    }
    
    fun selectCategory(category: Category) {
        _uiState.update { it.copy(selectedCategory = category) }
        startGame(category.id)
    }
    
    fun startGame(categoryId: Int) {
        viewModelScope.launch {
            // Soruları yükle
            val questions = GameData.getShuffledQuestions(categoryId, 5)
            _currentQuestions.value = questions
            
            // Oyun durumunu sıfırla
            _gameState.update {
                it.copy(
                    currentQuestionIndex = 0,
                    score = 0,
                    totalQuestions = questions.size,
                    isGameOver = false,
                    selectedAnswer = null,
                    isAnswerCorrect = null,
                    timeRemaining = 30
                )
            }
            
            // Ekranı değiştir
            _uiState.update {
                it.copy(
                    currentScreen = Screen.GAME,
                    isLoading = false
                )
            }
        }
    }
    
    fun selectAnswer(answerIndex: Int) {
        val currentQuestion = getCurrentQuestion() ?: return
        val isCorrect = answerIndex == currentQuestion.correctAnswer
        
        _gameState.update { state ->
            state.copy(
                selectedAnswer = answerIndex,
                isAnswerCorrect = isCorrect,
                score = if (isCorrect) state.score + 10 else state.score
            )
        }
        
        // 2 saniye sonra sonraki soruya geç
        viewModelScope.launch {
            kotlinx.coroutines.delay(2000)
            nextQuestion()
        }
    }
    
    private fun nextQuestion() {
        _gameState.update { state ->
            val nextIndex = state.currentQuestionIndex + 1
            
            if (nextIndex >= state.totalQuestions) {
                // Oyun bitti
                finishGame()
                state.copy(isGameOver = true)
            } else {
                // Sonraki soru
                state.copy(
                    currentQuestionIndex = nextIndex,
                    selectedAnswer = null,
                    isAnswerCorrect = null,
                    timeRemaining = 30
                )
            }
        }
    }
    
    private fun finishGame() {
        val state = _gameState.value
        val questions = _currentQuestions.value
        
        // Doğru cevap sayısını hesapla
        val correctAnswers = questions.count { question ->
            // Burada gerçekte kullanıcının cevaplarını takip etmemiz gerekir
            // Şimdilik basit bir hesaplama yapıyoruz
            state.score / 10
        }
        
        val result = GameResult(
            score = state.score,
            totalQuestions = state.totalQuestions,
            correctAnswers = correctAnswers,
            wrongAnswers = state.totalQuestions - correctAnswers,
            timeSpent = 30 * state.totalQuestions - state.timeRemaining,
            stars = if (state.totalQuestions > 0) {
                when {
                    correctAnswers >= state.totalQuestions * 0.9 -> 3
                    correctAnswers >= state.totalQuestions * 0.7 -> 2
                    else -> 1
                }
            } else {
                0
            }
        )
        
        _gameResult.value = result
        _uiState.update { it.copy(currentScreen = Screen.RESULTS) }
    }
    
    fun getCurrentQuestion(): Question? {
        val index = _gameState.value.currentQuestionIndex
        return if (index < _currentQuestions.value.size) {
            _currentQuestions.value[index]
        } else {
            null
        }
    }
    
    fun navigateToWelcome() {
        _uiState.update { it.copy(currentScreen = Screen.WELCOME) }
    }
    
    fun navigateToCategories() {
        _uiState.update { it.copy(currentScreen = Screen.CATEGORIES) }
    }
    
    fun resetGame() {
        _gameState.value = GameState()
        _currentQuestions.value = emptyList()
        _gameResult.value = null
        _uiState.update {
            it.copy(
                selectedCategory = null,
                currentScreen = Screen.CATEGORIES
            )
        }
    }
    
    fun updateTimeRemaining(time: Int) {
        _gameState.update { it.copy(timeRemaining = time) }
        
        if (time <= 0) {
            nextQuestion()
        }
    }
}

data class GameUiState(
    val currentScreen: Screen = Screen.WELCOME,
    val selectedCategory: Category? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

enum class Screen {
    WELCOME,
    CATEGORIES,
    GAME,
    RESULTS
}