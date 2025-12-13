package com.mete.braingame.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Manages user progress and achievements using SharedPreferences
 */
class ProgressManager(context: Context) {
    private val prefs: SharedPreferences = 
        context.getSharedPreferences("mete_brain_game_progress", Context.MODE_PRIVATE)
    private val gson = Gson()
    
    companion object {
        private const val KEY_TOTAL_SCORE = "total_score"
        private const val KEY_TOTAL_QUESTIONS = "total_questions"
        private const val KEY_TOTAL_CORRECT = "total_correct"
        private const val KEY_CATEGORY_PROGRESS = "category_progress"
        private const val KEY_ACHIEVEMENTS = "achievements"
        private const val KEY_CURRENT_STREAK = "current_streak"
        private const val KEY_LONGEST_STREAK = "longest_streak"
        private const val KEY_LAST_PLAYED = "last_played"
        private const val KEY_MASTERED_WORDS = "mastered_words_"
    }
    
    /**
     * Get current user progress
     */
    fun getUserProgress(): UserProgress {
        val categoryProgressMap = getCategoryProgressMap()
        val achievements = getAchievements()
        
        return UserProgress(
            totalScore = prefs.getInt(KEY_TOTAL_SCORE, 0),
            totalQuestionsAnswered = prefs.getInt(KEY_TOTAL_QUESTIONS, 0),
            totalCorrectAnswers = prefs.getInt(KEY_TOTAL_CORRECT, 0),
            categoryProgress = categoryProgressMap,
            achievements = achievements,
            currentStreak = prefs.getInt(KEY_CURRENT_STREAK, 0),
            longestStreak = prefs.getInt(KEY_LONGEST_STREAK, 0),
            lastPlayedDate = prefs.getString(KEY_LAST_PLAYED, "") ?: ""
        )
    }
    
    /**
     * Update progress after completing questions
     */
    fun updateProgress(
        categoryId: String,
        questionsAnswered: Int,
        correctAnswers: Int,
        newMasteredWords: Set<String> = emptySet()
    ) {
        val editor = prefs.edit()
        
        // Update totals
        val currentTotal = prefs.getInt(KEY_TOTAL_QUESTIONS, 0)
        val currentCorrect = prefs.getInt(KEY_TOTAL_CORRECT, 0)
        val currentScore = prefs.getInt(KEY_TOTAL_SCORE, 0)
        
        editor.putInt(KEY_TOTAL_QUESTIONS, currentTotal + questionsAnswered)
        editor.putInt(KEY_TOTAL_CORRECT, currentCorrect + correctAnswers)
        editor.putInt(KEY_TOTAL_SCORE, currentScore + correctAnswers * 10)
        
        // Update category progress
        updateCategoryProgress(categoryId, questionsAnswered, correctAnswers, newMasteredWords)
        
        // Update streak
        updateStreak()
        
        // Check and unlock achievements
        checkAchievements()
        
        editor.apply()
    }
    
    /**
     * Update category-specific progress
     */
    private fun updateCategoryProgress(
        categoryId: String,
        questionsAnswered: Int,
        correctAnswers: Int,
        newMasteredWords: Set<String>
    ) {
        val progressMap = getCategoryProgressMap().toMutableMap()
        val currentProgress = progressMap[categoryId] ?: CategoryProgress(categoryId)
        
        val masteredWords = getMasteredWords(categoryId).toMutableSet()
        masteredWords.addAll(newMasteredWords)
        
        val updatedProgress = currentProgress.copy(
            totalQuestions = currentProgress.totalQuestions + questionsAnswered,
            completedQuestions = currentProgress.completedQuestions + questionsAnswered,
            correctAnswers = currentProgress.correctAnswers + correctAnswers,
            masteredWords = masteredWords,
            lastPlayedTime = System.currentTimeMillis()
        )
        
        progressMap[categoryId] = updatedProgress
        saveCategoryProgressMap(progressMap)
        saveMasteredWords(categoryId, masteredWords)
    }
    
    /**
     * Get progress for a specific category
     */
    fun getCategoryProgress(categoryId: String): CategoryProgress {
        return getCategoryProgressMap()[categoryId] ?: CategoryProgress(categoryId)
    }
    
    /**
     * Get all category progress as a map
     */
    private fun getCategoryProgressMap(): Map<String, CategoryProgress> {
        val json = prefs.getString(KEY_CATEGORY_PROGRESS, null) ?: return emptyMap()
        val type = object : TypeToken<Map<String, CategoryProgress>>() {}.type
        return gson.fromJson(json, type)
    }
    
    /**
     * Save category progress map
     */
    private fun saveCategoryProgressMap(progressMap: Map<String, CategoryProgress>) {
        val json = gson.toJson(progressMap)
        prefs.edit().putString(KEY_CATEGORY_PROGRESS, json).apply()
    }
    
    /**
     * Get mastered words for a category
     */
    private fun getMasteredWords(categoryId: String): Set<String> {
        val json = prefs.getString(KEY_MASTERED_WORDS + categoryId, null) ?: return emptySet()
        val type = object : TypeToken<Set<String>>() {}.type
        return gson.fromJson(json, type)
    }
    
    /**
     * Save mastered words for a category
     */
    private fun saveMasteredWords(categoryId: String, words: Set<String>) {
        val json = gson.toJson(words)
        prefs.edit().putString(KEY_MASTERED_WORDS + categoryId, json).apply()
    }
    
    /**
     * Update daily streak
     */
    private fun updateStreak() {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val lastPlayed: String = prefs.getString(KEY_LAST_PLAYED, "") ?: ""
        val currentStreak = prefs.getInt(KEY_CURRENT_STREAK, 0)
        val longestStreak = prefs.getInt(KEY_LONGEST_STREAK, 0)
        
        val newStreak = if (lastPlayed.isEmpty()) {
            1
        } else if (isYesterday(lastPlayed)) {
            currentStreak + 1
        } else if (lastPlayed == today) {
            currentStreak
        } else {
            1
        }
        
        val newLongest = maxOf(newStreak, longestStreak)
        
        prefs.edit()
            .putInt(KEY_CURRENT_STREAK, newStreak)
            .putInt(KEY_LONGEST_STREAK, newLongest)
            .putString(KEY_LAST_PLAYED, today)
            .apply()
    }
    
    /**
     * Check if date string is yesterday (using Calendar for DST safety)
     */
    private fun isYesterday(dateStr: String): Boolean {
        return try {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = sdf.parse(dateStr) ?: return false
            
            val dateCalendar = java.util.Calendar.getInstance().apply {
                time = date
            }
            val yesterday = java.util.Calendar.getInstance().apply {
                add(java.util.Calendar.DAY_OF_MONTH, -1)
            }
            
            dateCalendar.get(java.util.Calendar.YEAR) == yesterday.get(java.util.Calendar.YEAR) &&
                    dateCalendar.get(java.util.Calendar.DAY_OF_YEAR) == yesterday.get(java.util.Calendar.DAY_OF_YEAR)
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * Get all achievements
     */
    private fun getAchievements(): List<Achievement> {
        val json = prefs.getString(KEY_ACHIEVEMENTS, null)
        if (json != null) {
            val type = object : TypeToken<List<Achievement>>() {}.type
            return gson.fromJson(json, type)
        }
        return initializeAchievements()
    }
    
    /**
     * Initialize default achievements
     */
    private fun initializeAchievements(): List<Achievement> {
        return listOf(
            Achievement("first_win", "İlk Başarı!", "İlk soruyu doğru cevapla", "🎯", false),
            Achievement("10_correct", "10 Doğru!", "10 soruyu doğru cevapla", "⭐", false),
            Achievement("50_correct", "Süpersin!", "50 soruyu doğru cevapla", "🌟", false),
            Achievement("100_correct", "Uzman!", "100 soruyu doğru cevapla", "🏆", false),
            Achievement("all_categories", "Keşifçi!", "Tüm kategorileri dene", "🗺️", false),
            Achievement("streak_3", "3 Gün!", "3 gün üst üste oyna", "🔥", false),
            Achievement("streak_7", "Hafta Kahramanı!", "7 gün üst üste oyna", "💪", false),
            Achievement("master_animals", "Hayvan Uzmanı!", "Hayvanlar kategorisini tamamla", "🦁", false),
            Achievement("master_numbers", "Sayı Ustası!", "Sayılar kategorisini tamamla", "🔢", false),
            Achievement("english_pro", "İngilizce Yıldızı!", "20 İngilizce kelime öğren", "🌠", false)
        )
    }
    
    /**
     * Check and unlock achievements based on current progress
     */
    private fun checkAchievements() {
        val achievements = getAchievements().toMutableList()
        val totalCorrect = prefs.getInt(KEY_TOTAL_CORRECT, 0)
        val currentStreak = prefs.getInt(KEY_CURRENT_STREAK, 0)
        val categoryProgress = getCategoryProgressMap()
        var updated = false
        
        // Check correct answer achievements
        achievements.forEachIndexed { index, achievement ->
            if (!achievement.isUnlocked) {
                val shouldUnlock = when (achievement.id) {
                    "first_win" -> totalCorrect >= 1
                    "10_correct" -> totalCorrect >= 10
                    "50_correct" -> totalCorrect >= 50
                    "100_correct" -> totalCorrect >= 100
                    "all_categories" -> categoryProgress.size >= 6
                    "streak_3" -> currentStreak >= 3
                    "streak_7" -> currentStreak >= 7
                    "master_animals" -> (categoryProgress["animals"]?.completedQuestions ?: 0) >= 15
                    "master_numbers" -> (categoryProgress["numbers"]?.completedQuestions ?: 0) >= 15
                    "english_pro" -> {
                        val totalMastered = categoryProgress.values.sumOf { it.masteredWords.size }
                        totalMastered >= 20
                    }
                    else -> false
                }
                
                if (shouldUnlock) {
                    achievements[index] = achievement.copy(
                        isUnlocked = true,
                        unlockedDate = System.currentTimeMillis()
                    )
                    updated = true
                }
            }
        }
        
        if (updated) {
            val json = gson.toJson(achievements)
            prefs.edit().putString(KEY_ACHIEVEMENTS, json).apply()
        }
    }
    
    /**
     * Reset all progress (for testing or user request)
     */
    fun resetProgress() {
        prefs.edit().clear().apply()
    }
}
