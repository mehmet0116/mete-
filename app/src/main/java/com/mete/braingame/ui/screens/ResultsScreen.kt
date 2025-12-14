package com.mete.braingame.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultsScreen(
    score: Int,
    onPlayAgain: () -> Unit,
    onExit: () -> Unit
) {
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
                
                // Star rating based on score
                val stars = when {
                    score >= 8 -> "⭐⭐⭐"
                    score >= 5 -> "⭐⭐"
                    else -> "⭐"
                }
                
                Text(
                    text = stars,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = when {
                score >= 8 -> "Harika iş çıkardın Mete! Sen bir dahisin! 🧠"
                score >= 5 -> "Çok iyi gidiyorsun Mete! Devam et! 👍"
                else -> "İyi denemeydi Mete! Tekrar deneyelim! 💪"
            },
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