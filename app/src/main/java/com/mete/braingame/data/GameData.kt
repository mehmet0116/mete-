package com.mete.braingame.data

import androidx.compose.ui.graphics.Color
import com.mete.braingame.ui.theme.*

object GameData {
    // Tüm kategoriler
    val categories = listOf(
        Category(
            id = 1,
            name = "animals",
            displayName = "Hayvanlar",
            color = AnimalsColor,
            icon = "🦁",
            description = "25 farklı hayvan ve gerçek sesleri",
            totalQuestions = 10
        ),
        Category(
            id = 2,
            name = "numbers",
            displayName = "Sayılar",
            color = NumbersColor,
            icon = "🔢",
            description = "1'den 20'ye kadar sayılar",
            totalQuestions = 10
        ),
        Category(
            id = 3,
            name = "shapes",
            displayName = "Şekiller",
            color = ShapesColor,
            icon = "⭐",
            description = "10 farklı geometrik şekil",
            totalQuestions = 8
        ),
        Category(
            id = 4,
            name = "colors",
            displayName = "Renkler",
            color = ColorsColor,
            icon = "🎨",
            description = "12 temel ve ara renk",
            totalQuestions = 8
        ),
        Category(
            id = 5,
            name = "letters",
            displayName = "Harfler",
            color = LettersColor,
            icon = "📝",
            description = "Türkçe alfabe harfleri",
            totalQuestions = 10
        ),
        Category(
            id = 6,
            name = "fruits",
            displayName = "Meyveler",
            color = FruitsColor,
            icon = "🍎",
            description = "14 farklı meyve",
            totalQuestions = 8
        ),
        Category(
            id = 7,
            name = "vegetables",
            displayName = "Sebzeler",
            color = VegetablesColor,
            icon = "🥕",
            description = "12 farklı sebze",
            totalQuestions = 8
        ),
        Category(
            id = 8,
            name = "bodyparts",
            displayName = "Vücut Bölümleri",
            color = BodyPartsColor,
            icon = "👁️",
            description = "12 temel vücut bölümü",
            totalQuestions = 8
        ),
        Category(
            id = 9,
            name = "actions",
            displayName = "Hareketler",
            color = ActionsColor,
            icon = "🏃",
            description = "12 farklı hareket ve eylem",
            totalQuestions = 8
        ),
        Category(
            id = 10,
            name = "time",
            displayName = "Zaman",
            color = TimeColor,
            icon = "📅",
            description = "11 zaman kavramı",
            totalQuestions = 8
        )
    )

    // Hayvanlar kategorisi soruları
    val animalQuestions = listOf(
        Question(
            id = 1,
            categoryId = 1,
            text = "Hangi hayvan 'miyav' sesi çıkarır?",
            options = listOf("Köpek", "Kedi", "Aslan", "Kuş"),
            correctAnswer = 1,
            soundRes = "cat_meow"
        ),
        Question(
            id = 2,
            categoryId = 1,
            text = "Hangi hayvan havlar?",
            options = listOf("Kedi", "Köpek", "İnek", "Tavuk"),
            correctAnswer = 1,
            soundRes = "dog_bark"
        ),
        Question(
            id = 3,
            categoryId = 1,
            text = "Hangi hayvan mööö diye ses çıkarır?",
            options = listOf("Koyun", "İnek", "Keçi", "At"),
            correctAnswer = 1,
            soundRes = "cow_moo"
        ),
        Question(
            id = 4,
            categoryId = 1,
            text = "Hangi hayvan kükrer?",
            options = listOf("Kaplan", "Ayı", "Aslan", "Kurt"),
            correctAnswer = 2,
            soundRes = "lion_roar"
        ),
        Question(
            id = 5,
            categoryId = 1,
            text = "Hangi hayvan cik cik öter?",
            options = listOf("Serçe", "Baykuş", "Kartal", "Penguen"),
            correctAnswer = 0,
            soundRes = "bird_chirp"
        )
    )

    // Sayılar kategorisi soruları
    val numberQuestions = listOf(
        Question(
            id = 101,
            categoryId = 2,
            text = "Kaç tane elma görüyorsun? 🍎🍎🍎",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 1
        ),
        Question(
            id = 102,
            categoryId = 2,
            text = "1'den sonra hangi sayı gelir?",
            options = listOf("0", "2", "3", "4"),
            correctAnswer = 1
        ),
        Question(
            id = 103,
            categoryId = 2,
            text = "Kaç tane balon var? 🎈🎈🎈🎈",
            options = listOf("3", "4", "5", "6"),
            correctAnswer = 1
        ),
        Question(
            id = 104,
            categoryId = 2,
            text = "5'ten önce hangi sayı gelir?",
            options = listOf("3", "4", "6", "7"),
            correctAnswer = 1
        ),
        Question(
            id = 105,
            categoryId = 2,
            text = "2 + 3 kaç eder?",
            options = listOf("4", "5", "6", "7"),
            correctAnswer = 1
        )
    )

    // Meyveler kategorisi soruları
    val fruitQuestions = listOf(
        Question(
            id = 601,
            categoryId = 6,
            text = "Hangi meyve kırmızı renklidir? 🍎",
            options = listOf("Muz", "Elma", "Portakal", "Üzüm"),
            correctAnswer = 1
        ),
        Question(
            id = 602,
            categoryId = 6,
            text = "Hangi meyve sarı renklidir ve maymunlar sever? 🍌",
            options = listOf("Muz", "Kiraz", "Çilek", "Kavun"),
            correctAnswer = 0
        ),
        Question(
            id = 603,
            categoryId = 6,
            text = "Hangi meyve büyük ve yeşil renklidir? 🍉",
            options = listOf("Kiraz", "Karpuz", "Üzüm", "Limon"),
            correctAnswer = 1
        ),
        Question(
            id = 604,
            categoryId = 6,
            text = "Hangi meyve küçük ve kırmızı renklidir? 🍒",
            options = listOf("Kiraz", "Elma", "Armut", "Kavun"),
            correctAnswer = 0
        ),
        Question(
            id = 605,
            categoryId = 6,
            text = "Hangi meyve portakal renklidir? 🍊",
            options = listOf("Muz", "Portakal", "Üzüm", "Çilek"),
            correctAnswer = 1
        )
    )

    // Renkler kategorisi soruları
    val colorQuestions = listOf(
        Question(
            id = 401,
            categoryId = 4,
            text = "Elmanın rengi nedir? 🍎",
            options = listOf("Yeşil", "Kırmızı", "Mavi", "Sarı"),
            correctAnswer = 1
        ),
        Question(
            id = 402,
            categoryId = 4,
            text = "Güneşin rengi nedir? ☀️",
            options = listOf("Mavi", "Yeşil", "Sarı", "Kırmızı"),
            correctAnswer = 2
        ),
        Question(
            id = 403,
            categoryId = 4,
            text = "Gökyüzünün rengi nedir? ☁️",
            options = listOf("Mavi", "Yeşil", "Sarı", "Pembe"),
            correctAnswer = 0
        ),
        Question(
            id = 404,
            categoryId = 4,
            text = "Çimenin rengi nedir? 🌱",
            options = listOf("Mavi", "Yeşil", "Kırmızı", "Sarı"),
            correctAnswer = 1
        ),
        Question(
            id = 405,
            categoryId = 4,
            text = "Hangi renk portakal ve sarının karışımıdır? 🟠",
            options = listOf("Mor", "Yeşil", "Turuncu", "Pembe"),
            correctAnswer = 2
        )
    )

    // Şekiller kategorisi soruları
    val shapeQuestions = listOf(
        Question(
            id = 301,
            categoryId = 3,
            text = "Topun şekli nedir? ⚽",
            options = listOf("Kare", "Daire", "Üçgen", "Yıldız"),
            correctAnswer = 1
        ),
        Question(
            id = 302,
            categoryId = 3,
            text = "Kaç köşesi vardır üçgenin? 🔺",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 1
        ),
        Question(
            id = 303,
            categoryId = 3,
            text = "Kaç kenarı vardır karenin? ⬛",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = 2
        ),
        Question(
            id = 304,
            categoryId = 3,
            text = "Hangi şekil gökyüzünde parlar? ⭐",
            options = listOf("Kare", "Daire", "Yıldız", "Üçgen"),
            correctAnswer = 2
        ),
        Question(
            id = 305,
            categoryId = 3,
            text = "Sevginin şekli nedir? ❤️",
            options = listOf("Yıldız", "Kalp", "Kare", "Daire"),
            correctAnswer = 1
        )
    )

    // Tüm soruları birleştiren fonksiyon
    fun getQuestionsForCategory(categoryId: Int): List<Question> {
        return when (categoryId) {
            1 -> animalQuestions
            2 -> numberQuestions
            3 -> shapeQuestions
            4 -> colorQuestions
            5 -> listOf() // Harfler soruları
            6 -> fruitQuestions
            7 -> listOf() // Sebzeler soruları
            8 -> listOf() // Vücut bölümleri soruları
            9 -> listOf() // Hareketler soruları
            10 -> listOf() // Zaman soruları
            else -> emptyList()
        }
    }

    // Kategoriye göre renk döndür
    fun getCategoryColor(categoryId: Int): Color {
        return categories.find { it.id == categoryId }?.color ?: NeutralColor
    }

    // Kategori adını döndür
    fun getCategoryName(categoryId: Int): String {
        return categories.find { it.id == categoryId }?.displayName ?: "Bilinmeyen"
    }

    // Kategori ID'sine göre kategoriyi döndür
    fun getCategoryById(categoryId: Int): Category? {
        return categories.find { it.id == categoryId }
    }
}