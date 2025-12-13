# Mete's Brain Game - Educational Android App 🧠🎮

A comprehensive educational Android game designed specifically for children to develop cognitive skills while learning English and having fun. This native Android application features pattern recognition, counting, shapes, colors, letters, and more with beautiful Material Design 3 UI and Jetpack Compose!

## Features ✨

- **📱 Native Android App**: Built with Kotlin and Jetpack Compose for superior performance
- **Personalized Experience**: Designed specifically for Mete with personalized greetings and feedback
- **Voice Feedback**: Text-to-speech support in Turkish and English
- **Multiple Categories**:
  - 🦁 Animals (Hayvanlar)
  - 🔢 Numbers (Sayılar)
  - ⭐ Shapes (Şekiller)
  - 🎨 Colors (Renkler)
  - 📝 Letters (Harfler)
  - 🍎 Fruits (Meyveler)
- **Various Game Types**:
  - Pattern Recognition
  - Counting Games
  - Quiz Questions
  - English Vocabulary Learning
- **Beautiful UI**: Material Design 3 with smooth animations and transitions
- **Progress Tracking**: Score system with encouraging feedback
- **Optimized for Phones**: Portrait orientation with child-friendly touch targets

## Technology Stack 💻

- **Kotlin** - Modern, concise, and safe programming language
- **Jetpack Compose** - Modern Android UI toolkit
- **Material Design 3** - Latest design system from Google
- **Android SDK** - Native Android development
- **Text-to-Speech API** - Voice feedback in Turkish and English
- **ViewModel** - MVVM architecture for state management
- **Compose Navigation** - Screen navigation

## Requirements 📋

- Android Studio Hedgehog (2023.1.1) or later
- JDK 17 or higher
- Android SDK 24+ (Android 7.0 Nougat or higher)
- Gradle 8.9+

## Getting Started 🚀

### 1. Clone the Repository

```bash
git clone https://github.com/mehmet0116/mete-.git
cd mete-
```

### 2. Open in Android Studio

1. Open Android Studio
2. Select "Open an Existing Project"
3. Navigate to the cloned directory
4. Wait for Gradle sync to complete

### 3. Build and Run

1. Connect an Android device or start an emulator
2. Click the "Run" button (▶️) in Android Studio
3. Select your device
4. The app will install and launch automatically

### Building from Command Line

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

The APK files will be in `app/build/outputs/apk/`

## Project Structure 📁

```
app/
├── src/
│   └── main/
│       ├── java/com/mete/braingame/
│       │   ├── data/              # Data models and game content
│       │   │   ├── Models.kt      # Category, Question, GameState
│       │   │   └── GameData.kt    # All categories and questions
│       │   ├── ui/
│       │   │   ├── screens/       # Compose screens
│       │   │   │   ├── WelcomeScreen.kt
│       │   │   │   ├── CategorySelectionScreen.kt
│       │   │   │   ├── GameScreen.kt
│       │   │   │   └── ResultsScreen.kt
│       │   │   ├── theme/         # Material Design 3 theme
│       │   │   │   ├── Color.kt
│       │   │   │   ├── Type.kt
│       │   │   │   └── Theme.kt
│       │   │   └── GameViewModel.kt  # State management
│       │   ├── util/
│       │   │   └── VoiceManager.kt   # Text-to-speech
│       │   └── MainActivity.kt       # Main entry point
│       ├── res/
│       │   ├── values/
│       │   │   ├── strings.xml
│       │   │   ├── colors.xml
│       │   │   └── themes.xml
│       │   └── mipmap-*/          # App icons
│       └── AndroidManifest.xml
└── build.gradle.kts
```

## How to Play 🎯

1. **Welcome Screen**: The app greets Mete with a voice message
2. **Select Category**: Choose from 6 different educational categories
3. **Play Games**: Answer questions with visual and audio feedback
4. **Get Results**: See your score with encouraging messages and stars!

## Features in Detail

### Voice Feedback
- Greeting: "Selam Mete! Hadi birlikte öğrenelim!"
- Encouragement: "Bravo Mete!", "Süpersin Mete!"
- Question narration in Turkish
- Positive reinforcement for all answers

### Educational Content
- Pattern completion exercises
- Number counting and sequences
- English vocabulary (animals, numbers, shapes, colors, fruits)
- Bilingual learning experience

### User Experience
- Colorful, child-friendly Material Design 3
- Smooth animations and transitions
- Clear visual feedback with colors
- Encouraging messages
- Star rating system (1-3 stars based on performance)

## Building for Release

To build a signed release APK:

1. Create a keystore file (if you don't have one)
2. Add signing config to `app/build.gradle.kts`
3. Run: `./gradlew assembleRelease`

## Contributing 🤝

This project is designed for educational purposes. Contributions are welcome!

## License 📄

This project is open source and available for educational use.

## Made with ❤️ for Mete

Created to help children develop cognitive skills while learning English and having fun!

---

## Previous Version

This app was previously a Progressive Web App (PWA) built with React. It has been completely rewritten as a native Android application using Kotlin and Jetpack Compose for better performance, native features, and an enhanced user experience on Android devices.

