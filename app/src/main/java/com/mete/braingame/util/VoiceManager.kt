package com.mete.braingame.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class VoiceManager(context: Context) : TextToSpeech.OnInitListener {
    
    private var textToSpeech: TextToSpeech? = null
    private var isInitialized = false
    
    private val _voiceState = MutableStateFlow(VoiceState())
    val voiceState: StateFlow<VoiceState> = _voiceState.asStateFlow()
    
    init {
        textToSpeech = TextToSpeech(context, this)
    }
    
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech?.setLanguage(Locale("tr", "TR"))
            
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED) {
                _voiceState.value = VoiceState(error = "Türkçe dil desteği yüklenemedi")
            } else {
                isInitialized = true
                _voiceState.value = VoiceState(isReady = true)
                
                // Ses ilerleme dinleyicisi
                textToSpeech?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        _voiceState.value = VoiceState(isSpeaking = true, isReady = true)
                    }
                    
                    override fun onDone(utteranceId: String?) {
                        _voiceState.value = VoiceState(isSpeaking = false, isReady = true)
                    }
                    
                    override fun onError(utteranceId: String?) {
                        _voiceState.value = VoiceState(isSpeaking = false, isReady = true, error = "Ses çalma hatası")
                    }
                })
            }
        } else {
            _voiceState.value = VoiceState(error = "TextToSpeech başlatılamadı")
        }
    }
    
    fun speak(text: String, utteranceId: String = "default") {
        if (isInitialized) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        }
    }
    
    fun speakWithGreeting(name: String = "Mete") {
        speak("Selam $name! Hadi birlikte öğrenelim!")
    }
    
    fun speakEncouragement(name: String = "Mete") {
        val encouragements = listOf(
            "Bravo $name!",
            "Süpersin $name!",
            "Harikasın $name!",
            "Çok iyiydi $name!",
            "Mükemmelsin $name!"
        )
        speak(encouragements.random())
    }
    
    fun speakCorrect() {
        speak("Doğru! Çok iyi!")
    }
    
    fun speakWrong() {
        speak("Tekrar deneyelim, pes etme!")
    }
    
    fun stop() {
        textToSpeech?.stop()
        _voiceState.value = VoiceState(isSpeaking = false, isReady = true)
    }
    
    fun shutdown() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        isInitialized = false
    }
    
    fun setSpeechRate(rate: Float = 0.9f) {
        textToSpeech?.setSpeechRate(rate)
    }
    
    fun setPitch(pitch: Float = 1.1f) {
        textToSpeech?.setPitch(pitch)
    }
}

data class VoiceState(
    val isReady: Boolean = false,
    val isSpeaking: Boolean = false,
    val error: String? = null
)