package com.mete.braingame.data

import androidx.compose.ui.graphics.Color

/**
 * All game categories
 */
object GameData {
    
    val categories = listOf(
        GameCategory("animals", "Hayvanlar", "Animals", "🦁", 0xFFFF6B6B),
        GameCategory("numbers", "Sayılar", "Numbers", "🔢", 0xFF4ECDC4),
        GameCategory("shapes", "Şekiller", "Shapes", "⭐", 0xFF95E1D3),
        GameCategory("colors", "Renkler", "Colors", "🎨", 0xFFF38181),
        GameCategory("letters", "Harfler", "Letters", "📝", 0xFFAA96DA),
        GameCategory("fruits", "Meyveler", "Fruits", "🍎", 0xFFFCBAD3)
    )
    
    val questions = listOf(
        // Animals - Pattern Recognition
        Question(
            id = "animal-1",
            type = QuestionType.PATTERN,
            category = "animals",
            question = "Mete, hangi hayvan sırada gelecek?",
            questionEn = "Which animal comes next?",
            items = listOf("🦁", "🐘", "🦁", "🐘", "🦁"),
            options = listOf("🐘", "🦁", "🦒", "🐯"),
            correctAnswer = 0,
            voice = "Aslan, fil, aslan, fil, aslan... Sonra ne gelir Mete?"
        ),
        Question(
            id = "animal-2",
            type = QuestionType.PATTERN,
            category = "animals",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("🐶", "🐱", "🐶", "🐱"),
            options = listOf("🐶", "🐱", "🐭", "🐰"),
            correctAnswer = 0,
            voice = "Köpek, kedi, köpek, kedi... Sırada ne var?"
        ),
        Question(
            id = "animal-3",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Cat İngilizce ne demek?",
            questionEn = "What does Cat mean in Turkish?",
            options = listOf("🐱 Kedi", "🐶 Köpek", "🐭 Fare", "🐰 Tavşan"),
            correctAnswer = 0,
            voice = "Cat İngilizce ne demek Mete?"
        ),
        Question(
            id = "animal-4",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Dog İngilizce ne demek?",
            questionEn = "What does Dog mean in Turkish?",
            options = listOf("🐱 Kedi", "🐶 Köpek", "🐭 Fare", "🐰 Tavşan"),
            correctAnswer = 1,
            voice = "Dog İngilizce ne demek?"
        ),
        
        // Numbers - Counting
        Question(
            id = "number-1",
            type = QuestionType.COUNTING,
            category = "numbers",
            question = "Kaç tane yıldız var Mete?",
            questionEn = "How many stars are there?",
            items = listOf("⭐", "⭐", "⭐", "⭐", "⭐"),
            options = listOf("3", "4", "5", "6"),
            correctAnswer = 2,
            voice = "Kaç tane yıldız var? Sayalım Mete!"
        ),
        Question(
            id = "number-2",
            type = QuestionType.PATTERN,
            category = "numbers",
            question = "Hangi sayı gelecek?",
            questionEn = "Which number comes next?",
            items = listOf("1", "2", "3", "4"),
            options = listOf("5", "6", "3", "1"),
            correctAnswer = 0,
            voice = "Bir, iki, üç, dört... Sonra hangi sayı gelir Mete?"
        ),
        Question(
            id = "number-3",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Five İngilizce kaç demek?",
            questionEn = "What number is Five?",
            options = listOf("3", "4", "5", "6"),
            correctAnswer = 2,
            voice = "Five İngilizce kaç demek?"
        ),
        
        // Shapes
        Question(
            id = "shape-1",
            type = QuestionType.PATTERN,
            category = "shapes",
            question = "Hangi şekil sırada gelecek?",
            questionEn = "Which shape comes next?",
            items = listOf("⭐", "⬛", "⭐", "⬛", "⭐"),
            options = listOf("⬛", "⭐", "🔵", "🔺"),
            correctAnswer = 0,
            voice = "Yıldız, kare, yıldız, kare, yıldız... Ne gelir Mete?"
        ),
        Question(
            id = "shape-2",
            type = QuestionType.QUIZ,
            category = "shapes",
            question = "Circle İngilizce ne demek?",
            questionEn = "What shape is Circle?",
            options = listOf("⭐ Yıldız", "⬛ Kare", "🔵 Daire", "🔺 Üçgen"),
            correctAnswer = 2,
            voice = "Circle İngilizce ne demek?"
        ),
        Question(
            id = "shape-3",
            type = QuestionType.QUIZ,
            category = "shapes",
            question = "Star İngilizce ne demek?",
            questionEn = "What shape is Star?",
            options = listOf("⭐ Yıldız", "⬛ Kare", "🔵 Daire", "🔺 Üçgen"),
            correctAnswer = 0,
            voice = "Star İngilizce ne demek Mete?"
        ),
        
        // Colors
        Question(
            id = "color-1",
            type = QuestionType.PATTERN,
            category = "colors",
            question = "Hangi renk gelecek?",
            questionEn = "Which color comes next?",
            items = listOf("🔴", "🔵", "🔴", "🔵", "🔴"),
            options = listOf("🔵", "🔴", "🟢", "🟡"),
            correctAnswer = 0,
            voice = "Kırmızı, mavi, kırmızı, mavi, kırmızı... Ne gelir?"
        ),
        Question(
            id = "color-2",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Red İngilizce ne demek?",
            questionEn = "What is Red in Turkish?",
            options = listOf("🔴 Kırmızı", "🔵 Mavi", "🟢 Yeşil", "🟡 Sarı"),
            correctAnswer = 0,
            voice = "Red İngilizce ne renk demek?"
        ),
        Question(
            id = "color-3",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Blue İngilizce ne demek?",
            questionEn = "What is Blue in Turkish?",
            options = listOf("🔴 Kırmızı", "🔵 Mavi", "🟢 Yeşil", "🟡 Sarı"),
            correctAnswer = 1,
            voice = "Blue İngilizce ne renk demek Mete?"
        ),
        
        // Letters
        Question(
            id = "letter-1",
            type = QuestionType.PATTERN,
            category = "letters",
            question = "Hangi harf gelecek?",
            questionEn = "Which letter comes next?",
            items = listOf("A", "B", "C", "D"),
            options = listOf("E", "F", "G", "A"),
            correctAnswer = 0,
            voice = "A, B, C, D... Hangi harf gelir Mete?"
        ),
        Question(
            id = "letter-2",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "Apple İngilizcede hangi harfle başlar?",
            questionEn = "What letter does Apple start with?",
            options = listOf("A", "B", "C", "D"),
            correctAnswer = 0,
            voice = "Apple hangi harfle başlar?"
        ),
        Question(
            id = "letter-3",
            type = QuestionType.PATTERN,
            category = "letters",
            question = "Alfabede X'ten sonra ne gelir?",
            questionEn = "What comes after X in the alphabet?",
            items = listOf("W", "X"),
            options = listOf("Y", "Z", "V", "T"),
            correctAnswer = 0,
            voice = "W, X... Sonra hangi harf gelir Mete?"
        ),
        
        // Fruits
        Question(
            id = "fruit-1",
            type = QuestionType.PATTERN,
            category = "fruits",
            question = "Hangi meyve gelecek?",
            questionEn = "Which fruit comes next?",
            items = listOf("🍎", "🍌", "🍎", "🍌", "🍎"),
            options = listOf("🍌", "🍎", "🍊", "🍇"),
            correctAnswer = 0,
            voice = "Elma, muz, elma, muz, elma... Ne gelir?"
        ),
        Question(
            id = "fruit-2",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Apple İngilizce ne demek?",
            questionEn = "What is Apple in Turkish?",
            options = listOf("🍎 Elma", "🍌 Muz", "🍊 Portakal", "🍇 Üzüm"),
            correctAnswer = 0,
            voice = "Apple İngilizce ne demek Mete?"
        ),
        Question(
            id = "fruit-3",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Banana İngilizce ne demek?",
            questionEn = "What is Banana in Turkish?",
            options = listOf("🍎 Elma", "🍌 Muz", "🍊 Portakal", "🍇 Üzüm"),
            correctAnswer = 1,
            voice = "Banana İngilizce ne demek?"
        )
    )
    
    fun getQuestionsByCategory(categoryId: String): List<Question> {
        return questions.filter { it.category == categoryId }
    }
}
