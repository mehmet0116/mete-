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
    
    companion object {
        /**
         * Animal sound mapping - centralized to avoid duplication
         */
        private val ANIMAL_SOUNDS = mapOf(
            "🦁" to "Aslan böyle der: Haauuuvvv",
            "🐘" to "Fil böyle der: Töööörrrr",
            "🐶" to "Köpek böyle der: Hav hav",
            "🐱" to "Kedi böyle der: Miyav miyav",
            "🐭" to "Fare böyle der: Cik cik",
            "🐰" to "Tavşan hıf hıf der",
            "🐦" to "Kuş böyle der: Cik cik cirrrik",
            "🐟" to "Balık suda yüzer",
            "🦋" to "Kelebek uçuyor",
            "🐮" to "İnek böyle der: Möööö",
            "🐷" to "Domuz böyle der: Oink oink",
            "🐸" to "Kurbağa böyle der: Vrak vrak",
            "🐔" to "Tavuk böyle der: Gıt gıt gıdaak",
            "🦆" to "Ördek böyle der: Vak vak",
            "🐴" to "At böyle der: İhiii",
            "🐑" to "Koyun böyle der: Meee",
            "🦉" to "Baykuş böyle der: Huu huu",
            "🦅" to "Kartal böyle der: Çirrrt",
            "🐝" to "Arı böyle der: Vızz vızz",
            "🐵" to "Maymun böyle der: Ooo ooo aa aa",
            "🐻" to "Ayı böyle der: Hırrr",
            "🦊" to "Tilki böyle der: Yaff yaff",
            "🦒" to "Zürafa sessiz bir hayvandır",
            "🐯" to "Kaplan böyle der: Hırrr",
            "🦓" to "Zebra böyle der: İhiii",
            "🐧" to "Penguen böyle der: Öak öak"
        )
    }
    
    /**
     * Get sound description for TTS
     */
    fun getAnimalSoundText(animalEmoji: String): String? {
        return ANIMAL_SOUNDS[animalEmoji]
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
