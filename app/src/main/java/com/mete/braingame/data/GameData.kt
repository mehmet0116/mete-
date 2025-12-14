package com.mete.braingame.data

object GameData {
    val categories = listOf(
        Category(
            id = 1,
            name = "Hayvanlar",
            icon = "🦁",
            description = "25 hayvan - gerçek seslerle!",
            color = 0xFF4CAF50
        ),
        Category(
            id = 2,
            name = "Sayılar",
            icon = "🔢",
            description = "16 sayı - 1'den 20'ye",
            color = 0xFF2196F3
        ),
        Category(
            id = 3,
            name = "Şekiller",
            icon = "⭐",
            description = "10 şekil",
            color = 0xFFFF9800
        ),
        Category(
            id = 4,
            name = "Renkler",
            icon = "🎨",
            description = "12 renk",
            color = 0xFFE91E63
        ),
        Category(
            id = 5,
            name = "Harfler",
            icon = "📝",
            description = "16 harf",
            color = 0xFF9C27B0
        ),
        Category(
            id = 6,
            name = "Meyveler",
            icon = "🍎",
            description = "14 meyve",
            color = 0xFF00BCD4
        ),
        Category(
            id = 7,
            name = "Sebzeler",
            icon = "🥕",
            description = "12 sebze",
            color = 0xFF8BC34A
        ),
        Category(
            id = 8,
            name = "Vücut Bölümleri",
            icon = "👁️",
            description = "12 organ",
            color = 0xFFFF5722
        ),
        Category(
            id = 9,
            name = "Hareketler",
            icon = "🏃",
            description = "12 hareket",
            color = 0xFF795548
        ),
        Category(
            id = 10,
            name = "Zaman",
            icon = "📅",
            description = "11 kavram",
            color = 0xFF607D8B
        )
    )

    fun getQuestionsForCategory(categoryId: Int): List<Question> {
        return when (categoryId) {
            1 -> getAnimalQuestions()
            2 -> getNumberQuestions()
            3 -> getShapeQuestions()
            4 -> getColorQuestions()
            5 -> getLetterQuestions()
            6 -> getFruitQuestions()
            7 -> getVegetableQuestions()
            8 -> getBodyPartQuestions()
            9 -> getActionQuestions()
            10 -> getTimeQuestions()
            else -> getAnimalQuestions()
        }
    }

    private fun getAnimalQuestions(): List<Question> {
        return listOf(
            Question(
                id = 1,
                categoryId = 1,
                text = "Bu hangi hayvan?",
                options = listOf("Aslan", "Kaplan", "Fil", "Zürafa"),
                correctAnswer = 0,
                audioRes = "aslan_sesi"
            ),
            Question(
                id = 2,
                categoryId = 1,
                text = "Bu hayvanın sesini tanıyor musun?",
                options = listOf("Köpek", "Kedi", "Kuş", "İnek"),
                correctAnswer = 1,
                audioRes = "kedi_sesi"
            )
        )
    }

    private fun getNumberQuestions(): List<Question> {
        return listOf(
            Question(
                id = 101,
                categoryId = 2,
                text = "Kaç tane elma var?",
                options = listOf("1", "2", "3", "4"),
                correctAnswer = 2
            ),
            Question(
                id = 102,
                categoryId = 2,
                text = "Hangi sayı eksik? 1, 2, _, 4",
                options = listOf("1", "2", "3", "4"),
                correctAnswer = 2
            )
        )
    }

    private fun getShapeQuestions(): List<Question> {
        return listOf(
            Question(
                id = 201,
                categoryId = 3,
                text = "Bu hangi şekil?",
                options = listOf("Kare", "Daire", "Üçgen", "Dikdörtgen"),
                correctAnswer = 1
            )
        )
    }

    private fun getColorQuestions(): List<Question> {
        return listOf(
            Question(
                id = 301,
                categoryId = 4,
                text = "Bu hangi renk?",
                options = listOf("Kırmızı", "Mavi", "Yeşil", "Sarı"),
                correctAnswer = 0
            )
        )
    }

    private fun getLetterQuestions(): List<Question> {
        return listOf(
            Question(
                id = 401,
                categoryId = 5,
                text = "Hangi harf?",
                options = listOf("A", "B", "C", "D"),
                correctAnswer = 0
            )
        )
    }

    private fun getFruitQuestions(): List<Question> {
        return listOf(
            Question(
                id = 501,
                categoryId = 6,
                text = "Bu hangi meyve?",
                options = listOf("Elma", "Armut", "Muz", "Çilek"),
                correctAnswer = 0
            )
        )
    }

    private fun getVegetableQuestions(): List<Question> {
        return listOf(
            Question(
                id = 601,
                categoryId = 7,
                text = "Bu hangi sebze?",
                options = listOf("Havuç", "Domates", "Salatalık", "Patates"),
                correctAnswer = 0
            )
        )
    }

    private fun getBodyPartQuestions(): List<Question> {
        return listOf(
            Question(
                id = 701,
                categoryId = 8,
                text = "Bu hangi vücut bölümü?",
                options = listOf("Göz", "Kulak", "Burun", "Ağız"),
                correctAnswer = 0
            )
        )
    }

    private fun getActionQuestions(): List<Question> {
        return listOf(
            Question(
                id = 801,
                categoryId = 9,
                text = "Bu hareketi yap",
                options = listOf("Zıpla", "Koş", "Yürü", "Otur"),
                correctAnswer = 0
            )
        )
    }

    private fun getTimeQuestions(): List<Question> {
        return listOf(
            Question(
                id = 901,
                categoryId = 10,
                text = "Hangi zaman?",
                options = listOf("Sabah", "Öğle", "Akşam", "Gece"),
                correctAnswer = 0
            )
        )
    }
}