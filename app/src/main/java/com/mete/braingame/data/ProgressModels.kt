package com.mete.braingame.data

/**
 * Data models for user progress and achievements
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

data class CategoryProgress(
    val categoryId: String,
    val totalQuestions: Int = 0,
    val completedQuestions: Int = 0,
    val correctAnswers: Int = 0,
    val masteredWords: Set<String> = emptySet(),
    val lastPlayedTime: Long = 0L
)

data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val emoji: String,
    val isUnlocked: Boolean = false,
    val unlockedDate: Long? = null
)

