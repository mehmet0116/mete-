package com.mete.braingame.data

object GameData {
    val categories = listOf(
        Category(
            id = 1,
            name = "animals",
            displayName = "Hayvanlar",
            colorRes = "category_animals",
            iconRes = "🐯",
            description = "25 hayvan ve gerçek sesleri",
            totalQuestions = 10
        ),
        Category(
            id = 2,
            name = "numbers",
            displayName = "Sayılar",
            colorRes = "category_numbers",
            iconRes = "🔢",
            description = "1'den 20'ye kadar sayılar",
            totalQuestions = 10
        ),
        Category(
            id = 3,
            name = "shapes",
            displayName = "Şekiller",
            colorRes = "category_shapes",
            iconRes = "⭐",
            description = "10 farklı şekil",
            totalQuestions = 8
        ),
        Category(
            id = 4,
            name = "colors",
            displayName = "Renkler",
            colorRes = "category_colors",
            iconRes = "🎨",
            description = "12 temel renk",
            totalQuestions = 8
        ),
        Category(
            id = 5,
            name = "fruits",
            displayName = "Meyveler",
            colorRes = "category_fruits",
            iconRes = "🍎",
            description = "14 lezzetli meyve",
            totalQuestions = 8
        ),
        Category(
            id = 6,
            name = "vegetables",
            displayName = "Sebzeler",
            colorRes = "category_vegetables",
            iconRes = "🥕",
            description = "12 sağlıklı sebze",
            totalQuestions = 8
        ),
        Category(
            id = 7,
            name = "body_parts",
            displayName = "Vücut Bölümleri",
            colorRes = "category_animals", // Reuse color
            iconRes = "👁️",
            description = "12 vücut bölümü",
            totalQuestions = 8
        ),
        Category(
            id = 8,
            name = "actions",
            displayName = "Hareketler",
            colorRes = "category_numbers", // Reuse color
            iconRes = "🏃",
            description = "12 temel hareket",
            totalQuestions = 8
        ),
        Category(
            id = 9,
            name = "time",
            displayName = "Zaman",
            colorRes = "category_shapes", // Reuse color
            iconRes = "📅",
            description = "11 zaman kavramı",
            totalQuestions = 8
        ),
        Category(
            id = 10,
            name = "letters",
            displayName = "Harfler",
            colorRes = "category_colors", // Reuse color
            iconRes = "📝",
            description = "16 temel harf",
            totalQuestions = 8
        )
    )

    fun getQuestionsForCategory(categoryId: Int): List<Question> {
        return when (categoryId) {
            1 -> animalQuestions
            2 -> numberQuestions
            3 -> shapeQuestions
            4 -> colorQuestions
            5 -> fruitQuestions
            6 -> vegetableQuestions
            7 -> bodyPartQuestions
            8 -> actionQuestions
            9 -> timeQuestions
            10 -> letterQuestions
            else -> emptyList()
        }
    }

    private val animalQuestions = List(10) { index ->
        Question(
            id = index + 1,
            categoryId = 1,
            text = "Bu hayvanın adı nedir?",
            imageRes = "animal_${index + 1}",
            soundRes = "sound_animal_${index + 1}",
            options = listOf("Aslan", "Kaplan", "Fil", "Zürafa", "Maymun", "Köpek", "Kedi", "Kuş").shuffled(),
            correctAnswer = 0,
            explanation = "Bu bir aslan, ormanların kralı!"
        )
    }

    private val numberQuestions = List(10) { index ->
        val number = index + 1
        Question(
            id = index + 11,
            categoryId = 2,
            text = "Kaç tane nesne var?",
            imageRes = "number_$number",
            options = List(4) { (it + 1).toString() },
            correctAnswer = 0,
            explanation = "Doğru! $number tane var."
        )
    }

    private val shapeQuestions = List(8) { index ->
        val shapes = listOf("Daire", "Kare", "Üçgen", "Dikdörtgen", "Yıldız", "Kalp", "Oval", "Altıgen")
        Question(
            id = index + 21,
            categoryId = 3,
            text = "Bu şeklin adı nedir?",
            imageRes = "shape_${index + 1}",
            options = shapes.shuffled(),
            correctAnswer = shapes.indexOf(shapes[index]),
            explanation = "Evet, bu bir ${shapes[index].lowercase()}!"
        )
    }

    private val colorQuestions = List(8) { index ->
        val colors = listOf("Kırmızı", "Mavi", "Yeşil", "Sarı", "Turuncu", "Mor", "Pembe", "Kahverengi")
        Question(
            id = index + 31,
            categoryId = 4,
            text = "Bu rengin adı nedir?",
            imageRes = "color_${index + 1}",
            options = colors.shuffled(),
            correctAnswer = colors.indexOf(colors[index]),
            explanation = "Doğru! Bu renk ${colors[index].lowercase()}."
        )
    }

    private val fruitQuestions = List(8) { index ->
        val fruits = listOf("Elma", "Muz", "Çilek", "Portakal", "Üzüm", "Karpuz", "Kiraz", "Şeftali")
        Question(
            id = index + 41,
            categoryId = 5,
            text = "Bu meyvenin adı nedir?",
            imageRes = "fruit_${index + 1}",
            options = fruits.shuffled(),
            correctAnswer = fruits.indexOf(fruits[index]),
            explanation = "Lezzetli bir ${fruits[index].lowercase()}!"
        )
    }

    private val vegetableQuestions = List(8) { index ->
        val vegetables = listOf("Havuç", "Domates", "Salatalık", "Patates", "Soğan", "Biber", "Ispanak", "Brokoli")
        Question(
            id = index + 51,
            categoryId = 6,
            text = "Bu sebzenin adı nedir?",
            imageRes = "vegetable_${index + 1}",
            options = vegetables.shuffled(),
            correctAnswer = vegetables.indexOf(vegetables[index]),
            explanation = "Sağlıklı bir ${vegetables[index].lowercase()}!"
        )
    }

    private val bodyPartQuestions = List(8) { index ->
        val bodyParts = listOf("Göz", "Burun", "Ağız", "Kulak", "El", "Ayak", "Baş", "Parmak")
        Question(
            id = index + 61,
            categoryId = 7,
            text = "Bu vücut bölümünün adı nedir?",
            imageRes = "body_${index + 1}",
            options = bodyParts.shuffled(),
            correctAnswer = bodyParts.indexOf(bodyParts[index]),
            explanation = "Evet, bu bir ${bodyParts[index].lowercase()}!"
        )
    }

    private val actionQuestions = List(8) { index ->
        val actions = listOf("Koş", "Zıpla", "Yürü", "Otur", "Kalk", "El salla", "Dans et", "Gül")
        Question(
            id = index + 71,
            categoryId = 8,
            text = "Bu hareketin adı nedir?",
            imageRes = "action_${index + 1}",
            options = actions.shuffled(),
            correctAnswer = actions.indexOf(actions[index]),
            explanation = "Harika! ${actions[index]} hareketi!"
        )
    }

    private val timeQuestions = List(8) { index ->
        val times = listOf("Sabah", "Öğle", "Akşam", "Gece", "Bugün", "Yarın", "Dün", "Hafta")
        Question(
            id = index + 81,
            categoryId = 9,
            text = "Bu zaman kavramının adı nedir?",
            imageRes = "time_${index + 1}",
            options = times.shuffled(),
            correctAnswer = times.indexOf(times[index]),
            explanation = "Doğru! Bu zaman ${times[index].lowercase()}."
        )
    }

    private val letterQuestions = List(8) { index ->
        val letters = listOf("A", "B", "C", "D", "E", "F", "G", "H")
        Question(
            id = index + 91,
            categoryId = 10,
            text = "Bu harfin adı nedir?",
            imageRes = "letter_${index + 1}",
            options = letters.shuffled(),
            correctAnswer = letters.indexOf(letters[index]),
            explanation = "Harika! Bu ${letters[index]} harfi!"
        )
    }
}