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
    val explanation: String? = null
)

// Oyun durumu
data class GameState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val selectedCategory: Category? = null,
    val isGameActive: Boolean = false,
    val isGameFinished: Boolean = false,
    val userAnswers: List<Int> = emptyList(),
    val showResult: Boolean = false,
    val lastAnswerCorrect: Boolean? = null
)

// Kullanıcı cevabı
data class UserAnswer(
    val questionId: Int,
    val selectedOption: Int,
    val isCorrect: Boolean,
    val timeTaken: Long
)