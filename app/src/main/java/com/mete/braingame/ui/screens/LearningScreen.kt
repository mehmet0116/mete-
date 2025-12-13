package com.mete.braingame.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mete.braingame.ui.theme.*
import com.mete.braingame.ui.effects.bounceEffect
import kotlinx.coroutines.delay

/**
 * Learning item to teach before testing
 */
data class LearningItem(
    val emoji: String,
    val nameTr: String,
    val nameEn: String,
    val soundText: String? = null
)

@Composable
fun LearningScreen(
    categoryName: String,
    learningItems: List<LearningItem>,
    onComplete: () -> Unit,
    onBack: () -> Unit,
    onItemClick: (LearningItem) -> Unit,
    childName: String = "Arkadaşım" // Default to generic greeting
) {
    var currentPage by remember { mutableIntStateOf(0) }
    var showEncouragement by remember { mutableStateOf(false) }
    
    val itemsPerPage = 4
    val totalPages = (learningItems.size + itemsPerPage - 1) / itemsPerPage
    val currentItems = learningItems.drop(currentPage * itemsPerPage).take(itemsPerPage)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        // Header
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Surface,
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Geri",
                        tint = Primary
                    )
                }
                
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Öğrenelim! 📚",
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = categoryName,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
                
                // Progress indicator
                Surface(
                    shape = CircleShape,
                    color = Secondary.copy(alpha = 0.1f),
                    modifier = Modifier.size(56.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "📖", fontSize = 20.sp)
                        Text(
                            text = "${currentPage + 1}/$totalPages",
                            style = MaterialTheme.typography.bodySmall,
                            color = Secondary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        
        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Instruction card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Hadi birlikte öğrenelim $childName! 🌟",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Primary,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Her bir resme dokunarak sesini duyabilirsin",
                            style = MaterialTheme.typography.bodyLarge,
                            color = TextSecondary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Learning items grid
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(currentItems) { item ->
                        LearningItemCard(
                            item = item,
                            onClick = {
                                onItemClick(item)
                                showEncouragement = true
                            }
                        )
                    }
                }
                
                // Encouragement message
                AnimatedVisibility(
                    visible = showEncouragement,
                    enter = fadeIn(animationSpec = tween(300)),
                    exit = fadeOut(animationSpec = tween(300))
                ) {
                    LaunchedEffect(Unit) {
                        delay(2000)
                        showEncouragement = false
                    }
                    
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = CardDefaults.cardColors(containerColor = Secondary.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Aferin $childName! Çok iyi dinliyorsun! 👏",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge,
                            color = Secondary,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            
            // Navigation buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Previous button
                if (currentPage > 0) {
                    Button(
                        onClick = { currentPage-- },
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Önceki"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Önceki",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                // Next/Start button
                Button(
                    onClick = {
                        if (currentPage < totalPages - 1) {
                            currentPage++
                        } else {
                            onComplete()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (currentPage == totalPages - 1) Secondary else Primary
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = if (currentPage == totalPages - 1) "Başla! 🎯" else "Sonraki",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (currentPage < totalPages - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Sonraki"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LearningItemCard(
    item: LearningItem,
    onClick: () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    
    Card(
        onClick = {
            isPressed = true
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .bounceEffect(isPressed),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Surface),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isPressed) 8.dp else 4.dp
        )
    ) {
        LaunchedEffect(isPressed) {
            if (isPressed) {
                delay(300)
                isPressed = false
            }
        }
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Emoji
            Text(
                text = item.emoji,
                fontSize = 64.sp,
                modifier = Modifier.padding(8.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Turkish name
            Text(
                text = item.nameTr,
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            
            // English name
            Text(
                text = item.nameEn,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )
        }
    }
}
