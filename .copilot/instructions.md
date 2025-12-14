# Repository Instructions for GitHub Copilot

## Project Context
This is "Mete's Brain Game" - an educational Android app for Turkish preschool children. The app helps develop cognitive skills through interactive games in various categories (animals, numbers, shapes, colors, etc.).

## Coding Guidelines

### 1. Language & Framework
- Use **Kotlin** with modern syntax (coroutines, extension functions)
- Use **Jetpack Compose** for UI (no XML layouts)
- Follow **Material Design 3** guidelines
- Target **Android SDK 24+** (Android 7.0 Nougat)

### 2. Architecture
- **MVVM pattern** with ViewModel
- **Single Activity** architecture
- Use **Compose Navigation** for screen management
- Separate concerns: UI, Business Logic, Data layers

### 3. Code Structure
```kotlin
// Example structure for screens
@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel(),
    onNavigate: (String) -> Unit
) {
    // UI code here
}

// Example ViewModel
class GameViewModel : ViewModel() {
    private val _uiState = mutableStateOf(GameUiState())
    val uiState: State<GameUiState> = _uiState
    
    fun handleAction(action: GameAction) {
        // Business logic
    }
}
```

### 4. UI/UX Requirements
- Child-friendly interface with large buttons
- Bright, engaging colors from Material Design 3
- Smooth animations for engagement
- Audio feedback for all interactions
- Turkish language throughout
- Positive reinforcement messages

### 5. Game Logic
- Categories: Animals, Numbers, Shapes, Colors, Fruits, Vegetables, Body Parts, Movements, Time
- Each category has learning mode and test mode
- Score tracking with star ratings (1-3 stars)
- Progress persistence (consider using DataStore)

### 6. Audio Implementation
- Use `TextToSpeech` for Turkish voice feedback
- Use `SoundPool` for real animal sounds
- Preload sounds for smooth playback
- Handle audio focus properly

### 7. Resource Management
- Use string resources for all text (`strings.xml`)
- Define colors in theme (`Color.kt`)
- Use vector drawables where possible
- Optimize images for different densities

### 8. Testing
- Write unit tests for ViewModel logic
- UI tests for critical user flows
- Test audio playback functionality
- Test on different screen sizes

## Common Patterns to Use

### State Management
```kotlin
data class GameUiState(
    val currentQuestion: Question? = null,
    val score: Int = 0,
    val isPlaying: Boolean = false,
    val selectedCategory: Category? = null
)

sealed class GameAction {
    data class SelectCategory(val category: Category) : GameAction()
    object StartGame : GameAction()
    data class AnswerQuestion(val answer: String) : GameAction()
}
```

### Navigation
```kotlin
sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object CategorySelection : Screen("category")
    object Game : Screen("game/{categoryId}")
    object Results : Screen("results/{score}")
}
```

### Audio Helper
```kotlin
class VoiceManager(context: Context) {
    private val tts: TextToSpeech
    
    init {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale("tr", "TR")
            }
        }
    }
    
    fun speakTurkish(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}
```

## Do's and Don'ts

### ✅ DO:
- Use Compose's `remember` and `mutableStateOf` for state
- Extract reusable Composable functions
- Use `LaunchedEffect` for side effects
- Handle configuration changes properly
- Add loading states for async operations
- Use `Modifier` for styling and behavior
- Follow accessibility guidelines

### ❌ DON'T:
- Don't use deprecated APIs
- Don't block UI thread with long operations
- Don't hardcode strings or dimensions
- Don't ignore lifecycle events
- Don't use global singletons for ViewModels
- Don't forget to release audio resources

## Project-Specific Notes
- The app is named after "Mete" - use personalized greetings
- All educational content is in Turkish
- Real animal sounds are provided (not synthesized)
- Focus on positive learning experience
- Games should be challenging but achievable for ages 3-6

## When Writing Code for This Project
1. Consider the target audience (young children)
2. Prioritize simplicity and clarity
3. Ensure all interactions have visual and audio feedback
4. Use encouraging language in Turkish
5. Follow Material Design 3 for consistent UI
6. Optimize for performance on low-end devices