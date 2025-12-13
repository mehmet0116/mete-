package com.mete.braingame.data

import androidx.compose.ui.graphics.Color

/**
 * All game categories - Expanded for comprehensive 5-year-old education
 */
object GameData {
    
    val categories = listOf(
        GameCategory("animals", "Hayvanlar", "Animals", "🦁", 0xFFFF6B6B),
        GameCategory("numbers", "Sayılar", "Numbers", "🔢", 0xFF4ECDC4),
        GameCategory("shapes", "Şekiller", "Shapes", "⭐", 0xFF95E1D3),
        GameCategory("colors", "Renkler", "Colors", "🎨", 0xFFF38181),
        GameCategory("letters", "Harfler", "Letters", "📝", 0xFFAA96DA),
        GameCategory("fruits", "Meyveler", "Fruits", "🍎", 0xFFFCBAD3),
        GameCategory("vegetables", "Sebzeler", "Vegetables", "🥕", 0xFF90EE90),
        GameCategory("bodyparts", "Vücut", "Body Parts", "👁️", 0xFFFFB6C1),
        GameCategory("actions", "Hareketler", "Actions", "🏃", 0xFFDDA0DD),
        GameCategory("time", "Zaman", "Time & Days", "⏰", 0xFFFFDAB9)
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
        Question(
            id = "animal-5",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Elephant İngilizce ne demek?",
            questionEn = "What does Elephant mean?",
            options = listOf("🦁 Aslan", "🐘 Fil", "🦒 Zürafa", "🐯 Kaplan"),
            correctAnswer = 1,
            voice = "Elephant İngilizce ne demek Mete?"
        ),
        Question(
            id = "animal-6",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Lion İngilizce ne demek?",
            questionEn = "What does Lion mean?",
            options = listOf("🦁 Aslan", "🐘 Fil", "🦒 Zürafa", "🐯 Kaplan"),
            correctAnswer = 0,
            voice = "Lion İngilizce ne demek?"
        ),
        Question(
            id = "animal-7",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Rabbit İngilizce ne demek?",
            questionEn = "What does Rabbit mean?",
            options = listOf("🐱 Kedi", "🐶 Köpek", "🐭 Fare", "🐰 Tavşan"),
            correctAnswer = 3,
            voice = "Rabbit İngilizce ne demek Mete?"
        ),
        Question(
            id = "animal-8",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Bird İngilizce ne demek?",
            questionEn = "What does Bird mean?",
            options = listOf("🐦 Kuş", "🦆 Ördek", "🦉 Baykuş", "🦅 Kartal"),
            correctAnswer = 0,
            voice = "Bird İngilizce ne demek?"
        ),
        Question(
            id = "animal-9",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Fish İngilizce ne demek?",
            questionEn = "What does Fish mean?",
            options = listOf("🐟 Balık", "🐠 Tropik Balık", "🦈 Köpekbalığı", "🐙 Ahtapot"),
            correctAnswer = 0,
            voice = "Fish İngilizce ne demek Mete?"
        ),
        Question(
            id = "animal-10",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Butterfly İngilizce ne demek?",
            questionEn = "What does Butterfly mean?",
            options = listOf("🦋 Kelebek", "🐝 Arı", "🐞 Uğur Böceği", "🦗 Çekirge"),
            correctAnswer = 0,
            voice = "Butterfly İngilizce ne demek?"
        ),
        Question(
            id = "animal-11",
            type = QuestionType.PATTERN,
            category = "animals",
            question = "Hangi hayvan gelecek?",
            questionEn = "Which animal comes next?",
            items = listOf("🐶", "🐱", "🐭", "🐶", "🐱"),
            options = listOf("🐭", "🐶", "🐱", "🐰"),
            correctAnswer = 0,
            voice = "Köpek, kedi, fare, köpek, kedi... Ne gelir?"
        ),
        Question(
            id = "animal-12",
            type = QuestionType.PATTERN,
            category = "animals",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("🦁", "🦁", "🐘", "🦁", "🦁"),
            options = listOf("🐘", "🦁", "🦒", "🐯"),
            correctAnswer = 0,
            voice = "Aslan, aslan, fil, aslan, aslan... Ne gelir Mete?"
        ),
        Question(
            id = "animal-13",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Monkey İngilizce ne demek?",
            questionEn = "What does Monkey mean?",
            options = listOf("🐵 Maymun", "🦍 Goril", "🐻 Ayı", "🦊 Tilki"),
            correctAnswer = 0,
            voice = "Monkey İngilizce ne demek?"
        ),
        Question(
            id = "animal-14",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Bear İngilizce ne demek?",
            questionEn = "What does Bear mean?",
            options = listOf("🐵 Maymun", "🦍 Goril", "🐻 Ayı", "🦊 Tilki"),
            correctAnswer = 2,
            voice = "Bear İngilizce ne demek Mete?"
        ),
        Question(
            id = "animal-15",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Horse İngilizce ne demek?",
            questionEn = "What does Horse mean?",
            options = listOf("🐴 At", "🦓 Zebra", "🦌 Geyik", "🐮 İnek"),
            correctAnswer = 0,
            voice = "Horse İngilizce ne demek?"
        ),
        Question(
            id = "animal-16",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Cow İngilizce ne demek?",
            questionEn = "What does Cow mean?",
            options = listOf("🐴 At", "🦓 Zebra", "🦌 Geyik", "🐮 İnek"),
            correctAnswer = 3,
            voice = "Cow İngilizce ne demek Mete?"
        ),
        Question(
            id = "animal-17",
            type = QuestionType.PATTERN,
            category = "animals",
            question = "Hangi hayvan sırada gelecek?",
            questionEn = "Which animal comes next?",
            items = listOf("🐦", "🐦", "🦆", "🐦", "🐦"),
            options = listOf("🦆", "🐦", "🦉", "🦅"),
            correctAnswer = 0,
            voice = "Kuş, kuş, ördek, kuş, kuş... Ne gelir?"
        ),
        Question(
            id = "animal-18",
            type = QuestionType.COUNTING,
            category = "animals",
            question = "Kaç tane kedi var?",
            questionEn = "How many cats are there?",
            items = listOf("🐱", "🐱", "🐱"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 1,
            voice = "Kaç tane kedi var? Sayalım Mete!"
        ),
        Question(
            id = "animal-19",
            type = QuestionType.COUNTING,
            category = "animals",
            question = "Kaç tane köpek var?",
            questionEn = "How many dogs are there?",
            items = listOf("🐶", "🐶", "🐶", "🐶"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 2,
            voice = "Kaç tane köpek var Mete?"
        ),
        Question(
            id = "animal-20",
            type = QuestionType.QUIZ,
            category = "animals",
            question = "Penguin İngilizce ne demek?",
            questionEn = "What does Penguin mean?",
            options = listOf("🐧 Penguen", "🦆 Ördek", "🦢 Kuğu", "🦩 Flamingo"),
            correctAnswer = 0,
            voice = "Penguin İngilizce ne demek?"
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
        Question(
            id = "number-4",
            type = QuestionType.COUNTING,
            category = "numbers",
            question = "Kaç tane top var?",
            questionEn = "How many balls are there?",
            items = listOf("⚽", "⚽", "⚽"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 1,
            voice = "Kaç tane top var Mete? Sayalım!"
        ),
        Question(
            id = "number-5",
            type = QuestionType.COUNTING,
            category = "numbers",
            question = "Kaç tane kalp var?",
            questionEn = "How many hearts are there?",
            items = listOf("❤️", "❤️", "❤️", "❤️", "❤️", "❤️"),
            options = listOf("4", "5", "6", "7"),
            correctAnswer = 2,
            voice = "Kaç tane kalp var? Beraber sayalım!"
        ),
        Question(
            id = "number-6",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "One İngilizce kaç demek?",
            questionEn = "What number is One?",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = 0,
            voice = "One İngilizce kaç demek Mete?"
        ),
        Question(
            id = "number-7",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Two İngilizce kaç demek?",
            questionEn = "What number is Two?",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = 1,
            voice = "Two İngilizce kaç demek?"
        ),
        Question(
            id = "number-8",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Three İngilizce kaç demek?",
            questionEn = "What number is Three?",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = 2,
            voice = "Three İngilizce kaç demek Mete?"
        ),
        Question(
            id = "number-9",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Four İngilizce kaç demek?",
            questionEn = "What number is Four?",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 2,
            voice = "Four İngilizce kaç demek?"
        ),
        Question(
            id = "number-10",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Six İngilizce kaç demek?",
            questionEn = "What number is Six?",
            options = listOf("4", "5", "6", "7"),
            correctAnswer = 2,
            voice = "Six İngilizce kaç demek Mete?"
        ),
        Question(
            id = "number-11",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Seven İngilizce kaç demek?",
            questionEn = "What number is Seven?",
            options = listOf("5", "6", "7", "8"),
            correctAnswer = 2,
            voice = "Seven İngilizce kaç demek?"
        ),
        Question(
            id = "number-12",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Eight İngilizce kaç demek?",
            questionEn = "What number is Eight?",
            options = listOf("6", "7", "8", "9"),
            correctAnswer = 2,
            voice = "Eight İngilizce kaç demek Mete?"
        ),
        Question(
            id = "number-13",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Nine İngilizce kaç demek?",
            questionEn = "What number is Nine?",
            options = listOf("7", "8", "9", "10"),
            correctAnswer = 2,
            voice = "Nine İngilizce kaç demek?"
        ),
        Question(
            id = "number-14",
            type = QuestionType.QUIZ,
            category = "numbers",
            question = "Ten İngilizce kaç demek?",
            questionEn = "What number is Ten?",
            options = listOf("8", "9", "10", "11"),
            correctAnswer = 2,
            voice = "Ten İngilizce kaç demek Mete?"
        ),
        Question(
            id = "number-15",
            type = QuestionType.PATTERN,
            category = "numbers",
            question = "Hangi sayı gelecek?",
            questionEn = "Which number comes next?",
            items = listOf("2", "4", "6", "8"),
            options = listOf("9", "10", "11", "12"),
            correctAnswer = 1,
            voice = "İki, dört, altı, sekiz... Sonra hangi sayı gelir?"
        ),
        Question(
            id = "number-16",
            type = QuestionType.PATTERN,
            category = "numbers",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("1", "1", "2", "1", "1"),
            options = listOf("1", "2", "3", "4"),
            correctAnswer = 1,
            voice = "Bir, bir, iki, bir, bir... Ne gelir Mete?"
        ),
        Question(
            id = "number-17",
            type = QuestionType.COUNTING,
            category = "numbers",
            question = "Kaç tane yıldız var?",
            questionEn = "How many stars are there?",
            items = listOf("⭐", "⭐", "⭐", "⭐", "⭐", "⭐", "⭐"),
            options = listOf("5", "6", "7", "8"),
            correctAnswer = 2,
            voice = "Kaç tane yıldız var? Sayalım Mete!"
        ),
        Question(
            id = "number-18",
            type = QuestionType.COUNTING,
            category = "numbers",
            question = "Kaç tane gülen yüz var?",
            questionEn = "How many smiley faces are there?",
            items = listOf("😊", "😊"),
            options = listOf("1", "2", "3", "4"),
            correctAnswer = 1,
            voice = "Kaç tane gülen yüz var Mete?"
        ),
        Question(
            id = "number-19",
            type = QuestionType.PATTERN,
            category = "numbers",
            question = "Hangi sayı gelecek?",
            questionEn = "Which number comes next?",
            items = listOf("5", "4", "3", "2"),
            options = listOf("1", "2", "3", "4"),
            correctAnswer = 0,
            voice = "Beş, dört, üç, iki... Ne gelir?"
        ),
        Question(
            id = "number-20",
            type = QuestionType.COUNTING,
            category = "numbers",
            question = "Kaç tane çiçek var?",
            questionEn = "How many flowers are there?",
            items = listOf("🌸", "🌸", "🌸", "🌸"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 2,
            voice = "Kaç tane çiçek var? Sayalım beraber!"
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
        Question(
            id = "shape-4",
            type = QuestionType.QUIZ,
            category = "shapes",
            question = "Square İngilizce ne demek?",
            questionEn = "What shape is Square?",
            options = listOf("⭐ Yıldız", "⬛ Kare", "🔵 Daire", "🔺 Üçgen"),
            correctAnswer = 1,
            voice = "Square İngilizce ne demek?"
        ),
        Question(
            id = "shape-5",
            type = QuestionType.QUIZ,
            category = "shapes",
            question = "Triangle İngilizce ne demek?",
            questionEn = "What shape is Triangle?",
            options = listOf("⭐ Yıldız", "⬛ Kare", "🔵 Daire", "🔺 Üçgen"),
            correctAnswer = 3,
            voice = "Triangle İngilizce ne demek Mete?"
        ),
        Question(
            id = "shape-6",
            type = QuestionType.PATTERN,
            category = "shapes",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("🔵", "🔺", "🔵", "🔺"),
            options = listOf("🔵", "🔺", "⬛", "⭐"),
            correctAnswer = 0,
            voice = "Daire, üçgen, daire, üçgen... Ne gelir?"
        ),
        Question(
            id = "shape-7",
            type = QuestionType.QUIZ,
            category = "shapes",
            question = "Heart İngilizce ne demek?",
            questionEn = "What shape is Heart?",
            options = listOf("❤️ Kalp", "⭐ Yıldız", "🔵 Daire", "⬛ Kare"),
            correctAnswer = 0,
            voice = "Heart İngilizce ne demek?"
        ),
        Question(
            id = "shape-8",
            type = QuestionType.COUNTING,
            category = "shapes",
            question = "Kaç tane üçgen var?",
            questionEn = "How many triangles are there?",
            items = listOf("🔺", "🔺", "🔺", "🔺"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 2,
            voice = "Kaç tane üçgen var? Sayalım!"
        ),
        Question(
            id = "shape-9",
            type = QuestionType.COUNTING,
            category = "shapes",
            question = "Kaç tane yıldız var?",
            questionEn = "How many stars are there?",
            items = listOf("⭐", "⭐", "⭐"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 1,
            voice = "Kaç tane yıldız var Mete?"
        ),
        Question(
            id = "shape-10",
            type = QuestionType.PATTERN,
            category = "shapes",
            question = "Hangi şekil gelecek?",
            questionEn = "Which shape comes next?",
            items = listOf("⭐", "🔵", "⬛", "⭐", "🔵"),
            options = listOf("⬛", "⭐", "🔵", "🔺"),
            correctAnswer = 0,
            voice = "Yıldız, daire, kare, yıldız, daire... Ne gelir?"
        ),
        Question(
            id = "shape-11",
            type = QuestionType.QUIZ,
            category = "shapes",
            question = "Oval İngilizce ne demek?",
            questionEn = "What shape is Oval?",
            options = listOf("⭕ Oval", "🔵 Daire", "⬛ Kare", "🔺 Üçgen"),
            correctAnswer = 0,
            voice = "Oval İngilizce ne demek Mete?"
        ),
        Question(
            id = "shape-12",
            type = QuestionType.PATTERN,
            category = "shapes",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("⬛", "⬛", "🔵", "⬛", "⬛"),
            options = listOf("🔵", "⬛", "⭐", "🔺"),
            correctAnswer = 0,
            voice = "Kare, kare, daire, kare, kare... Ne gelir?"
        ),
        Question(
            id = "shape-13",
            type = QuestionType.COUNTING,
            category = "shapes",
            question = "Kaç tane kalp var?",
            questionEn = "How many hearts are there?",
            items = listOf("❤️", "❤️", "❤️", "❤️", "❤️"),
            options = listOf("3", "4", "5", "6"),
            correctAnswer = 2,
            voice = "Kaç tane kalp var? Sayalım beraber!"
        ),
        Question(
            id = "shape-14",
            type = QuestionType.QUIZ,
            category = "shapes",
            question = "Diamond İngilizce ne demek?",
            questionEn = "What shape is Diamond?",
            options = listOf("💎 Elmas", "⭐ Yıldız", "❤️ Kalp", "🔵 Daire"),
            correctAnswer = 0,
            voice = "Diamond İngilizce ne demek?"
        ),
        Question(
            id = "shape-15",
            type = QuestionType.PATTERN,
            category = "shapes",
            question = "Hangi şekil sırada gelecek?",
            questionEn = "Which shape comes next?",
            items = listOf("❤️", "⭐", "❤️", "⭐"),
            options = listOf("❤️", "⭐", "🔵", "⬛"),
            correctAnswer = 0,
            voice = "Kalp, yıldız, kalp, yıldız... Ne gelir Mete?"
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
        Question(
            id = "color-4",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Green İngilizce ne demek?",
            questionEn = "What is Green in Turkish?",
            options = listOf("🔴 Kırmızı", "🔵 Mavi", "🟢 Yeşil", "🟡 Sarı"),
            correctAnswer = 2,
            voice = "Green İngilizce ne renk demek?"
        ),
        Question(
            id = "color-5",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Yellow İngilizce ne demek?",
            questionEn = "What is Yellow in Turkish?",
            options = listOf("🔴 Kırmızı", "🔵 Mavi", "🟢 Yeşil", "🟡 Sarı"),
            correctAnswer = 3,
            voice = "Yellow İngilizce ne renk demek Mete?"
        ),
        Question(
            id = "color-6",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Orange İngilizce ne demek?",
            questionEn = "What is Orange in Turkish?",
            options = listOf("🟠 Turuncu", "🔴 Kırmızı", "🟡 Sarı", "🟤 Kahverengi"),
            correctAnswer = 0,
            voice = "Orange İngilizce ne renk demek?"
        ),
        Question(
            id = "color-7",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Purple İngilizce ne demek?",
            questionEn = "What is Purple in Turkish?",
            options = listOf("🟣 Mor", "🔵 Mavi", "🔴 Kırmızı", "🟢 Yeşil"),
            correctAnswer = 0,
            voice = "Purple İngilizce ne renk demek Mete?"
        ),
        Question(
            id = "color-8",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Pink İngilizce ne demek?",
            questionEn = "What is Pink in Turkish?",
            options = listOf("🩷 Pembe", "🔴 Kırmızı", "🟣 Mor", "🟠 Turuncu"),
            correctAnswer = 0,
            voice = "Pink İngilizce ne renk demek?"
        ),
        Question(
            id = "color-9",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Brown İngilizce ne demek?",
            questionEn = "What is Brown in Turkish?",
            options = listOf("🟤 Kahverengi", "⚫ Siyah", "⚪ Beyaz", "🩶 Gri"),
            correctAnswer = 0,
            voice = "Brown İngilizce ne renk demek Mete?"
        ),
        Question(
            id = "color-10",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "Black İngilizce ne demek?",
            questionEn = "What is Black in Turkish?",
            options = listOf("⚫ Siyah", "⚪ Beyaz", "🩶 Gri", "🟤 Kahverengi"),
            correctAnswer = 0,
            voice = "Black İngilizce ne renk demek?"
        ),
        Question(
            id = "color-11",
            type = QuestionType.QUIZ,
            category = "colors",
            question = "White İngilizce ne demek?",
            questionEn = "What is White in Turkish?",
            options = listOf("⚫ Siyah", "⚪ Beyaz", "🩶 Gri", "🟤 Kahverengi"),
            correctAnswer = 1,
            voice = "White İngilizce ne renk demek Mete?"
        ),
        Question(
            id = "color-12",
            type = QuestionType.PATTERN,
            category = "colors",
            question = "Hangi renk gelecek?",
            questionEn = "Which color comes next?",
            items = listOf("🔴", "🟢", "🔴", "🟢", "🔴"),
            options = listOf("🟢", "🔴", "🔵", "🟡"),
            correctAnswer = 0,
            voice = "Kırmızı, yeşil, kırmızı, yeşil, kırmızı... Ne gelir?"
        ),
        Question(
            id = "color-13",
            type = QuestionType.PATTERN,
            category = "colors",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("🟡", "🟣", "🟡", "🟣"),
            options = listOf("🟡", "🟣", "🔵", "🔴"),
            correctAnswer = 0,
            voice = "Sarı, mor, sarı, mor... Ne gelir Mete?"
        ),
        Question(
            id = "color-14",
            type = QuestionType.PATTERN,
            category = "colors",
            question = "Hangi renk sırada gelecek?",
            questionEn = "Which color comes next?",
            items = listOf("🔴", "🔵", "🟢", "🔴", "🔵"),
            options = listOf("🟢", "🔴", "🔵", "🟡"),
            correctAnswer = 0,
            voice = "Kırmızı, mavi, yeşil, kırmızı, mavi... Ne gelir?"
        ),
        Question(
            id = "color-15",
            type = QuestionType.PATTERN,
            category = "colors",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("🟠", "🟠", "🩷", "🟠", "🟠"),
            options = listOf("🩷", "🟠", "🟡", "🔴"),
            correctAnswer = 0,
            voice = "Turuncu, turuncu, pembe, turuncu, turuncu... Ne gelir?"
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
        Question(
            id = "letter-4",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "B harfi İngilizcede nasıl okunur?",
            questionEn = "How do you say B in English?",
            options = listOf("Bee 🐝", "See 👀", "Dee 🎲", "Eee 😃"),
            correctAnswer = 0,
            voice = "B harfi İngilizcede nasıl okunur Mete?"
        ),
        Question(
            id = "letter-5",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "Cat hangi harfle başlar?",
            questionEn = "What letter does Cat start with?",
            options = listOf("A", "B", "C", "D"),
            correctAnswer = 2,
            voice = "Cat hangi harfle başlar?"
        ),
        Question(
            id = "letter-6",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "Dog hangi harfle başlar?",
            questionEn = "What letter does Dog start with?",
            options = listOf("A", "B", "C", "D"),
            correctAnswer = 3,
            voice = "Dog hangi harfle başlar Mete?"
        ),
        Question(
            id = "letter-7",
            type = QuestionType.PATTERN,
            category = "letters",
            question = "Hangi harf gelecek?",
            questionEn = "Which letter comes next?",
            items = listOf("F", "G", "H", "I"),
            options = listOf("J", "K", "L", "M"),
            correctAnswer = 0,
            voice = "F, G, H, I... Hangi harf gelir?"
        ),
        Question(
            id = "letter-8",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "Elephant hangi harfle başlar?",
            questionEn = "What letter does Elephant start with?",
            options = listOf("A", "B", "C", "E"),
            correctAnswer = 3,
            voice = "Elephant hangi harfle başlar?"
        ),
        Question(
            id = "letter-9",
            type = QuestionType.PATTERN,
            category = "letters",
            question = "Alfabede M'den sonra ne gelir?",
            questionEn = "What comes after M in the alphabet?",
            items = listOf("L", "M"),
            options = listOf("N", "O", "P", "K"),
            correctAnswer = 0,
            voice = "L, M... Sonra hangi harf gelir Mete?"
        ),
        Question(
            id = "letter-10",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "Fish hangi harfle başlar?",
            questionEn = "What letter does Fish start with?",
            options = listOf("E", "F", "G", "H"),
            correctAnswer = 1,
            voice = "Fish hangi harfle başlar?"
        ),
        Question(
            id = "letter-11",
            type = QuestionType.PATTERN,
            category = "letters",
            question = "Hangi harf gelecek?",
            questionEn = "Which letter comes next?",
            items = listOf("P", "Q", "R", "S"),
            options = listOf("T", "U", "V", "W"),
            correctAnswer = 0,
            voice = "P, Q, R, S... Hangi harf gelir Mete?"
        ),
        Question(
            id = "letter-12",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "Ice cream hangi harfle başlar?",
            questionEn = "What letter does Ice cream start with?",
            options = listOf("H", "I", "J", "K"),
            correctAnswer = 1,
            voice = "Ice cream hangi harfle başlar?"
        ),
        Question(
            id = "letter-13",
            type = QuestionType.PATTERN,
            category = "letters",
            question = "Alfabede son harf nedir?",
            questionEn = "What is the last letter of the alphabet?",
            items = listOf("X", "Y"),
            options = listOf("Z", "W", "V", "U"),
            correctAnswer = 0,
            voice = "X, Y... Son harf nedir Mete?"
        ),
        Question(
            id = "letter-14",
            type = QuestionType.QUIZ,
            category = "letters",
            question = "Monkey hangi harfle başlar?",
            questionEn = "What letter does Monkey start with?",
            options = listOf("L", "M", "N", "O"),
            correctAnswer = 1,
            voice = "Monkey hangi harfle başlar?"
        ),
        Question(
            id = "letter-15",
            type = QuestionType.PATTERN,
            category = "letters",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("A", "B", "A", "B"),
            options = listOf("A", "B", "C", "D"),
            correctAnswer = 0,
            voice = "A, B, A, B... Ne gelir Mete?"
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
        ),
        Question(
            id = "fruit-4",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Orange İngilizce ne demek?",
            questionEn = "What is Orange in Turkish?",
            options = listOf("🍎 Elma", "🍌 Muz", "🍊 Portakal", "🍇 Üzüm"),
            correctAnswer = 2,
            voice = "Orange İngilizce ne demek Mete?"
        ),
        Question(
            id = "fruit-5",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Grape İngilizce ne demek?",
            questionEn = "What is Grape in Turkish?",
            options = listOf("🍎 Elma", "🍌 Muz", "🍊 Portakal", "🍇 Üzüm"),
            correctAnswer = 3,
            voice = "Grape İngilizce ne demek?"
        ),
        Question(
            id = "fruit-6",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Strawberry İngilizce ne demek?",
            questionEn = "What is Strawberry in Turkish?",
            options = listOf("🍓 Çilek", "🍒 Kiraz", "🍑 Şeftali", "🍉 Karpuz"),
            correctAnswer = 0,
            voice = "Strawberry İngilizce ne demek Mete?"
        ),
        Question(
            id = "fruit-7",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Watermelon İngilizce ne demek?",
            questionEn = "What is Watermelon in Turkish?",
            options = listOf("🍓 Çilek", "🍒 Kiraz", "🍑 Şeftali", "🍉 Karpuz"),
            correctAnswer = 3,
            voice = "Watermelon İngilizce ne demek?"
        ),
        Question(
            id = "fruit-8",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Cherry İngilizce ne demek?",
            questionEn = "What is Cherry in Turkish?",
            options = listOf("🍓 Çilek", "🍒 Kiraz", "🍑 Şeftali", "🍉 Karpuz"),
            correctAnswer = 1,
            voice = "Cherry İngilizce ne demek Mete?"
        ),
        Question(
            id = "fruit-9",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Peach İngilizce ne demek?",
            questionEn = "What is Peach in Turkish?",
            options = listOf("🍓 Çilek", "🍒 Kiraz", "🍑 Şeftali", "🍉 Karpuz"),
            correctAnswer = 2,
            voice = "Peach İngilizce ne demek?"
        ),
        Question(
            id = "fruit-10",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Pear İngilizce ne demek?",
            questionEn = "What is Pear in Turkish?",
            options = listOf("🍐 Armut", "🍎 Elma", "🍊 Portakal", "🍋 Limon"),
            correctAnswer = 0,
            voice = "Pear İngilizce ne demek Mete?"
        ),
        Question(
            id = "fruit-11",
            type = QuestionType.QUIZ,
            category = "fruits",
            question = "Lemon İngilizce ne demek?",
            questionEn = "What is Lemon in Turkish?",
            options = listOf("🍐 Armut", "🍎 Elma", "🍊 Portakal", "🍋 Limon"),
            correctAnswer = 3,
            voice = "Lemon İngilizce ne demek?"
        ),
        Question(
            id = "fruit-12",
            type = QuestionType.PATTERN,
            category = "fruits",
            question = "Hangi meyve gelecek?",
            questionEn = "Which fruit comes next?",
            items = listOf("🍎", "🍊", "🍎", "🍊", "🍎"),
            options = listOf("🍊", "🍎", "🍌", "🍇"),
            correctAnswer = 0,
            voice = "Elma, portakal, elma, portakal, elma... Ne gelir?"
        ),
        Question(
            id = "fruit-13",
            type = QuestionType.COUNTING,
            category = "fruits",
            question = "Kaç tane muz var?",
            questionEn = "How many bananas are there?",
            items = listOf("🍌", "🍌", "🍌", "🍌"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 2,
            voice = "Kaç tane muz var? Sayalım Mete!"
        ),
        Question(
            id = "fruit-14",
            type = QuestionType.COUNTING,
            category = "fruits",
            question = "Kaç tane çilek var?",
            questionEn = "How many strawberries are there?",
            items = listOf("🍓", "🍓", "🍓"),
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 1,
            voice = "Kaç tane çilek var?"
        ),
        Question(
            id = "fruit-15",
            type = QuestionType.PATTERN,
            category = "fruits",
            question = "Desenin devamını bul!",
            questionEn = "Complete the pattern!",
            items = listOf("🍎", "🍎", "🍌", "🍎", "🍎"),
            options = listOf("🍌", "🍎", "🍊", "🍇"),
            correctAnswer = 0,
            voice = "Elma, elma, muz, elma, elma... Ne gelir Mete?"
        ),
        
        // NEW CATEGORY: Vegetables
        Question(
            id = "veg-1",
            type = QuestionType.QUIZ,
            category = "vegetables",
            question = "Carrot İngilizce ne demek?",
            questionEn = "What is Carrot in Turkish?",
            options = listOf("🥕 Havuç", "🥔 Patates", "🧅 Soğan", "🌽 Mısır"),
            correctAnswer = 0,
            voice = "Carrot İngilizce ne demek Mete?"
        ),
        Question(
            id = "veg-2",
            type = QuestionType.QUIZ,
            category = "vegetables",
            question = "Potato İngilizce ne demek?",
            questionEn = "What is Potato in Turkish?",
            options = listOf("🥕 Havuç", "🥔 Patates", "🧅 Soğan", "🌽 Mısır"),
            correctAnswer = 1,
            voice = "Potato İngilizce ne demek?"
        ),
        Question(
            id = "veg-3",
            type = QuestionType.QUIZ,
            category = "vegetables",
            question = "Tomato İngilizce ne demek?",
            questionEn = "What is Tomato in Turkish?",
            options = listOf("🍅 Domates", "🥒 Salatalık", "🥦 Brokoli", "🌶️ Biber"),
            correctAnswer = 0,
            voice = "Tomato İngilizce ne demek Mete?"
        ),
        Question(
            id = "veg-4",
            type = QuestionType.QUIZ,
            category = "vegetables",
            question = "Cucumber İngilizce ne demek?",
            questionEn = "What is Cucumber in Turkish?",
            options = listOf("🍅 Domates", "🥒 Salatalık", "🥦 Brokoli", "🌶️ Biber"),
            correctAnswer = 1,
            voice = "Cucumber İngilizce ne demek?"
        ),
        Question(
            id = "veg-5",
            type = QuestionType.PATTERN,
            category = "vegetables",
            question = "Hangi sebze gelecek?",
            questionEn = "Which vegetable comes next?",
            items = listOf("🥕", "🍅", "🥕", "🍅", "🥕"),
            options = listOf("🍅", "🥕", "🥔", "🧅"),
            correctAnswer = 0,
            voice = "Havuç, domates, havuç, domates, havuç... Ne gelir?"
        ),
        
        // NEW CATEGORY: Body Parts
        Question(
            id = "body-1",
            type = QuestionType.QUIZ,
            category = "bodyparts",
            question = "Eye İngilizce ne demek?",
            questionEn = "What is Eye in Turkish?",
            options = listOf("👁️ Göz", "👃 Burun", "👂 Kulak", "👄 Ağız"),
            correctAnswer = 0,
            voice = "Eye İngilizce ne demek Mete?"
        ),
        Question(
            id = "body-2",
            type = QuestionType.QUIZ,
            category = "bodyparts",
            question = "Nose İngilizce ne demek?",
            questionEn = "What is Nose in Turkish?",
            options = listOf("👁️ Göz", "👃 Burun", "👂 Kulak", "👄 Ağız"),
            correctAnswer = 1,
            voice = "Nose İngilizce ne demek?"
        ),
        Question(
            id = "body-3",
            type = QuestionType.QUIZ,
            category = "bodyparts",
            question = "Ear İngilizce ne demek?",
            questionEn = "What is Ear in Turkish?",
            options = listOf("👁️ Göz", "👃 Burun", "👂 Kulak", "👄 Ağız"),
            correctAnswer = 2,
            voice = "Ear İngilizce ne demek Mete?"
        ),
        Question(
            id = "body-4",
            type = QuestionType.QUIZ,
            category = "bodyparts",
            question = "Mouth İngilizce ne demek?",
            questionEn = "What is Mouth in Turkish?",
            options = listOf("👁️ Göz", "👃 Burun", "👂 Kulak", "👄 Ağız"),
            correctAnswer = 3,
            voice = "Mouth İngilizce ne demek?"
        ),
        Question(
            id = "body-5",
            type = QuestionType.QUIZ,
            category = "bodyparts",
            question = "Hand İngilizce ne demek?",
            questionEn = "What is Hand in Turkish?",
            options = listOf("✋ El", "🦶 Ayak", "💪 Kol", "🦵 Bacak"),
            correctAnswer = 0,
            voice = "Hand İngilizce ne demek Mete?"
        ),
        
        // NEW CATEGORY: Actions
        Question(
            id = "action-1",
            type = QuestionType.QUIZ,
            category = "actions",
            question = "Run İngilizce ne demek?",
            questionEn = "What is Run in Turkish?",
            options = listOf("🏃 Koşmak", "🚶 Yürümek", "🤸 Zıplamak", "👋 El sallamak"),
            correctAnswer = 0,
            voice = "Run İngilizce ne demek Mete?"
        ),
        Question(
            id = "action-2",
            type = QuestionType.QUIZ,
            category = "actions",
            question = "Walk İngilizce ne demek?",
            questionEn = "What is Walk in Turkish?",
            options = listOf("🏃 Koşmak", "🚶 Yürümek", "🤸 Zıplamak", "👋 El sallamak"),
            correctAnswer = 1,
            voice = "Walk İngilizce ne demek?"
        ),
        Question(
            id = "action-3",
            type = QuestionType.QUIZ,
            category = "actions",
            question = "Jump İngilizce ne demek?",
            questionEn = "What is Jump in Turkish?",
            options = listOf("🏃 Koşmak", "🚶 Yürümek", "🤸 Zıplamak", "👋 El sallamak"),
            correctAnswer = 2,
            voice = "Jump İngilizce ne demek Mete?"
        ),
        Question(
            id = "action-4",
            type = QuestionType.QUIZ,
            category = "actions",
            question = "Sleep İngilizce ne demek?",
            questionEn = "What is Sleep in Turkish?",
            options = listOf("😴 Uyumak", "🍽️ Yemek", "💧 İçmek", "📖 Okumak"),
            correctAnswer = 0,
            voice = "Sleep İngilizce ne demek?"
        ),
        Question(
            id = "action-5",
            type = QuestionType.QUIZ,
            category = "actions",
            question = "Eat İngilizce ne demek?",
            questionEn = "What is Eat in Turkish?",
            options = listOf("😴 Uyumak", "🍽️ Yemek", "💧 İçmek", "📖 Okumak"),
            correctAnswer = 1,
            voice = "Eat İngilizce ne demek Mete?"
        ),
        
        // NEW CATEGORY: Time & Days
        Question(
            id = "time-1",
            type = QuestionType.QUIZ,
            category = "time",
            question = "Monday İngilizce ne demek?",
            questionEn = "What is Monday in Turkish?",
            options = listOf("📅 Pazartesi", "📅 Salı", "📅 Çarşamba", "📅 Perşembe"),
            correctAnswer = 0,
            voice = "Monday İngilizce ne demek Mete?"
        ),
        Question(
            id = "time-2",
            type = QuestionType.QUIZ,
            category = "time",
            question = "Today İngilizce ne demek?",
            questionEn = "What is Today in Turkish?",
            options = listOf("📅 Bugün", "📅 Dün", "📅 Yarın", "📅 Şimdi"),
            correctAnswer = 0,
            voice = "Today İngilizce ne demek?"
        ),
        Question(
            id = "time-3",
            type = QuestionType.QUIZ,
            category = "time",
            question = "Tomorrow İngilizce ne demek?",
            questionEn = "What is Tomorrow in Turkish?",
            options = listOf("📅 Bugün", "📅 Dün", "📅 Yarın", "📅 Şimdi"),
            correctAnswer = 2,
            voice = "Tomorrow İngilizce ne demek Mete?"
        ),
        Question(
            id = "time-4",
            type = QuestionType.QUIZ,
            category = "time",
            question = "Morning İngilizce ne demek?",
            questionEn = "What is Morning in Turkish?",
            options = listOf("🌅 Sabah", "☀️ Öğlen", "🌆 Akşam", "🌙 Gece"),
            correctAnswer = 0,
            voice = "Morning İngilizce ne demek?"
        ),
        Question(
            id = "time-5",
            type = QuestionType.QUIZ,
            category = "time",
            question = "Night İngilizce ne demek?",
            questionEn = "What is Night in Turkish?",
            options = listOf("🌅 Sabah", "☀️ Öğlen", "🌆 Akşam", "🌙 Gece"),
            correctAnswer = 3,
            voice = "Night İngilizce ne demek Mete?"
        )
    )
    
    fun getQuestionsByCategory(categoryId: String): List<Question> {
        return questions.filter { it.category == categoryId }
    }
}
