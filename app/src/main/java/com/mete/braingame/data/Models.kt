package com.mete.braingame.data

import androidx.compose.runtime.Immutable

/**
 * Oyun kategorisi modeli
 */
@Immutable
data class Category(
    val id: Int,
    val name: String,
    val iconRes: String,
    val description: String,
    val color: Long,
    val totalQuestions: Int
)

/**
 * Soru modeli
 */
@Immutable
data class Question(
    val id: Int,
    val categoryId: Int,
    val text: String,
    val imageRes: String? = null,
    val soundRes: String? = null,
    val options: List<String>,
    val correctAnswer: Int,
    val explanation: String? = null
)

/**
 * Oyun durumu
 */
data class GameState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val totalQuestions: Int = 0,
    val isGameOver: Boolean = false,
    val selectedAnswer: Int? = null,
    val isAnswerCorrect: Boolean? = null,
    val timeRemaining: Int = 30 // saniye
)

/**
 * Oyun sonucu
 */
data class GameResult(
    val score: Int,
    val totalQuestions: Int,
    val correctAnswers: Int,
    val wrongAnswers: Int,
    val timeSpent: Int, // saniye
    val stars: Int // 1-3 yıldız
) {
    val percentage: Float
        get() = if (totalQuestions > 0) (correctAnswers.toFloat() / totalQuestions) * 100 else 0f
    
    fun calculateStars(): Int {
        return when {
            percentage >= 90 -> 3
            percentage >= 70 -> 2
            else -> 1
        }
    }
}