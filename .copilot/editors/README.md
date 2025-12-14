# Editor-Specific Instructions

## Android Studio / IntelliJ IDEA

### Live Templates
Consider creating live templates for:
- New Compose screen
- New ViewModel
- New data class
- New Composable function

### Code Style
- Use Kotlin style guide
- 4-space indentation
- Max line length: 100 characters
- Use trailing commas in multiline expressions

### Useful Plugins
- Kotlin plugin (built-in)
- Compose plugin (built-in)
- Git integration
- Database tools (if using Room)

## VS Code

### Extensions
- Kotlin Language
- Android SDK Manager
- Compose Preview (if available)
- GitLens

### Settings
```json
{
  "editor.formatOnSave": true,
  "kotlin.codeStyle": "official",
  "files.exclude": {
    "**/.gradle": true,
    "**/build": true
  }
}
```

## General Editor Tips

### Navigation
- Use `Ctrl/Cmd + Click` to navigate to definitions
- Use `Ctrl/Cmd + B` to find usages
- Use structure view to understand file organization

### Refactoring
- Extract function/composable
- Rename symbols
- Change signature
- Move members between files

### Debugging
- Use Compose preview for UI debugging
- Use Logcat for runtime debugging
- Use breakpoints for complex logic
- Use profiler for performance issues

## Project-Specific Editor Configuration

### Compose Preview
```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewGameScreen() {
    MaterialTheme {
        GameScreen(
            viewModel = remember { GameViewModel() },
            onNavigate = {}
        )
    }
}
```

### Run Configurations
- Main app configuration
- Unit test configurations
- UI test configurations
- Benchmark configurations (if needed)

### Build Variants
- Debug (with logging, debugging enabled)
- Release (optimized, minified)
- Staging (if needed for testing)