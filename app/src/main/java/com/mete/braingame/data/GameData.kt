package com.mete.braingame.data

object GameData {
    val categories = listOf(
        Category(
            id = 1,
            name = "Hayvanlar",
            color = 0xFFFF6B35,
            description = "25 hayvan - gerçek seslerle!"
        ),
        Category(
            id = 2,
            name = "Sayılar",
            color = 0xFF4ECDC4,
            description = "16 sayı - 1'den 20'ye"
        ),
        Category(
            id = 3,
            name = "Şekiller",
            color = 0xFFFFE66D,
            description = "10 şekil"
        ),
        Category(
            id = 4,
            name = "Renkler",
            color = 0xFF9C27B0,
            description = "12 renk"
        ),
        Category(
            id = 5,
            name = "Harfler",
            color = 0xFF2196F3,
            description = "16 harf"
        ),
        Category(
            id = 6,
            name = "Meyveler",
            color = 0xFF4CAF50,
            description = "14 meyve"
        ),
        Category(
            id = 7,
            name = "Sebzeler",
            color = 0xFF8BC34A,
            description = "12 sebze"
        ),
        Category(
            id = 8,
            name = "Vücut Bölümleri",
            color = 0xFFFF9800,
            description = "12 organ"
        ),
        Category(
            id = 9,
            name = "Hareketler",
            color = 0xFF00BCD4,
            description = "12 hareket"
        ),
        Category(
            id = 10,
            name = "Zaman",
            color = 0xFF795548,
            description = "11 kavram"
        )
    )

    fun getQuestionsForCategory(categoryId: Int): List<Question> {
        return when (categoryId) {
            1 -> animalQuestions
            2 -> numberQuestions
            3 -> shapeQuestions
            4 -> colorQuestions
            5 -> letterQuestions
            6 -> fruitQuestions
            7 -> vegetableQuestions
            8 -> bodyPartQuestions
            9 -> movementQuestions
            10 -> timeQuestions
            else -> emptyList()
        }
    }

    private val animalQuestions = listOf(
        Question(
            id = 101,
            categoryId = 1,
            text = "Hangisi aslan?",
            options = listOf("Köpek", "Aslan", "Kedi", "Kuş"),
            correctAnswer = "Aslan",
            voicePrompt = "Hangisi aslan?"
        ),
        Question(
            id = 102,
            categoryId = 1,
            text = "Hangisi fil?",
            options = listOf("Fil", "Zürafa", "Maymun", "Ayı"),
            correctAnswer = "Fil",
            voicePrompt = "Hangisi fil?"
        )
        // Add more questions...
    )

    private val numberQuestions = listOf(
        Question(
            id = 201,
            categoryId = 2,
            text = "Kaç tane elma var?",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = "3",
            voicePrompt = "Kaç tane elma var?"
        ),
        Question(
            id = 202,
            categoryId = 2,
            text = "Hangisi 5 sayısı?",
            options = listOf("3", "5", "7", "9"),
            correctAnswer = "5",
            voicePrompt = "Hangisi beş sayısı?"
        )
        // Add more questions...
    )

    private val shapeQuestions = listOf(
        Question(
            id = 301,
            categoryId = 3,
            text = "Hangisi daire?",
            options = listOf("Kare", "Üçgen", "Daire", "Dikdörtgen"),
            correctAnswer = "Daire",
            voicePrompt = "Hangisi daire?"
        )
        // Add more questions...
    )

    private val colorQuestions = listOf(
        Question(
            id = 401,
            categoryId = 4,
            text = "Hangisi kırmızı?",
            options = listOf("Mavi", "Yeşil", "Kırmızı", "Sarı"),
            correctAnswer = "Kırmızı",
            voicePrompt = "Hangisi kırmızı?"
        )
        // Add more questions...
    )

    private val letterQuestions = listOf(
        Question(
            id = 501,
            categoryId = 5,
            text = "Hangisi A harfi?",
            options = listOf("A", "B", "C", "D"),
            correctAnswer = "A",
            voicePrompt = "Hangisi A harfi?"
        )
        // Add more questions...
    )

    private val fruitQuestions = listOf(
        Question(
            id = 601,
            categoryId = 6,
            text = "Hangisi elma?",
            options = listOf("Elma", "Muz", "Portakal", "Çilek"),
            correctAnswer = "Elma",
            voicePrompt = "Hangisi elma?"
        )
        // Add more questions...
    )

    private val vegetableQuestions = listOf(
        Question(
            id = 701,
            categoryId = 7,
            text = "Hangisi havuç?",
            options = listOf("Havuç", "Patates", "Domates", "Salatalık"),
            correctAnswer = "Havuç",
            voicePrompt = "Hangisi havuç?"
        )
        // Add more questions...
    )

    private val bodyPartQuestions = listOf(
        Question(
            id = 801,
            categoryId = 8,
            text = "Hangisi göz?",
            options = listOf("Göz", "Kulak", "Burun", "Ağız"),
            correctAnswer = "Göz",
            voicePrompt = "Hangisi göz?"
        )
        // Add more questions...
    )

    private val movementQuestions = listOf(
        Question(
            id = 901,
            categoryId = 9,
            text = "Hangisi zıplamak?",
            options = listOf("Koşmak", "Zıplamak", "Yürümek", "Yüzmek"),
            correctAnswer = "Zıplamak",
            voicePrompt = "Hangisi zıplamak?"
        )
        // Add more questions...
    )

    private val timeQuestions = listOf(
        Question(
            id = 1001,
            categoryId = 10,
            text = "Hangisi sabah?",
            options = listOf("Sabah", "Öğle", "Akşam", "Gece"),
            correctAnswer = "Sabah",
            voicePrompt = "Hangisi sabah?"
        )
        // Add more questions...
    )
}