package com.mete.braingame.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mete.braingame.util.VoiceManager

@Composable
fun ResultsScreen(
    score: Int,
    correctAnswers: Int,
    totalQuestions: Int,
    voiceManager: VoiceManager,
    onPlayAgain: () -> Unit,
    onExit: () -> Unit
) {
    // Calculate stars and feedback message
    val percentage = if (totalQuestions > 0) (correctAnswers.toFloat() / totalQuestions) * 100 else 0f
    val stars = when {
        percentage >= 80f -> "⭐⭐⭐"
        percentage >= 60f -> "⭐⭐"
        else -> "⭐"
    }
    
    val feedbackMessage = when {
        percentage >= 80f -> "Harika iş çıkardın Mete! Sen bir dahisin!"
        percentage >= 60f -> "Çok iyi gidiyorsun Mete! Devam et!"
        else -> "İyi denemeydi Mete! Tekrar deneyelim!"
    }
    
    // Speak the results
    LaunchedEffect(Unit) {
        voiceManager.speak("Oyun bitti! $totalQuestions sorudan $correctAnswers tanesini doğru cevapladın. $feedbackMessage")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "🎉 Oyun Bitti!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Card(
            modifier = Modifier.width(200.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Puanın",
                    fontSize = 18.sp
                )
                
                Text(
                    text = "$score",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "$correctAnswers / $totalQuestions doğru",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Text(
                    text = stars,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = feedbackMessage,
            fontSize = 18.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.width(200.dp)
        ) {
            Button(
                onClick = onPlayAgain,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Tekrar Oyna", fontSize = 18.sp)
            }
            
            OutlinedButton(
                onClick = onExit,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Çıkış", fontSize = 18.sp)
            }
        }
    }
}