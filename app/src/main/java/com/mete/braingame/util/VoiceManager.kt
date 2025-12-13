package com.mete.braingame.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

/**
 * Text-to-Speech manager for voice feedback
 */
class VoiceManager(context: Context) {
    private var textToSpeech: TextToSpeech? = null
    private var isInitialized = false
    private var isEnabled = true
    
    init {
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.let { tts ->
                    val result = tts.setLanguage(Locale("tr", "TR"))
                    isInitialized = result != TextToSpeech.LANG_MISSING_DATA && 
                                   result != TextToSpeech.LANG_NOT_SUPPORTED
                }
            }
        }
    }
    
    fun speak(text: String, language: String = "tr-TR") {
        if (!isEnabled || !isInitialized) return
        
        textToSpeech?.stop()
        
        val locale = when (language) {
            "en-US" -> Locale.US
            else -> Locale("tr", "TR")
        }
        
        textToSpeech?.language = locale
        textToSpeech?.setSpeechRate(0.9f)
        textToSpeech?.setPitch(1.1f)
        textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
    
    fun speakTurkish(text: String) {
        speak(text, "tr-TR")
    }
    
    fun speakEnglish(text: String) {
        speak(text, "en-US")
    }
    
    fun stop() {
        textToSpeech?.stop()
    }
    
    fun toggle() {
        isEnabled = !isEnabled
        if (!isEnabled) {
            stop()
        }
    }
    
    fun isEnabled(): Boolean = isEnabled
    
    fun shutdown() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
    }
}
