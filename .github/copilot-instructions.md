# GitHub Copilot Instructions for Mete's Brain Game

## Project Overview
This repository contains an educational Android game for Turkish preschool children. The app uses Kotlin, Jetpack Compose, and follows Material Design 3 guidelines.

## Primary Goals
1. Create engaging educational games for children aged 3-6
2. Develop cognitive skills through interactive play
3. Teach basic concepts in Turkish (numbers, colors, animals, etc.)
4. Provide positive reinforcement and encouragement

## Technical Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design System**: Material Design 3
- **Architecture**: MVVM with ViewModel
- **Minimum SDK**: 24 (Android 7.0)
- **Build System**: Gradle with Kotlin DSL

## When Assisting with This Project

### 1. Code Generation
- Generate Compose UI code following Material Design 3
- Create ViewModel classes with state management
- Implement game logic for educational activities
- Add Turkish string resources
- Include audio feedback implementations

### 2. Code Review Suggestions
- Suggest improvements for child-friendly UI
- Recommend accessibility enhancements
- Identify performance optimizations
- Suggest better state management patterns
- Recommend testing strategies

### 3. Problem Solving
- Help with Compose performance issues
- Assist with audio playback challenges
- Solve navigation problems
- Address memory management concerns
- Help with Turkish text-to-speech implementation

### 4. Best Practices
- Follow Android development best practices
- Implement proper error handling
- Use resource management efficiently
- Follow security guidelines
- Implement proper lifecycle management

## Special Instructions for Different File Types

### Kotlin Files (.kt)
- Use descriptive function names in English
- Add KDoc comments for public APIs
- Use data classes for models
- Implement proper error handling
- Use coroutines for async operations

### Compose Files
- Use `@Preview` annotations
- Extract reusable components
- Use `Modifier` for styling
- Implement proper state hoisting
- Use theme values from MaterialTheme

### Resource Files
- Use Turkish strings in `strings.xml`
- Define colors in `colors.xml` or `Color.kt`
- Use vector drawables where possible
- Provide multiple density assets

### Gradle Files
- Keep dependencies updated
- Use version catalogs if possible
- Configure proper signing configs
- Optimize build configurations

## Common Tasks & Solutions

### Adding a New Game Category
1. Add category to `GameData.kt`
2. Create questions in Turkish
3. Add images/sounds for the category
4. Update category selection screen
5. Implement game logic for the category

### Implementing Audio Feedback
1. Use `TextToSpeech` for Turkish narration
2. Use `SoundPool` for sound effects
3. Preload audio resources
4. Handle audio focus properly
5. Provide volume controls

### Improving Performance
1. Use `LazyColumn`/`LazyRow` for lists
2. Cache expensive computations
3. Use `remember` for stable values
4. Implement image loading with Coil
5. Use profiling tools to identify bottlenecks

## Quality Standards
- All code must compile without errors
- UI must be responsive and smooth
- Audio must play correctly
- Games must be educationally sound
- App must be stable and crash-free

## Testing Requirements
- Unit tests for ViewModel logic
- UI tests for critical flows
- Audio playback tests
- Performance testing on low-end devices
- Accessibility testing with TalkBack

## When in Doubt
1. Refer to Material Design 3 guidelines
2. Check Android developer documentation
3. Look at existing code patterns in the project
4. Prioritize simplicity and clarity
5. Consider the target audience (young children)