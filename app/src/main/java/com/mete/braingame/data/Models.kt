package com.mete.braingame.data

import androidx.compose.runtime.Immutable

@Immutable
data class Category(
    val id: Int,
    val name: String,
    val displayName: String,
    val colorRes: String,
    val iconRes: String,
    val description: String,
    val totalQuestions: Int
)

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

@Immutable
data class GameState(
    val currentCategory: Category? = null,
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val correctAnswers: Int = 0,
    val totalQuestions: Int = 0,
    val isGameActive: Boolean = false,
    val isGameFinished: Boolean = false,
    val selectedAnswer: Int? = null,
    val isAnswerCorrect: Boolean? = null
)

enum class GameScreen {
    WELCOME,
    CATEGORY_SELECTION,
    GAME,
    RESULTS
}