package com.mete.braingame.util

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class VoiceManager(context: Context) {
    private var textToSpeech: TextToSpeech? = null
    private var soundPool: SoundPool? = null
    private val soundMap = mutableMapOf<String, Int>()
    private var isInitialized = false
    
    init {
        initializeTTS(context)
        initializeSoundPool(context)
    }
    
    private fun initializeTTS(context: Context) {
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = textToSpeech?.setLanguage(Locale("tr", "TR"))
                if (result == TextToSpeech.LANG_MISSING_DATA || 
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    // Fallback to default language
                    textToSpeech?.language = Locale.getDefault()
                }
                isInitialized = true
            }
        }
        
        textToSpeech?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                // Voice started
            }
            
            override fun onDone(utteranceId: String?) {
                // Voice finished
            }
            
            override fun onError(utteranceId: String?) {
                // Voice error
            }
        })
    }
    
    private fun initializeSoundPool(context: Context) {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        
        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .setAudioAttributes(audioAttributes)
            .build()
    }
    
    fun speak(text: String, utteranceId: String = "default") {
        if (isInitialized) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        }
    }
    
    fun playSound(soundRes: String) {
        // In a real app, you would load sounds from resources
        // For now, we'll just speak the sound name
        speak("Ses: $soundRes")
    }
    
    fun speakWelcome() {
        speak("Selam Mete! Hadi birlikte öğrenelim!")
    }
    
    fun speakCorrect() {
        speak("Bravo Mete! Doğru cevap!")
    }
    
    fun speakWrong() {
        speak("Tekrar deneyelim, olacak!")
    }
    
    fun speakEncouragement() {
        speak("Süpersin Mete! Çok iyi gidiyorsun!")
    }
    
    fun stop() {
        textToSpeech?.stop()
        soundPool?.release()
        soundPool = null
        textToSpeech?.shutdown()
        textToSpeech = null
    }
}