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
        
        loadAnimalSounds()
    }
    
    /**
     * Load animal sound files from res/raw
     */
    private fun loadAnimalSounds() {
        soundPool?.let { pool ->
            ANIMAL_SOUND_FILES.forEach { (emoji, resourceName) ->
                try {
                    val resourceId = context.resources.getIdentifier(
                        resourceName, 
                        "raw", 
                        context.packageName
                    )
                    if (resourceId != 0) {
                        val soundId = pool.load(context, resourceId, 1)
                        soundMap[emoji] = soundId
                    }
                } catch (e: Exception) {
                    // Silently fail if sound file not found
                    e.printStackTrace()
                }
            }
        }
    }
    
    companion object {
        /**
         * Animal sound file mapping - maps emoji to raw resource name
         */
        private val ANIMAL_SOUND_FILES = mapOf(
            "🦁" to "sound_lion",
            "🐘" to "sound_elephant",
            "🐶" to "sound_dog",
            "🐱" to "sound_cat",
            "🐭" to "sound_mouse",
            "🐰" to "sound_rabbit",
            "🐦" to "sound_bird",
            "🐵" to "sound_monkey",
            "🐻" to "sound_bear",
            "🐴" to "sound_horse",
            "🐮" to "sound_cow",
            "🦒" to "sound_giraffe",
            "🐯" to "sound_tiger",
            "🦓" to "sound_zebra",
            "🐧" to "sound_penguin",
            "🦆" to "sound_duck",
            "🦉" to "sound_owl",
            "🦅" to "sound_eagle"
        )
        
        /**
         * Animal name mapping for TTS fallback - only Turkish names
         */
        private val ANIMAL_NAMES_TR = mapOf(
            "🦁" to "Aslan",
            "🐘" to "Fil",
            "🐶" to "Köpek",
            "🐱" to "Kedi",
            "🐭" to "Fare",
            "🐰" to "Tavşan",
            "🐦" to "Kuş",
            "🐟" to "Balık",
            "🦋" to "Kelebek",
            "🐮" to "İnek",
            "🐷" to "Domuz",
            "🐸" to "Kurbağa",
            "🐔" to "Tavuk",
            "🦆" to "Ördek",
            "🐴" to "At",
            "🐑" to "Koyun",
            "🦉" to "Baykuş",
            "🦅" to "Kartal",
            "🐝" to "Arı",
            "🐵" to "Maymun",
            "🐻" to "Ayı",
            "🦊" to "Tilki",
            "🦒" to "Zürafa",
            "🐯" to "Kaplan",
            "🦓" to "Zebra",
            "🐧" to "Penguen"
        )
    }
    
    /**
     * Play animal sound
     */
    fun playAnimalSound(animalEmoji: String) {
        if (!isEnabled) return
        
        soundMap[animalEmoji]?.let { soundId ->
            soundPool?.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f)
        }
    }
    
    /**
     * Check if animal has a sound file
     */
    fun hasAnimalSound(animalEmoji: String): Boolean {
        return soundMap.containsKey(animalEmoji)
    }
    
    /**
     * Get animal name in Turkish for TTS fallback
     */
    fun getAnimalNameTr(animalEmoji: String): String? {
        return ANIMAL_NAMES_TR[animalEmoji]
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
