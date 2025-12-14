package com.mete.braingame.data

data class Category(
    val id: String,
    val name: String,
    val iconResId: String,
    val color: Long,
    val description: String
)

data class Question(
    val id: String,
    val categoryId: String,
    val text: String,
    val imageResId: String? = null,
    val options: List<String>,
    val correctAnswer: String,
    val audioResId: String? = null
)

data class GameState(
    val currentQuestionIndex: Int = 0,
    val totalQuestions: Int = 0,
    val score: Int = 0,
    val questions: List<Question> = emptyList()
)