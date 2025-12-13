package com.mete.braingame.data

import com.mete.braingame.ui.screens.LearningItem

/**
 * Learning content for each category - to teach before testing
 */
object LearningData {
    
    fun getLearningItems(categoryId: String): List<LearningItem> {
        return when (categoryId) {
            "animals" -> listOf(
                LearningItem("🦁", "Aslan", "Lion", "Aslan böyle der: Haauuuvvv"),
                LearningItem("🐘", "Fil", "Elephant", "Fil böyle der: Töööörrrr"),
                LearningItem("🐶", "Köpek", "Dog", "Köpek böyle der: Hav hav"),
                LearningItem("🐱", "Kedi", "Cat", "Kedi böyle der: Miyav miyav"),
                LearningItem("🐭", "Fare", "Mouse", "Fare böyle der: Cik cik"),
                LearningItem("🐰", "Tavşan", "Rabbit", "Tavşan hıf hıf der"),
                LearningItem("🐦", "Kuş", "Bird", "Kuş böyle der: Cik cik cirrrik"),
                LearningItem("🐟", "Balık", "Fish", "Balık suda yüzer"),
                LearningItem("🦋", "Kelebek", "Butterfly", "Kelebek uçuyor"),
                LearningItem("🐵", "Maymun", "Monkey", "Maymun böyle der: Ooo ooo aa aa"),
                LearningItem("🐻", "Ayı", "Bear", "Ayı böyle der: Hırrr"),
                LearningItem("🐴", "At", "Horse", "At böyle der: İhiii"),
                LearningItem("🐮", "İnek", "Cow", "İnek böyle der: Möööö"),
                LearningItem("🦒", "Zürafa", "Giraffe", "Zürafa sessiz bir hayvandır"),
                LearningItem("🐯", "Kaplan", "Tiger", "Kaplan böyle der: Hırrr"),
                LearningItem("🦓", "Zebra", "Zebra", "Zebra böyle der: İhiii"),
                LearningItem("🐧", "Penguen", "Penguin", "Penguen böyle der: Öak öak"),
                LearningItem("🦆", "Ördek", "Duck", "Ördek böyle der: Vak vak"),
                LearningItem("🦉", "Baykuş", "Owl", "Baykuş böyle der: Huu huu"),
                LearningItem("🦅", "Kartal", "Eagle", "Kartal böyle der: Çirrrt")
            )
            
            "numbers" -> listOf(
                LearningItem("1️⃣", "Bir", "One", "Bir"),
                LearningItem("2️⃣", "İki", "Two", "İki"),
                LearningItem("3️⃣", "Üç", "Three", "Üç"),
                LearningItem("4️⃣", "Dört", "Four", "Dört"),
                LearningItem("5️⃣", "Beş", "Five", "Beş"),
                LearningItem("6️⃣", "Altı", "Six", "Altı"),
                LearningItem("7️⃣", "Yedi", "Seven", "Yedi"),
                LearningItem("8️⃣", "Sekiz", "Eight", "Sekiz"),
                LearningItem("9️⃣", "Dokuz", "Nine", "Dokuz"),
                LearningItem("🔟", "On", "Ten", "On")
            )
            
            "shapes" -> listOf(
                LearningItem("🔵", "Daire", "Circle", "Bu bir daire"),
                LearningItem("⬛", "Kare", "Square", "Bu bir kare"),
                LearningItem("🔺", "Üçgen", "Triangle", "Bu bir üçgen"),
                LearningItem("⭐", "Yıldız", "Star", "Bu bir yıldız"),
                LearningItem("❤️", "Kalp", "Heart", "Bu bir kalp"),
                LearningItem("💎", "Elmas", "Diamond", "Bu bir elmas"),
                LearningItem("⭕", "Oval", "Oval", "Bu bir oval")
            )
            
            "colors" -> listOf(
                LearningItem("🔴", "Kırmızı", "Red", "Bu kırmızı renk"),
                LearningItem("🔵", "Mavi", "Blue", "Bu mavi renk"),
                LearningItem("🟢", "Yeşil", "Green", "Bu yeşil renk"),
                LearningItem("🟡", "Sarı", "Yellow", "Bu sarı renk"),
                LearningItem("🟠", "Turuncu", "Orange", "Bu turuncu renk"),
                LearningItem("🟣", "Mor", "Purple", "Bu mor renk"),
                LearningItem("🩷", "Pembe", "Pink", "Bu pembe renk"),
                LearningItem("🟤", "Kahverengi", "Brown", "Bu kahverengi"),
                LearningItem("⚫", "Siyah", "Black", "Bu siyah renk"),
                LearningItem("⚪", "Beyaz", "White", "Bu beyaz renk")
            )
            
            "letters" -> listOf(
                LearningItem("🅰️", "A", "A", "A harfi"),
                LearningItem("🅱️", "B", "B", "B harfi"),
                LearningItem("©️", "C", "C", "C harfi"),
                LearningItem("🇩", "D", "D", "D harfi"),
                LearningItem("🇪", "E", "E", "E harfi"),
                LearningItem("🇫", "F", "F", "F harfi"),
                LearningItem("🇬", "G", "G", "G harfi"),
                LearningItem("🇭", "H", "H", "H harfi")
            )
            
            "fruits" -> listOf(
                LearningItem("🍎", "Elma", "Apple", "Bu bir elma"),
                LearningItem("🍌", "Muz", "Banana", "Bu bir muz"),
                LearningItem("🍊", "Portakal", "Orange", "Bu bir portakal"),
                LearningItem("🍇", "Üzüm", "Grape", "Bu üzüm"),
                LearningItem("🍓", "Çilek", "Strawberry", "Bu bir çilek"),
                LearningItem("🍉", "Karpuz", "Watermelon", "Bu bir karpuz"),
                LearningItem("🍒", "Kiraz", "Cherry", "Bu kiraz"),
                LearningItem("🍑", "Şeftali", "Peach", "Bu bir şeftali"),
                LearningItem("🍐", "Armut", "Pear", "Bu bir armut"),
                LearningItem("🍋", "Limon", "Lemon", "Bu bir limon")
            )
            
            "vegetables" -> listOf(
                LearningItem("🥕", "Havuç", "Carrot", "Bu bir havuç"),
                LearningItem("🥔", "Patates", "Potato", "Bu bir patates"),
                LearningItem("🧅", "Soğan", "Onion", "Bu bir soğan"),
                LearningItem("🌽", "Mısır", "Corn", "Bu mısır"),
                LearningItem("🍅", "Domates", "Tomato", "Bu bir domates"),
                LearningItem("🥒", "Salatalık", "Cucumber", "Bu bir salatalık"),
                LearningItem("🥦", "Brokoli", "Broccoli", "Bu brokoli"),
                LearningItem("🌶️", "Biber", "Pepper", "Bu bir biber")
            )
            
            "bodyparts" -> listOf(
                LearningItem("👁️", "Göz", "Eye", "Bu göz"),
                LearningItem("👃", "Burun", "Nose", "Bu burun"),
                LearningItem("👂", "Kulak", "Ear", "Bu kulak"),
                LearningItem("👄", "Ağız", "Mouth", "Bu ağız"),
                LearningItem("✋", "El", "Hand", "Bu el"),
                LearningItem("🦶", "Ayak", "Foot", "Bu ayak"),
                LearningItem("💪", "Kol", "Arm", "Bu kol"),
                LearningItem("🦵", "Bacak", "Leg", "Bu bacak")
            )
            
            "actions" -> listOf(
                LearningItem("🏃", "Koşmak", "Run", "Koşmak"),
                LearningItem("🚶", "Yürümek", "Walk", "Yürümek"),
                LearningItem("🤸", "Zıplamak", "Jump", "Zıplamak"),
                LearningItem("👋", "El sallamak", "Wave", "El sallamak"),
                LearningItem("😴", "Uyumak", "Sleep", "Uyumak"),
                LearningItem("🍽️", "Yemek", "Eat", "Yemek"),
                LearningItem("💧", "İçmek", "Drink", "İçmek"),
                LearningItem("📖", "Okumak", "Read", "Okumak")
            )
            
            "time" -> listOf(
                LearningItem("📅", "Pazartesi", "Monday", "Pazartesi"),
                LearningItem("📅", "Salı", "Tuesday", "Salı"),
                LearningItem("📅", "Çarşamba", "Wednesday", "Çarşamba"),
                LearningItem("📅", "Perşembe", "Thursday", "Perşembe"),
                LearningItem("📅", "Cuma", "Friday", "Cuma"),
                LearningItem("🌅", "Sabah", "Morning", "Sabah"),
                LearningItem("☀️", "Öğlen", "Noon", "Öğlen"),
                LearningItem("🌆", "Akşam", "Evening", "Akşam"),
                LearningItem("🌙", "Gece", "Night", "Gece")
            )
            
            else -> emptyList()
        }
    }
}
