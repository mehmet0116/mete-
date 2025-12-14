package com.mete.braingame.data

import androidx.compose.ui.graphics.Color

// Kategori modeli
data class Category(
    val id: Int,
    val name: String,
    val displayName: String,
    val color: Color,
    val icon: String,
    val description: String,
    val totalQuestions: Int
)

// Soru modeli
data class Question(
    val id: Int,
    val categoryId: Int,
    val text: String,
    val imageRes: String? = null,
    val soundRes: String? = null,
    val options: List<String>,
    val correctAnswer: Int,
    val explanation: String? = null,
    val timeLimit: Int = 30,
    val points: Int = 10
)

// Ekranlar
sealed class Screen {
    data object Welcome : Screen()
    data object CategorySelection : Screen()
    data class Game(val categoryId: Int) : Screen()
    data object Results : Screen()
}

// Oyun durumu
data class GameState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val selectedCategory: Category? = null,
    val isGameActive: Boolean = false,
    val isGameFinished: Boolean = false,
    val userAnswers: List<Int> = emptyList(),
    val showResult: Boolean = false,
    val lastAnswerCorrect: Boolean? = null,
    val correctAnswers: Int = 0,
    val totalQuestions: Int = 0,
    val timeRemaining: Int = 0,
    val selectedAnswer: Int? = null,
    val isAnswered: Boolean = false,
    val feedbackMessage: String = ""
)

// Oyun sonucu
data class GameResult(
    val score: Int,
    val correctAnswers: Int,
    val totalQuestions: Int,
    val timeSpent: Int,
    val stars: Int,
    val feedback: String
)

// Kullanıcı cevabı
data class UserAnswer(
    val questionId: Int,
    val selectedOption: Int,
    val isCorrect: Boolean,
    val timeTaken: Long
)