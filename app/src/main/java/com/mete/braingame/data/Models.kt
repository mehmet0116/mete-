package com.mete.braingame.data

/**
 * Represents a game category
 */
data class GameCategory(
    val id: String,
    val name: String,
    val nameEn: String,
    val icon: String,
    val color: Long
)

/**
 * Question type
 */
enum class QuestionType {
    PATTERN,
    MATCHING,
    COUNTING,
    MEMORY,
    QUIZ
}

/**
 * Represents a single question
 */
data class Question(
    val id: String,
    val type: QuestionType,
    val category: String,
    val question: String,
    val questionEn: String,
    val options: List<String>,
    val correctAnswer: Int,
    val items: List<String> = emptyList(),
    val voice: String? = null
)

/**
 * Game state
 */
data class GameState(
    val currentCategory: String? = null,
    val currentQuestion: Int = 0,
    val score: Int = 0,
    val questionsAnswered: Int = 0,
    val correctAnswers: Int = 0
)
