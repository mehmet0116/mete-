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

/**
 * Difficulty level for questions
 */
enum class DifficultyLevel {
    EASY,
    MEDIUM,
    HARD
}

/**
 * Progress tracking for a category
 */
data class CategoryProgress(
    val categoryId: String,
    val totalQuestions: Int = 0,
    val completedQuestions: Int = 0,
    val correctAnswers: Int = 0,
    val masteredWords: Set<String> = emptySet(),
    val lastPlayedTime: Long = 0L
)

/**
 * User achievement
 */
data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val icon: String,
    val isUnlocked: Boolean = false,
    val unlockedDate: Long? = null
)

/**
 * Overall user progress
 */
data class UserProgress(
    val totalScore: Int = 0,
    val totalQuestionsAnswered: Int = 0,
    val totalCorrectAnswers: Int = 0,
    val categoryProgress: Map<String, CategoryProgress> = emptyMap(),
    val achievements: List<Achievement> = emptyList(),
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val lastPlayedDate: String = ""
)
