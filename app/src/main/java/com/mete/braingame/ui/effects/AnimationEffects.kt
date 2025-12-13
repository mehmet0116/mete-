package com.mete.braingame.ui.effects

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * Pulsing animation for interactive elements
 */
@Composable
fun Modifier.pulseEffect(enabled: Boolean = true): Modifier {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )
    
    return if (enabled) this.scale(scale) else this
}

/**
 * Bounce animation for correct answers
 */
@Composable
fun Modifier.bounceEffect(trigger: Boolean): Modifier {
    val scale = remember { Animatable(1f) }
    
    LaunchedEffect(trigger) {
        if (trigger) {
            scale.animateTo(
                targetValue = 1.2f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            scale.animateTo(
                targetValue = 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }
    
    return this.scale(scale.value)
}

/**
 * Shake animation for wrong answers
 */
@Composable
fun Modifier.shakeEffect(trigger: Boolean): Modifier {
    val rotation = remember { Animatable(0f) }
    
    LaunchedEffect(trigger) {
        if (trigger) {
            for (i in 0..3) {
                rotation.animateTo(
                    targetValue = 5f,
                    animationSpec = tween(50)
                )
                rotation.animateTo(
                    targetValue = -5f,
                    animationSpec = tween(50)
                )
            }
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = tween(50)
            )
        }
    }
    
    return this.rotate(rotation.value)
}

/**
 * Glow effect for highlighted items
 */
@Composable
fun Modifier.glowEffect(enabled: Boolean = true, glowColor: androidx.compose.ui.graphics.Color): Modifier {
    val infiniteTransition = rememberInfiniteTransition(label = "glow")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )
    
    return if (enabled) {
        this.graphicsLayer(
            shadowElevation = 8f,
            alpha = alpha
        )
    } else {
        this
    }
}

/**
 * Floating animation for decorative elements
 */
@Composable
fun Modifier.floatEffect(): Modifier {
    val infiniteTransition = rememberInfiniteTransition(label = "float")
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -10f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY"
    )
    
    return this.offset(y = offsetY.dp)
}

/**
 * Particle data for confetti effect
 */
data class Particle(
    val id: Int,
    val x: Float,
    val y: Float,
    val velocityX: Float,
    val velocityY: Float,
    val color: androidx.compose.ui.graphics.Color,
    val emoji: String
)

/**
 * State for confetti particles
 */
@Composable
fun rememberConfettiState(): ConfettiState {
    return remember { ConfettiState() }
}

class ConfettiState {
    var particles by mutableStateOf<List<Particle>>(emptyList())
        private set
    
    fun triggerConfetti() {
        val emojis = listOf("⭐", "🎉", "✨", "💫", "🌟", "💥")
        val colors = listOf(
            androidx.compose.ui.graphics.Color(0xFFFFD700),
            androidx.compose.ui.graphics.Color(0xFFFF6B6B),
            androidx.compose.ui.graphics.Color(0xFF4ECDC4),
            androidx.compose.ui.graphics.Color(0xFF95E1D3),
            androidx.compose.ui.graphics.Color(0xFFF38181),
            androidx.compose.ui.graphics.Color(0xFFAA96DA)
        )
        
        particles = (0..30).map { i ->
            Particle(
                id = i,
                x = Random.nextFloat() * 100f,
                y = Random.nextFloat() * 50f,
                velocityX = (Random.nextFloat() - 0.5f) * 5f,
                velocityY = Random.nextFloat() * -10f,
                color = colors.random(),
                emoji = emojis.random()
            )
        }
    }
    
    fun clear() {
        particles = emptyList()
    }
}

/**
 * Spring-based enter animation
 */
@Composable
fun Modifier.springEnterAnimation(delay: Int = 0): Modifier {
    val scale = remember { Animatable(0f) }
    
    LaunchedEffect(Unit) {
        delay(delay.toLong())
        scale.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMedium
            )
        )
    }
    
    return this.scale(scale.value)
}

/**
 * Rotation animation for loading or emphasis
 */
@Composable
fun Modifier.rotateAnimation(): Modifier {
    val infiniteTransition = rememberInfiniteTransition(label = "rotate")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )
    
    return this.rotate(rotation)
}
