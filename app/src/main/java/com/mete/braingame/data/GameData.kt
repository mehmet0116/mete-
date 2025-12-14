package com.mete.braingame.data

object GameData {
    val categories = listOf(
        Category(
            id = "animals",
            name = "Hayvanlar",
            iconResId = "🦁",
            color = 0xFF4CAF50,
            description = "25 hayvan ve gerçek sesleri"
        ),
        Category(
            id = "numbers",
            name = "Sayılar",
            iconResId = "🔢",
            color = 0xFF2196F3,
            description = "1'den 20'ye kadar sayılar"
        ),
        Category(
            id = "shapes",
            name = "Şekiller",
            iconResId = "⭐",
            color = 0xFFFF9800,
            description = "10 farklı şekil"
        ),
        Category(
            id = "colors",
            name = "Renkler",
            iconResId = "🎨",
            color = 0xFFE91E63,
            description = "12 farklı renk"
        ),
        Category(
            id = "fruits",
            name = "Meyveler",
            iconResId = "🍎",
            color = 0xFF9C27B0,
            description = "14 farklı meyve"
        ),
        Category(
            id = "vegetables",
            name = "Sebzeler",
            iconResId = "🥕",
            color = 0xFF009688,
            description = "12 farklı sebze"
        )
    )
    
    fun getQuestionsForCategory(categoryId: String): List<Question> {
        return when (categoryId) {
            "animals" -> animalQuestions
            "numbers" -> numberQuestions
            "shapes" -> shapeQuestions
            "colors" -> colorQuestions
            "fruits" -> fruitQuestions
            "vegetables" -> vegetableQuestions
            else -> emptyList()
        }
    }
    
    private val animalQuestions = listOf(
        Question(
            id = "animal_1",
            categoryId = "animals",
            text = "Bu hangi hayvan?",
            options = listOf("Aslan", "Kaplan", "Fil", "Zürafa"),
            correctAnswer = "Aslan"
        )
        // Diğer sorular buraya eklenebilir
    )
    
    private val numberQuestions = listOf(
        Question(
            id = "number_1",
            categoryId = "numbers",
            text = "Kaç tane elma var?",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = "3"
        )
    )
    
    private val shapeQuestions = listOf(
        Question(
            id = "shape_1",
            categoryId = "shapes",
            text = "Bu hangi şekil?",
            options = listOf("Kare", "Daire", "Üçgen", "Dikdörtgen"),
            correctAnswer = "Daire"
        )
    )
    
    private val colorQuestions = listOf(
        Question(
            id = "color_1",
            categoryId = "colors",
            text = "Bu hangi renk?",
            options = listOf("Kırmızı", "Mavi", "Yeşil", "Sarı"),
            correctAnswer = "Kırmızı"
        )
    )
    
    private val fruitQuestions = listOf(
        Question(
            id = "fruit_1",
            categoryId = "fruits",
            text = "Bu hangi meyve?",
            options = listOf("Elma", "Muz", "Portakal", "Çilek"),
            correctAnswer = "Elma"
        )
    )
    
    private val vegetableQuestions = listOf(
        Question(
            id = "vegetable_1",
            categoryId = "vegetables",
            text = "Bu hangi sebze?",
            options = listOf("Havuç", "Domates", "Salatalık", "Patates"),
            correctAnswer = "Havuç"
        )
    )
}