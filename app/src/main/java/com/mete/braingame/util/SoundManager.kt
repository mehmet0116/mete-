package com.mete.braingame.util

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool

/**
 * Sound effects manager for animal sounds and other audio feedback
 */
class SoundManager(private val context: Context) {
    private var soundPool: SoundPool? = null
    private val soundMap = mutableMapOf<String, Int>()
    private var isEnabled = true
    
    init {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        
        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()
        
        // Load animal sounds programmatically using TTS for now
        // In a full implementation, you would load actual sound files from res/raw
    }
    
    /**
     * Play an animal sound based on the emoji
     */
    fun playAnimalSound(animalEmoji: String) {
        if (!isEnabled) return
        
        // Map emoji to sound description for TTS
        // In production, this would play actual sound files
        val soundText = when (animalEmoji) {
            "🦁" -> "Aslan: Haauuuvvv" // Lion roar
            "🐘" -> "Fil: Töööörrrr" // Elephant trumpet
            "🐶" -> "Köpek: Hav hav" // Dog bark
            "🐱" -> "Kedi: Miyav miyav" // Cat meow
            "🐭" -> "Fare: Cik cik" // Mouse squeak
            "🐰" -> "Tavşan: Hıf hıf" // Rabbit sniff
            "🐦" -> "Kuş: Cik cik" // Bird chirp
            "🐮" -> "İnek: Möööö" // Cow moo
            "🐷" -> "Domuz: Oink oink" // Pig oink
            "🐸" -> "Kurbağa: Vrak vrak" // Frog croak
            "🐔" -> "Tavuk: Gıt gıt gıdaak" // Chicken cluck
            "🦆" -> "Ördek: Vak vak" // Duck quack
            "🐴" -> "At: İhiii" // Horse neigh
            "🐑" -> "Koyun: Meee" // Sheep baa
            "🦉" -> "Baykuş: Huu huu" // Owl hoot
            "🦅" -> "Kartal: Çirrrt" // Eagle screech
            "🐝" -> "Arı: Vızz vızz" // Bee buzz
            "🦋" -> "Kelebek: Hafif kanat sesi" // Butterfly (quiet)
            "🐵" -> "Maymun: Ooo ooo aa aa" // Monkey
            "🐻" -> "Ayı: Hırrr" // Bear growl
            "🦊" -> "Tilki: Yaff yaff" // Fox
            "🦒" -> "Zürafa: Sessiz hayvan" // Giraffe (quiet)
            "🐯" -> "Kaplan: Hırrr" // Tiger growl
            "🦓" -> "Zebra: İhiii" // Zebra neigh
            "🐧" -> "Penguen: Öak öak" // Penguin
            else -> null
        }
        
        // For now, we return the sound text to be spoken by TTS
        // In a full implementation, this would trigger actual sound playback
    }
    
    /**
     * Get sound description for TTS
     */
    fun getAnimalSoundText(animalEmoji: String): String? {
        return when (animalEmoji) {
            "🦁" -> "Aslan böyle der: Haauuuvvv"
            "🐘" -> "Fil böyle der: Töööörrrr"
            "🐶" -> "Köpek böyle der: Hav hav"
            "🐱" -> "Kedi böyle der: Miyav miyav"
            "🐭" -> "Fare böyle der: Cik cik"
            "🐰" -> "Tavşan hıf hıf der"
            "🐦" -> "Kuş böyle der: Cik cik cirrrik"
            "🐮" -> "İnek böyle der: Möööö"
            "🐷" -> "Domuz böyle der: Oink oink"
            "🐸" -> "Kurbağa böyle der: Vrak vrak"
            "🐔" -> "Tavuk böyle der: Gıt gıt gıdaak"
            "🦆" -> "Ördek böyle der: Vak vak"
            "🐴" -> "At böyle der: İhiii"
            "🐑" -> "Koyun böyle der: Meee"
            "🦉" -> "Baykuş böyle der: Huu huu"
            "🦅" -> "Kartal böyle der: Çirrrt"
            "🐝" -> "Arı böyle der: Vızz vızz"
            "🦋" -> "Kelebek uçuyor"
            "🐵" -> "Maymun böyle der: Ooo ooo aa aa"
            "🐻" -> "Ayı böyle der: Hırrr"
            "🦊" -> "Tilki böyle der: Yaff yaff"
            "🦒" -> "Zürafa sessiz bir hayvandır"
            "🐯" -> "Kaplan böyle der: Hırrr"
            "🦓" -> "Zebra böyle der: İhiii"
            "🐧" -> "Penguen böyle der: Öak öak"
            else -> null
        }
    }
    
    fun toggle() {
        isEnabled = !isEnabled
    }
    
    fun isEnabled(): Boolean = isEnabled
    
    fun release() {
        soundPool?.release()
        soundPool = null
        soundMap.clear()
    }
}
