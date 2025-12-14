package com.mete.braingame.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class VoiceManager(context: Context) {
    private var tts: TextToSpeech? = null

    init {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale("tr", "TR")
            }
        }
    }

    fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "vm_${System.currentTimeMillis()}")
    }
    
    fun speakQueued(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_ADD, null, "vm_${System.currentTimeMillis()}")
    }

    fun stop() {
        tts?.stop()
    }

    fun greetUser(name: String) {
        speak("Merhaba $name! Hadi birlikte öğrenelim!")
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}