package com.mete.braingame.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mete.braingame.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun ResultsScreen(
    score: Int,
    total: Int,
    onPlayAgain: () -> Unit,
    onBackToCategories: () -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }
    var showStars by remember { mutableStateOf(false) }
    
    val percentage = (score.toFloat() / total.toFloat() * 100).toInt()
    val starCount = when {
        percentage >= 90 -> 3
        percentage >= 70 -> 2
        percentage >= 50 -> 1
        else -> 0
    }
    
    val message = when {
        percentage >= 90 -> "Mükemmel Mete! 🌟"
        percentage >= 70 -> "Harika İş Mete! 🎉"
        percentage >= 50 -> "İyi İş Mete! 👏"
        else -> "Devam Et Mete! 💪"
    }
    
    val emoji = when {
        percentage >= 90 -> "🎉"
        percentage >= 70 -> "😊"
        percentage >= 50 -> "👍"
        else -> "💪"
    }
    
    LaunchedEffect(Unit) {
        delay(300)
        isVisible = true
        delay(500)
        showStars = true
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Primary.copy(alpha = 0.1f),
                        Background
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn() + scaleIn()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Trophy/Emoji
                Text(
                    text = emoji,
                    fontSize = 80.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                
                // Congratulations message
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Tebrikler Mete!",
                        style = MaterialTheme.typography.headlineLarge,
                        color = TextPrimary,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = message,
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                }
                
                // Score card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Stars
                        AnimatedVisibility(
                            visible = showStars,
                            enter = fadeIn() + scaleIn()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                repeat(3) { index ->
                                    StarIcon(
                                        isFilled = index < starCount,
                                        delay = index * 200L
                                    )
                                }
                            }
                        }
                        
                        // Score text
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Puanın",
                                style = MaterialTheme.typography.titleMedium,
                                color = TextSecondary
                            )
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    text = score.toString(),
                                    style = MaterialTheme.typography.displayLarge,
                                    color = Primary,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Text(
                                    text = " / $total",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = TextSecondary,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                            }
                            
                            // Percentage
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Primary.copy(alpha = 0.1f),
                                modifier = Modifier.padding(top = 8.dp)
                            ) {
                                Text(
                                    text = "%$percentage Doğru",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Primary,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(
                                        horizontal = 16.dp,
                                        vertical = 8.dp
                                    )
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Action buttons
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = onPlayAgain,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Primary
                        ),
                        shape = RoundedCornerShape(28.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 6.dp
                        )
                    ) {
                        Text(
                            text = "🔄 Tekrar Oyna",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    OutlinedButton(
                        onClick = onBackToCategories,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Primary
                        )
                    ) {
                        Text(
                            text = "📚 Kategorilere Dön",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StarIcon(isFilled: Boolean, delay: Long) {
    var isVisible by remember { mutableStateOf(false) }
    
    LaunchedEffect(isFilled) {
        if (isFilled) {
            delay(delay)
            isVisible = true
        }
    }
    
    val scale by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "star_scale"
    )
    
    Surface(
        shape = CircleShape,
        color = if (isFilled) Secondary.copy(alpha = 0.2f) else Color.Transparent,
        modifier = Modifier
            .padding(4.dp)
            .size(64.dp)
            .scale(scale)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = if (isFilled) "⭐" else "☆",
                fontSize = 40.sp
            )
        }
    }
}
