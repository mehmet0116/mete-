package com.mete.braingame.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class VoiceManager(private val context: Context) {
    private var textToSpeech: TextToSpeech? = null
    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    init {
        initializeTTS()
    }

    private fun initializeTTS() {
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = textToSpeech?.setLanguage(Locale("tr", "TR"))
                if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED
                ) {
                    // Fallback to default language
                    textToSpeech?.language = Locale.getDefault()
                }
                
                textToSpeech?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        _isSpeaking.value = true
                    }

                    override fun onDone(utteranceId: String?) {
                        _isSpeaking.value = false
                    }

                    override fun onError(utteranceId: String?) {
                        _isSpeaking.value = false
                    }
                })
            }
        }
    }

    fun speak(text: String) {
        textToSpeech?.let { tts ->
            if (!tts.isSpeaking) {
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "METE_VOICE")
            }
        }
    }

    fun stop() {
        textToSpeech?.stop()
        _isSpeaking.value = false
    }

    fun greetUser(userName: String = "Mete") {
        speak("Selam $userName! Hadi birlikte öğrenelim!")
    }

    fun giveEncouragement(userName: String = "Mete") {
        val encouragements = listOf(
            "Bravo $userName!",
            "Süpersin $userName!",
            "Harikasın $userName!",
            "Çok iyi $userName!",
            "Mükemmel $userName!"
        )
        speak(encouragements.random())
    }

    fun cleanup() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
    }
}