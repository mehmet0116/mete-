package com.mete.braingame.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mete.braingame.R
import com.mete.braingame.ui.theme.PrimaryColor
import com.mete.braingame.ui.theme.SecondaryColor
import com.mete.braingame.util.VoiceManager

@Composable
fun WelcomeScreen(
    navController: NavController,
    voiceManager: VoiceManager
) {
    // Hoşgeldin sesini çal
    LaunchedEffect(Unit) {
        voiceManager.speak("Mete hoşgeldin! Hadi oyun oynayalım!")
    }
    
    // Lottie animasyonu
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.welcome_animation)
    )
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF9F9),
                        Color(0xFFFFF0F5)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Başlık - "Mete Hoşgeldin!"
            Text(
                text = "Mete Hoşgeldin!",
                style = MaterialTheme.typography.displayLarge,
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            // Alt başlık
            Text(
                text = "5 yaşındaki çocuklar için eğitici oyunlar",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            
            // Animasyonlu görsel
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = Int.MAX_VALUE,
                    modifier = Modifier.fillMaxSize()
                )
            }
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Oyuna Başla Butonu
            Button(
                onClick = {
                    voiceManager.speak("Hadi kategori seçelim!")
                    navController.navigate("category")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Oyuna Başla",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Eğitici bilgi
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE8F5E9))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "🎯 Oyunun Faydaları:",
                        style = MaterialTheme.typography.headlineSmall,
                        color = SecondaryColor,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "• Dikkat gelişimi\n• Hafıza güçlendirme\n• Görsel algı\n• Dil becerileri",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF555555)
                    )
                }
            }
        }
    }
}