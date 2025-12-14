package com.mete.braingame.data

import com.mete.braingame.ui.screens.LearningItem

/**
 * Learning content for each category - to teach before testing
 */
object LearningData {
    
    fun getLearningItems(categoryId: String): List<LearningItem> {
        return when (categoryId) {
            "animals" -> listOf(
                LearningItem("🦁", "Aslan", "", "Aslan"),
                LearningItem("🐘", "Fil", "", "Fil"),
                LearningItem("🐶", "Köpek", "", "Köpek"),
                LearningItem("🐱", "Kedi", "", "Kedi"),
                LearningItem("🐭", "Fare", "", "Fare"),
                LearningItem("🐰", "Tavşan", "", "Tavşan"),
                LearningItem("🐦", "Kuş", "", "Kuş"),
                LearningItem("🐟", "Balık", "", "Balık"),
                LearningItem("🦋", "Kelebek", "", "Kelebek"),
                LearningItem("🐵", "Maymun", "", "Maymun"),
                LearningItem("🐻", "Ayı", "", "Ayı"),
                LearningItem("🐴", "At", "", "At"),
                LearningItem("🐮", "İnek", "", "İnek"),
                LearningItem("🦒", "Zürafa", "", "Zürafa"),
                LearningItem("🐯", "Kaplan", "", "Kaplan"),
                LearningItem("🦓", "Zebra", "", "Zebra"),
                LearningItem("🐧", "Penguen", "", "Penguen"),
                LearningItem("🦆", "Ördek", "", "Ördek"),
                LearningItem("🦉", "Baykuş", "", "Baykuş"),
                LearningItem("🦅", "Kartal", "", "Kartal"),
                LearningItem("🐔", "Tavuk", "", "Tavuk"),
                LearningItem("🐸", "Kurbağa", "", "Kurbağa"),
                LearningItem("🐑", "Koyun", "", "Koyun"),
                LearningItem("🦊", "Tilki", "", "Tilki"),
                LearningItem("🐝", "Arı", "", "Arı")
            )
            
            "numbers" -> listOf(
                LearningItem("1️⃣", "Bir", "", "Bir"),
                LearningItem("2️⃣", "İki", "", "İki"),
                LearningItem("3️⃣", "Üç", "", "Üç"),
                LearningItem("4️⃣", "Dört", "", "Dört"),
                LearningItem("5️⃣", "Beş", "", "Beş"),
                LearningItem("6️⃣", "Altı", "", "Altı"),
                LearningItem("7️⃣", "Yedi", "", "Yedi"),
                LearningItem("8️⃣", "Sekiz", "", "Sekiz"),
                LearningItem("9️⃣", "Dokuz", "", "Dokuz"),
                LearningItem("🔟", "On", "", "On"),
                LearningItem("1️⃣1️⃣", "On Bir", "", "On Bir"),
                LearningItem("1️⃣2️⃣", "On İki", "", "On İki"),
                LearningItem("1️⃣3️⃣", "On Üç", "", "On Üç"),
                LearningItem("1️⃣4️⃣", "On Dört", "", "On Dört"),
                LearningItem("1️⃣5️⃣", "On Beş", "", "On Beş"),
                LearningItem("2️⃣0️⃣", "Yirmi", "", "Yirmi")
            )
            
            "shapes" -> listOf(
                LearningItem("🔵", "Daire", "", "Bu bir daire"),
                LearningItem("⬛", "Kare", "", "Bu bir kare"),
                LearningItem("🔺", "Üçgen", "", "Bu bir üçgen"),
                LearningItem("⭐", "Yıldız", "", "Bu bir yıldız"),
                LearningItem("❤️", "Kalp", "", "Bu bir kalp"),
                LearningItem("💎", "Elmas", "", "Bu bir elmas"),
                LearningItem("⭕", "Oval", "", "Bu bir oval"),
                LearningItem("🔶", "Baklava", "", "Bu bir baklava"),
                LearningItem("🛑", "Sekizgen", "", "Bu bir sekizgen"),
                LearningItem("🔷", "Dikdörtgen", "", "Bu bir dikdörtgen")
            )
            
            "colors" -> listOf(
                LearningItem("🔴", "Kırmızı", "", "Bu kırmızı renk"),
                LearningItem("🔵", "Mavi", "", "Bu mavi renk"),
                LearningItem("🟢", "Yeşil", "", "Bu yeşil renk"),
                LearningItem("🟡", "Sarı", "", "Bu sarı renk"),
                LearningItem("🟠", "Turuncu", "", "Bu turuncu renk"),
                LearningItem("🟣", "Mor", "", "Bu mor renk"),
                LearningItem("🩷", "Pembe", "", "Bu pembe renk"),
                LearningItem("🟤", "Kahverengi", "", "Bu kahverengi"),
                LearningItem("⚫", "Siyah", "", "Bu siyah renk"),
                LearningItem("⚪", "Beyaz", "", "Bu beyaz renk"),
                LearningItem("🩶", "Gri", "", "Bu gri renk"),
                LearningItem("🟨", "Açık Sarı", "", "Bu açık sarı renk")
            )
            
            "letters" -> listOf(
                LearningItem("🅰️", "A", "", "A harfi"),
                LearningItem("🅱️", "B", "", "B harfi"),
                LearningItem("©️", "C", "", "C harfi"),
                LearningItem("🇩", "D", "", "D harfi"),
                LearningItem("🇪", "E", "", "E harfi"),
                LearningItem("🇫", "F", "", "F harfi"),
                LearningItem("🇬", "G", "", "G harfi"),
                LearningItem("🇭", "H", "", "H harfi"),
                LearningItem("ℹ️", "I", "", "I harfi"),
                LearningItem("🇯", "J", "", "J harfi"),
                LearningItem("🇰", "K", "", "K harfi"),
                LearningItem("🇱", "L", "", "L harfi"),
                LearningItem("Ⓜ️", "M", "", "M harfi"),
                LearningItem("🇳", "N", "", "N harfi"),
                LearningItem("🅾️", "O", "", "O harfi"),
                LearningItem("🅿️", "P", "", "P harfi")
            )
            
            "fruits" -> listOf(
                LearningItem("🍎", "Elma", "", "Bu bir elma"),
                LearningItem("🍌", "Muz", "", "Bu bir muz"),
                LearningItem("🍊", "Portakal", "", "Bu bir portakal"),
                LearningItem("🍇", "Üzüm", "", "Bu üzüm"),
                LearningItem("🍓", "Çilek", "", "Bu bir çilek"),
                LearningItem("🍉", "Karpuz", "", "Bu bir karpuz"),
                LearningItem("🍒", "Kiraz", "", "Bu kiraz"),
                LearningItem("🍑", "Şeftali", "", "Bu bir şeftali"),
                LearningItem("🍐", "Armut", "", "Bu bir armut"),
                LearningItem("🍋", "Limon", "", "Bu bir limon"),
                LearningItem("🥝", "Kivi", "", "Bu bir kivi"),
                LearningItem("🍍", "Ananas", "", "Bu bir ananas"),
                LearningItem("🥭", "Mango", "", "Bu bir mango"),
                LearningItem("🫐", "Yaban Mersini", "", "Bu yaban mersini")
            )
            
            "vegetables" -> listOf(
                LearningItem("🥕", "Havuç", "", "Bu bir havuç"),
                LearningItem("🥔", "Patates", "", "Bu bir patates"),
                LearningItem("🧅", "Soğan", "", "Bu bir soğan"),
                LearningItem("🌽", "Mısır", "", "Bu mısır"),
                LearningItem("🍅", "Domates", "", "Bu bir domates"),
                LearningItem("🥒", "Salatalık", "", "Bu bir salatalık"),
                LearningItem("🥦", "Brokoli", "", "Bu brokoli"),
                LearningItem("🌶️", "Biber", "", "Bu bir biber"),
                LearningItem("🥬", "Lahana", "", "Bu lahana"),
                LearningItem("🫑", "Dolmalık Biber", "", "Bu dolmalık biber"),
                LearningItem("🍆", "Patlıcan", "", "Bu bir patlıcan"),
                LearningItem("🥑", "Avokado", "", "Bu bir avokado")
            )
            
            "bodyparts" -> listOf(
                LearningItem("👁️", "Göz", "", "Bu göz"),
                LearningItem("👃", "Burun", "", "Bu burun"),
                LearningItem("👂", "Kulak", "", "Bu kulak"),
                LearningItem("👄", "Ağız", "", "Bu ağız"),
                LearningItem("✋", "El", "", "Bu el"),
                LearningItem("🦶", "Ayak", "", "Bu ayak"),
                LearningItem("💪", "Kol", "", "Bu kol"),
                LearningItem("🦵", "Bacak", "", "Bu bacak"),
                LearningItem("👅", "Dil", "", "Bu dil"),
                LearningItem("🦷", "Diş", "", "Bu diş"),
                LearningItem("🫀", "Kalp", "", "Bu kalp"),
                LearningItem("🧠", "Beyin", "", "Bu beyin")
            )
            
            "actions" -> listOf(
                LearningItem("🏃", "Koşmak", "", "Koşmak"),
                LearningItem("🚶", "Yürümek", "", "Yürümek"),
                LearningItem("🤸", "Zıplamak", "", "Zıplamak"),
                LearningItem("👋", "El Sallamak", "", "El sallamak"),
                LearningItem("😴", "Uyumak", "", "Uyumak"),
                LearningItem("🍽️", "Yemek Yemek", "", "Yemek"),
                LearningItem("💧", "Su İçmek", "", "İçmek"),
                LearningItem("📖", "Okumak", "", "Okumak"),
                LearningItem("✍️", "Yazmak", "", "Yazmak"),
                LearningItem("🎨", "Resim Yapmak", "", "Resim yapmak"),
                LearningItem("🎵", "Şarkı Söylemek", "", "Şarkı söylemek"),
                LearningItem("🤗", "Sarılmak", "", "Sarılmak")
            )
            
            "time" -> listOf(
                LearningItem("📅", "Pazartesi", "", "Pazartesi"),
                LearningItem("📅", "Salı", "", "Salı"),
                LearningItem("📅", "Çarşamba", "", "Çarşamba"),
                LearningItem("📅", "Perşembe", "", "Perşembe"),
                LearningItem("📅", "Cuma", "", "Cuma"),
                LearningItem("📅", "Cumartesi", "", "Cumartesi"),
                LearningItem("📅", "Pazar", "", "Pazar"),
                LearningItem("🌅", "Sabah", "", "Sabah"),
                LearningItem("☀️", "Öğlen", "", "Öğlen"),
                LearningItem("🌆", "Akşam", "", "Akşam"),
                LearningItem("🌙", "Gece", "", "Gece")
            )
            
            else -> emptyList()
        }
    }
}
