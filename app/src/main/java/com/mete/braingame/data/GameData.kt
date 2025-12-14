package com.mete.braingame.data

import com.mete.braingame.data.models.Category
import com.mete.braingame.data.models.Question

object GameData {
    val categories = listOf(
        Category(
            id = 1,
            name = "Meyveler",
            iconRes = "🍎",
            color = 0xFFFF6B9D,
            questions = listOf(
                Question(
                    id = 1,
                    text = "Bu hangi meyve?",
                    imageRes = "elma",
                    correctAnswer = "Elma",
                    options = listOf("Elma", "Armut", "Muz", "Çilek"),
                    soundRes = "elma_ses"
                ),
                Question(
                    id = 2,
                    text = "Bu hangi meyve?",
                    imageRes = "muz",
                    correctAnswer = "Muz",
                    options = listOf("Muz", "Portakal", "Kivi", "Üzüm"),
                    soundRes = "muz_ses"
                ),
                Question(
                    id = 3,
                    text = "Bu hangi meyve?",
                    imageRes = "cilek",
                    correctAnswer = "Çilek",
                    options = listOf("Çilek", "Kiraz", "Karpuz", "Kavun"),
                    soundRes = "cilek_ses"
                ),
                Question(
                    id = 4,
                    text = "Bu hangi meyve?",
                    imageRes = "uzum",
                    correctAnswer = "Üzüm",
                    options = listOf("Üzüm", "Erik", "Şeftali", "Kayısı"),
                    soundRes = "uzum_ses"
                ),
                Question(
                    id = 5,
                    text = "Bu hangi meyve?",
                    imageRes = "portakal",
                    correctAnswer = "Portakal",
                    options = listOf("Portakal", "Mandalina", "Limon", "Greyfurt"),
                    soundRes = "portakal_ses"
                )
            )
        ),
        Category(
            id = 2,
            name = "Hayvanlar",
            iconRes = "🦁",
            color = 0xFFFF9800,
            questions = listOf(
                Question(
                    id = 6,
                    text = "Bu hangi hayvan?",
                    imageRes = "aslan",
                    correctAnswer = "Aslan",
                    options = listOf("Aslan", "Kaplan", "Leopar", "Çita"),
                    soundRes = "aslan_ses"
                ),
                Question(
                    id = 7,
                    text = "Bu hangi hayvan?",
                    imageRes = "fil",
                    correctAnswer = "Fil",
                    options = listOf("Fil", "Zürafa", "Hipopotam", "Rhinoceros"),
                    soundRes = "fil_ses"
                ),
                Question(
                    id = 8,
                    text = "Bu hangi hayvan?",
                    imageRes = "kus",
                    correctAnswer = "Kuş",
                    options = listOf("Kuş", "Tavuk", "Kartal", "Baykuş"),
                    soundRes = "kus_ses"
                ),
                Question(
                    id = 9,
                    text = "Bu hangi hayvan?",
                    imageRes = "kopek",
                    correctAnswer = "Köpek",
                    options = listOf("Köpek", "Kedi", "Tavşan", "Fare"),
                    soundRes = "kopek_ses"
                ),
                Question(
                    id = 10,
                    text = "Bu hangi hayvan?",
                    imageRes = "kedi",
                    correctAnswer = "Kedi",
                    options = listOf("Kedi", "Tilki", "Kurt", "Ayı"),
                    soundRes = "kedi_ses"
                )
            )
        ),
        Category(
            id = 3,
            name = "Sayılar",
            iconRes = "🔢",
            color = 0xFF4CAF50,
            questions = listOf(
                Question(
                    id = 11,
                    text = "Kaç tane elma var?",
                    imageRes = "sayi_1",
                    correctAnswer = "1",
                    options = listOf("1", "2", "3", "4")
                ),
                Question(
                    id = 12,
                    text = "Kaç tane balon var?",
                    imageRes = "sayi_2",
                    correctAnswer = "2",
                    options = listOf("2", "3", "4", "5")
                ),
                Question(
                    id = 13,
                    text = "Kaç tane araba var?",
                    imageRes = "sayi_3",
                    correctAnswer = "3",
                    options = listOf("3", "4", "5", "6")
                ),
                Question(
                    id = 14,
                    text = "Kaç tane top var?",
                    imageRes = "sayi_4",
                    correctAnswer = "4",
                    options = listOf("4", "5", "6", "7")
                ),
                Question(
                    id = 15,
                    text = "Kaç tane kalem var?",
                    imageRes = "sayi_5",
                    correctAnswer = "5",
                    options = listOf("5", "6", "7", "8")
                )
            )
        ),
        Category(
            id = 4,
            name = "Renkler",
            iconRes = "🎨",
            color = 0xFF2196F3,
            questions = listOf(
                Question(
                    id = 16,
                    text = "Bu hangi renk?",
                    imageRes = "kirmizi",
                    correctAnswer = "Kırmızı",
                    options = listOf("Kırmızı", "Mavi", "Yeşil", "Sarı")
                ),
                Question(
                    id = 17,
                    text = "Bu hangi renk?",
                    imageRes = "mavi",
                    correctAnswer = "Mavi",
                    options = listOf("Mavi", "Yeşil", "Sarı", "Mor")
                ),
                Question(
                    id = 18,
                    text = "Bu hangi renk?",
                    imageRes = "yesil",
                    correctAnswer = "Yeşil",
                    options = listOf("Yeşil", "Sarı", "Turuncu", "Pembe")
                ),
                Question(
                    id = 19,
                    text = "Bu hangi renk?",
                    imageRes = "sari",
                    correctAnswer = "Sarı",
                    options = listOf("Sarı", "Turuncu", "Pembe", "Kahverengi")
                ),
                Question(
                    id = 20,
                    text = "Bu hangi renk?",
                    imageRes = "mor",
                    correctAnswer = "Mor",
                    options = listOf("Mor", "Pembe", "Kahverengi", "Siyah")
                )
            )
        )
    )
}