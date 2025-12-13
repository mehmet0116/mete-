package com.mete.braingame.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mete.braingame.data.Question
import com.mete.braingame.ui.theme.*
import com.mete.braingame.ui.effects.bounceEffect
import com.mete.braingame.ui.effects.shakeEffect
import com.mete.braingame.ui.effects.springEnterAnimation
import kotlinx.coroutines.delay

@Composable
fun GameScreen(
    questions: List<Question>,
    categoryName: String,
    onFinish: (score: Int, total: Int) -> Unit,
    onBack: () -> Unit,
    onQuestionVoice: (String) -> Unit,
    onCorrectVoice: () -> Unit,
    onWrongVoice: () -> Unit,
    onItemClick: ((String) -> Unit)? = null
) {
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableIntStateOf(-1) }
    var showFeedback by remember { mutableStateOf(false) }
    
    val currentQuestion = questions.getOrNull(currentQuestionIndex)
    val progress = (currentQuestionIndex + 1).toFloat() / questions.size.toFloat()
    
    LaunchedEffect(currentQuestionIndex) {
        currentQuestion?.voice?.let { voice ->
            delay(500)
            onQuestionVoice(voice)
        }
    }
    
    LaunchedEffect(selectedAnswer) {
        if (selectedAnswer >= 0 && currentQuestion != null) {
            showFeedback = true
            val isCorrect = selectedAnswer == currentQuestion.correctAnswer
            
            if (isCorrect) {
                score++
                onCorrectVoice()
            } else {
                onWrongVoice()
            }
            
            delay(2000)
            
            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                selectedAnswer = -1
                showFeedback = false
            } else {
                onFinish(score, questions.size)
            }
        }
    }
    
    if (currentQuestion == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        // Header with back button, category name, and score
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
                // Back button
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Geri",
                        tint = Primary
                    )
                }
                
                // Category and question info
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = categoryName,
                        style = MaterialTheme.typography.titleMedium,
                        color = Primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Soru ${currentQuestionIndex + 1} / ${questions.size}",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                }
                
                // Score badge
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
                        Text(text = "⭐", fontSize = 16.sp)
                        Text(
                            text = score.toString(),
                            style = MaterialTheme.typography.titleMedium,
                            color = Secondary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        
        // Progress bar
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = Primary,
            trackColor = Primary.copy(alpha = 0.2f)
        )
        
        // Question content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Question section
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                
                // Question text
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
                            text = currentQuestion.question,
                            style = MaterialTheme.typography.headlineSmall,
                            color = TextPrimary,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        
                        if (currentQuestion.questionEn.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = currentQuestion.questionEn,
                                style = MaterialTheme.typography.bodyLarge,
                                color = TextSecondary,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                
                // Pattern items (if applicable)
                if (currentQuestion.items.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    // Use FlowRow to avoid horizontal scrolling
                    androidx.compose.foundation.layout.FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        currentQuestion.items.forEach { item ->
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = Primary.copy(alpha = 0.1f),
                                modifier = Modifier
                                    .size(64.dp)
                                    .bounceEffect(false)
                                    .clickable(
                                        enabled = onItemClick != null,
                                        indication = null,
                                        interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }
                                    ) {
                                        onItemClick?.invoke(item)
                                    }
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(
                                        text = item,
                                        fontSize = 32.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
            
            // Answer options
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsIndexed(currentQuestion.options) { index, option ->
                    AnswerButton(
                        text = option,
                        isSelected = selectedAnswer == index,
                        isCorrect = index == currentQuestion.correctAnswer,
                        showFeedback = showFeedback,
                        enabled = selectedAnswer < 0,
                        onClick = { selectedAnswer = index }
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun AnswerButton(
    text: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    showFeedback: Boolean,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        showFeedback && isSelected && isCorrect -> CorrectAnswer
        showFeedback && isSelected && !isCorrect -> WrongAnswer
        showFeedback && isCorrect -> CorrectAnswer.copy(alpha = 0.3f)
        isSelected -> Primary
        else -> Surface
    }
    
    val textColor = when {
        showFeedback && (isSelected || isCorrect) -> Color.White
        isSelected -> Color.White
        else -> TextPrimary
    }
    
    // Trigger animations based on feedback
    val shouldBounce = showFeedback && isSelected && isCorrect
    val shouldShake = showFeedback && isSelected && !isCorrect
    
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .bounceEffect(shouldBounce)
            .shakeEffect(shouldShake)
            .springEnterAnimation(0),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 8.dp else 4.dp
        ),
        enabled = enabled
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge,
                color = textColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 28.sp
            )
        }
    }
}
