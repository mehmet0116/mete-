package com.mete.braingame.data

import androidx.compose.runtime.Immutable

@Immutable
data class Category(
    val id: Int,
    val name: String,
    val icon: String,
    val description: String,
    val color: Long
)

@Immutable
data class Question(
    val id: Int,
    val categoryId: Int,
    val text: String,
    val imageRes: String? = null,
    val options: List<String>,
    val correctAnswer: Int,
    val audioRes: String? = null
)

data class GameState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val totalQuestions: Int = 10,
    val isGameOver: Boolean = false,
    val selectedAnswer: Int? = null,
    val isAnswerCorrect: Boolean? = null
)