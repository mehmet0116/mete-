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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mete.braingame.R
import com.mete.braingame.ui.theme.PrimaryColor
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(
    navController: NavController,
    onVoiceWelcome: () -> Unit = {}
) {
    // Uygulama açıldığında sesli hoşgeldin mesajı
    LaunchedEffect(Unit) {
        delay(500) // Kısa bir gecikme
        onVoiceWelcome()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF6A11CB),
                        Color(0xFF2575FC)
                    )
                )
            )
    ) {
        // Arka plan dekorasyonları
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Sol üst dekorasyon
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.TopStart)
                    .background(
                        color = Color.White.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(24.dp)
                    )
            )

            // Sağ alt dekorasyon
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.BottomEnd)
                    .background(
                        color = Color.White.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(32.dp)
                    )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Başlık ikonu
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.White.copy(alpha = 0.2f))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "🧠",
                    fontSize = 60.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Hoşgeldin başlığı
            Text(
                text = stringResource(R.string.welcome_title),
                style = MaterialTheme.typography.displaySmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Alt başlık
            Text(
                text = stringResource(R.string.welcome_subtitle),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Medium,
                    color = Color.White.copy(alpha = 0.9f)
                ),
                textAlign = TextAlign.Center,
                lineHeight = 28.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Başla butonu
            Button(
                onClick = {
                    navController.navigate("category")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 4.dp
                )
            ) {
                Text(
                    text = stringResource(R.string.start_button),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Eğitici ikonlar
            RowWithIcons()
        }
    }
}

@Composable
fun RowWithIcons() {
    androidx.compose.foundation.layout.Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        listOf("🦁", "🔢", "⭐", "🎨", "📝", "🍎").forEach { icon ->
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 24.sp
                )
            }
        }
    }
}