# Patterns for GitHub Copilot to Ignore or Avoid

## Code Patterns to Avoid

### 1. Platform-Specific Code
```kotlin
// ❌ AVOID: Platform-specific implementations
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    // Don't write version-specific code without fallbacks
}

// ✅ PREFER: Use compatibility libraries
val notificationManager = NotificationManagerCompat.from(context)
```

### 2. Hardcoded Values
```kotlin
// ❌ AVOID: Hardcoded dimensions, strings, colors
Text("Bravo Mete!", fontSize = 24.sp, color = Color(0xFF4CAF50))

// ✅ PREFER: Use resources
Text(
    text = stringResource(R.string.congratulations_message),
    fontSize = MaterialTheme.typography.titleMedium.fontSize,
    color = MaterialTheme.colorScheme.primary
)
```

### 3. Complex Business Logic in Composables
```kotlin
// ❌ AVOID: Business logic in UI
@Composable
fun GameScreen() {
    val score = remember { mutableStateOf(0) }
    
    Button(onClick = {
        // Complex game logic here ❌
        score.value = calculateScore(answers)
    }) {
        Text("Submit")
    }
}

// ✅ PREFER: Delegate to ViewModel
@Composable
fun GameScreen(viewModel: GameViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    
    Button(onClick = { viewModel.submitAnswer() }) {
        Text("Submit")
    }
}
```

## File Patterns

### Files to Focus On:
- `app/src/main/java/com/mete/braingame/` - Main source code
- `app/src/main/res/` - Resources
- `app/src/main/AndroidManifest.xml` - App configuration

### Files to Generally Avoid Modifying:
- `build.gradle.kts` (unless specifically requested)
- `.gitignore`
- `gradle/` directory files
- Generated files in `build/` directory

## Context-Specific Guidance

### For Game Content:
- Focus on Turkish educational content
- Use simple, clear Turkish for children
- Include positive reinforcement
- Ensure cultural appropriateness

### For UI Components:
- Use Material Design 3 components
- Ensure touch targets are at least 48dp
- Use high contrast for readability
- Include visual feedback for interactions

### For Audio:
- Prefer Turkish audio feedback
- Use real recordings where possible
- Include volume controls
- Handle audio focus changes

## Testing Considerations
- Write tests for game logic
- Test audio playback
- Test on different screen sizes
- Test with TalkBack for accessibility

## Performance Considerations
- Lazy load images and sounds
- Use `remember` to avoid recomposition
- Clean up resources in `DisposableEffect`
- Use `LaunchedEffect` for async operations