# ⚠️ Important: Android Studio Required

This is a **native Android application** built with Kotlin and Jetpack Compose. It **requires Android Studio** to build and run.

## Why Android Studio is Required

Unlike web applications that can run with just Node.js, Android apps need:
- Android SDK (Software Development Kit)
- Android Build Tools
- Kotlin Compiler for Android
- Jetpack Compose compiler
- Android Emulator (for testing without a physical device)

All of these are bundled with Android Studio and properly configured automatically.

## Quick Start

### 1. Install Android Studio

Download from: https://developer.android.com/studio

### 2. Open This Project

1. Launch Android Studio
2. Click "Open an Existing Project"
3. Select this folder (`mete-`)
4. Wait for Gradle sync (first time takes 5-10 minutes)

### 3. Run the App

1. Click the ▶️ Run button
2. Select an emulator or connected device
3. The app will build and launch automatically!

## What's Included

✅ **Complete source code** for all screens and features
✅ **Material Design 3** beautiful UI
✅ **Jetpack Compose** modern Android UI
✅ **Voice feedback** (Text-to-Speech)
✅ **6 educational categories** with questions
✅ **Smooth animations** and transitions

## File Structure

```
app/
├── src/main/java/com/mete/braingame/
│   ├── MainActivity.kt              # App entry point
│   ├── ui/
│   │   ├── screens/                 # All 4 screens (Welcome, Categories, Game, Results)
│   │   ├── theme/                   # Material Design 3 theme
│   │   └── GameViewModel.kt         # State management
│   ├── data/                        # Game data and models
│   └── util/                        # Voice manager
└── src/main/res/                    # Resources (strings, colors, icons)
```

## Building from Command Line (Advanced)

If you have Android SDK installed separately:

```bash
export ANDROID_HOME=/path/to/Android/sdk
./gradlew assembleDebug
```

But **we strongly recommend using Android Studio** for the best experience!

## See Also

- [ANDROID_BUILD.md](ANDROID_BUILD.md) - Detailed build instructions
- [README.md](README.md) - Full project documentation

---

**Made with ❤️ for Mete - A beautiful educational Android game!**
