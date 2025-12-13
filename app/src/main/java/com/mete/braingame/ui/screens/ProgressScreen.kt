package com.mete.braingame.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mete.braingame.data.Achievement
import com.mete.braingame.data.CategoryProgress
import com.mete.braingame.data.UserProgress
import com.mete.braingame.ui.theme.*
import com.mete.braingame.ui.effects.springEnterAnimation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressScreen(
    userProgress: UserProgress,
    categoryNames: Map<String, String>,
    onBack: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("İstatistikler", "Rozetler", "Kategoriler")
    
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
            Column {
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
                    
                    Text(
                        text = "İlerleme Raporum",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Primary,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = null,
                        tint = Secondary,
                        modifier = Modifier.size(32.dp)
                    )
                }
                
                // Tab Row
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = Surface,
                    contentColor = Primary
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = { 
                                Text(
                                    text = title,
                                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
            }
        }
        
        // Content based on selected tab
        when (selectedTab) {
            0 -> StatisticsTab(userProgress)
            1 -> AchievementsTab(userProgress.achievements)
            2 -> CategoriesTab(userProgress.categoryProgress, categoryNames)
        }
    }
}

@Composable
fun StatisticsTab(userProgress: UserProgress) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Overall Stats Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .springEnterAnimation(0),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Genel İstatistikler",
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    StatRow("Toplam Puan", userProgress.totalScore.toString(), "⭐")
                    Spacer(modifier = Modifier.height(8.dp))
                    StatRow("Cevaplanan Sorular", userProgress.totalQuestionsAnswered.toString(), "❓")
                    Spacer(modifier = Modifier.height(8.dp))
                    StatRow("Doğru Cevaplar", userProgress.totalCorrectAnswers.toString(), "✅")
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    val accuracy = if (userProgress.totalQuestionsAnswered > 0) {
                        (userProgress.totalCorrectAnswers * 100.0 / userProgress.totalQuestionsAnswered).toInt()
                    } else 0
                    StatRow("Başarı Oranı", "%$accuracy", "📊")
                }
            }
        }
        
        item {
            // Streak Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .springEnterAnimation(100),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Secondary.copy(alpha = 0.1f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🔥 Seri",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${userProgress.currentStreak} Gün",
                        style = MaterialTheme.typography.displaySmall,
                        color = Secondary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "En Uzun: ${userProgress.longestStreak} Gün",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
            }
        }
        
        item {
            // Mastered Words
            val totalMasteredWords = userProgress.categoryProgress.values.sumOf { it.masteredWords.size }
            
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .springEnterAnimation(200),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE8F5E9)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "📚 Öğrenilen Kelimeler",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$totalMasteredWords Kelime",
                        style = MaterialTheme.typography.displaySmall,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun StatRow(label: String, value: String, emoji: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = emoji, fontSize = 24.sp)
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = TextPrimary
            )
        }
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = Secondary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AchievementsTab(achievements: List<Achievement>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(achievements) { achievement ->
            AchievementCard(achievement)
        }
    }
}

@Composable
fun AchievementCard(achievement: Achievement) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .springEnterAnimation(0),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (achievement.isUnlocked) 
                Color(0xFFFFD700).copy(alpha = 0.2f) 
            else 
                Color.Gray.copy(alpha = 0.1f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (achievement.isUnlocked) 6.dp else 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = achievement.icon,
                fontSize = 48.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = achievement.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if (achievement.isUnlocked) TextPrimary else TextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = achievement.description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = TextSecondary
            )
            
            if (achievement.isUnlocked) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFFFD700).copy(alpha = 0.3f)
                ) {
                    Text(
                        text = "✓ Kazanıldı",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF8F00),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CategoriesTab(
    categoryProgress: Map<String, CategoryProgress>,
    categoryNames: Map<String, String>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categoryProgress.entries.toList()) { (categoryId, progress) ->
            CategoryProgressCard(
                categoryName = categoryNames[categoryId] ?: categoryId,
                progress = progress
            )
        }
    }
}

@Composable
fun CategoryProgressCard(categoryName: String, progress: CategoryProgress) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .springEnterAnimation(0),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = categoryName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Primary
                )
                Text(
                    text = "${progress.correctAnswers}/${progress.completedQuestions}",
                    style = MaterialTheme.typography.titleSmall,
                    color = Secondary,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Progress bar
            val progressPercent = if (progress.totalQuestions > 0) {
                (progress.correctAnswers.toFloat() / progress.totalQuestions.toFloat())
            } else 0f
            
            LinearProgressIndicator(
                progress = { progressPercent },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = Secondary,
                trackColor = Secondary.copy(alpha = 0.2f)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "📚 ${progress.masteredWords.size} kelime öğrenildi",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }
    }
}
