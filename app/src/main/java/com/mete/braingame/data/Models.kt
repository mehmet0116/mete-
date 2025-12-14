package com.mete.braingame.data

import androidx.compose.runtime.Immutable

@Immutable
data class Category(
    val id: Int,
    val name: String,
    val iconResId: Int = 0, // For future use with vector icons
    val color: Long,
    val description: String = ""
)

@Immutable
data class Question(
    val id: Int,
    val categoryId: Int,
    val text: String,
    val imageResId: Int = 0, // For future use with drawable resources
    val options: List<String>,
    val correctAnswer: String,
    val voicePrompt: String = "",
    val soundResId: Int = 0 // For animal sounds
)

@Immutable
data class GameState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val totalQuestions: Int = 0,
    val selectedCategory: Category? = null,
    val isGameCompleted: Boolean = false,
    val userAnswers: List<UserAnswer> = emptyList()
)

@Immutable
data class UserAnswer(
    val questionId: Int,
    val selectedAnswer: String,
    val isCorrect: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

sealed class GameEvent {
    data object StartGame : GameEvent()
    data class SelectCategory(val category: Category) : GameEvent()
    data class AnswerQuestion(val answer: String) : GameEvent()
    data object NextQuestion : GameEvent()
    data object FinishGame : GameEvent()
    data object RestartGame : GameEvent()
    data object NavigateToCategories : GameEvent()
}

sealed class GameScreen {
    data object Welcome : GameScreen()
    data object CategorySelection : GameScreen()
    data object Game : GameScreen()
    data object Results : GameScreen()
}