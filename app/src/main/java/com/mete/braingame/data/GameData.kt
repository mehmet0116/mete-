package com.mete.braingame.data

/**
 * Oyun verileri - Tüm kategoriler ve sorular
 */
object GameData {
    
    val categories = listOf(
        Category(
            id = 1,
            name = "Hayvanlar",
            iconRes = "🦁",
            description = "25 hayvan - gerçek seslerle!",
            color = 0xFF4CAF50,
            totalQuestions = 10
        ),
        Category(
            id = 2,
            name = "Sayılar",
            iconRes = "🔢",
            description = "16 sayı - 1'den 20'ye",
            color = 0xFF2196F3,
            totalQuestions = 10
        ),
        Category(
            id = 3,
            name = "Şekiller",
            iconRes = "⭐",
            description = "10 şekil",
            color = 0xFFFF9800,
            totalQuestions = 8
        ),
        Category(
            id = 4,
            name = "Renkler",
            iconRes = "🎨",
            description = "12 renk",
            color = 0xFFE91E63,
            totalQuestions = 8
        ),
        Category(
            id = 5,
            name = "Meyveler",
            iconRes = "🍎",
            description = "14 meyve",
            color = 0xFF9C27B0,
            totalQuestions = 8
        ),
        Category(
            id = 6,
            name = "Sebzeler",
            iconRes = "🥕",
            description = "12 sebze",
            color = 0xFF009688,
            totalQuestions = 8
        ),
        Category(
            id = 7,
            name = "Vücut Bölümleri",
            iconRes = "👁️",
            description = "12 organ",
            color = 0xFF795548,
            totalQuestions = 8
        ),
        Category(
            id = 8,
            name = "Hareketler",
            iconRes = "🏃",
            description = "12 hareket",
            color = 0xFF607D8B,
            totalQuestions = 8
        ),
        Category(
            id = 9,
            name = "Zaman",
            iconRes = "📅",
            description = "11 kavram",
            color = 0xFF3F51B5,
            totalQuestions = 8
        ),
        Category(
            id = 10,
            name = "Harfler",
            iconRes = "📝",
            description = "16 harf",
            color = 0xFF00BCD4,
            totalQuestions = 10
        )
    )
    
    // Örnek sorular - Hayvanlar kategorisi için
    val animalQuestions = listOf(
        Question(
            id = 1,
            categoryId = 1,
            text = "Hangi hayvan 'miyav' sesi çıkarır?",
            imageRes = "cat_image",
            soundRes = "cat_sound",
            options = listOf("Köpek", "Kedi", "Kuş", "İnek"),
            correctAnswer = 1,
            explanation = "Kediler 'miyav' sesi çıkarır!"
        ),
        Question(
            id = 2,
            categoryId = 1,
            text = "Hangi hayvan havlar?",
            imageRes = "dog_image",
            soundRes = "dog_sound",
            options = listOf("Kedi", "Köpek", "Tavuk", "Ördek"),
            correctAnswer = 1,
            explanation = "Köpekler havlar!"
        ),
        Question(
            id = 3,
            categoryId = 1,
            text = "Hangi hayvan öter?",
            imageRes = "bird_image",
            soundRes = "bird_sound",
            options = listOf("Kedi", "Köpek", "Kuş", "Balık"),
            correctAnswer = 2,
            explanation = "Kuşlar öter!"
        )
    )
    
    // Sayılar kategorisi için örnek sorular
    val numberQuestions = listOf(
        Question(
            id = 101,
            categoryId = 2,
            text = "Kaç tane elma var?",
            imageRes = "three_apples",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 1,
            explanation = "Resimde 3 elma var!"
        ),
        Question(
            id = 102,
            categoryId = 2,
            text = "1'den sonra hangi sayı gelir?",
            options = listOf("0", "2", "3", "4"),
            correctAnswer = 1,
            explanation = "1'den sonra 2 gelir!"
        )
    )
    
    /**
     * Kategori ID'sine göre soruları getir
     */
    fun getQuestionsForCategory(categoryId: Int): List<Question> {
        return when (categoryId) {
            1 -> animalQuestions
            2 -> numberQuestions
            else -> animalQuestions // Varsayılan olarak hayvan soruları
        }
    }
    
    /**
     * Karıştırılmış sorular getir
     */
    fun getShuffledQuestions(categoryId: Int, count: Int = 5): List<Question> {
        val allQuestions = getQuestionsForCategory(categoryId)
        return allQuestions.shuffled().take(count)
    }
}