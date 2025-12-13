# Android Build Instructions

## Prerequisites

- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: Version 17 or higher
- **Android SDK**: API Level 24 (Android 7.0) or higher
- **Gradle**: 8.9+ (included via wrapper)

## Build Steps

### 1. Setup Android Studio

1. Download and install [Android Studio](https://developer.android.com/studio)
2. Open Android Studio
3. Go to **Tools → SDK Manager**
4. Ensure these are installed:
   - Android SDK Platform 35 (or latest)
   - Android SDK Build-Tools
   - Android Emulator (for testing)

### 2. Open the Project

1. Launch Android Studio
2. Select **File → Open**
3. Navigate to the cloned `mete-` directory
4. Click **OK**
5. Wait for Gradle sync to complete (first time may take a few minutes)

### 3. Build the App

#### Using Android Studio GUI:

1. **Build Menu → Make Project** (or press Ctrl+F9 / Cmd+F9)
2. Wait for build to complete
3. Check the **Build** output window for any errors

#### Using Command Line:

```bash
# Navigate to project directory
cd /path/to/mete-

# Build debug APK
./gradlew assembleDebug

# Build release APK (unsigned)
./gradlew assembleRelease
```

### 4. Run on Device/Emulator

#### Option A: Using Android Studio

1. Connect your Android device via USB (with USB debugging enabled)
   - OR create an Android Virtual Device (AVD) via **Tools → Device Manager**
2. Select your device from the device dropdown
3. Click the **Run** button (▶️) or press Shift+F10
4. The app will install and launch automatically

#### Option B: Using Command Line

```bash
# List connected devices
./gradlew devices

# Install and run on connected device
./gradlew installDebug
```

### 5. Testing on Physical Device

#### Enable Developer Options on Android:

1. Go to **Settings → About Phone**
2. Tap **Build Number** 7 times
3. Go back to **Settings → Developer Options**
4. Enable **USB Debugging**
5. Connect device via USB
6. Accept the debugging authorization prompt

### 6. Find the APK Files

After building, APK files are located at:

```
app/build/outputs/apk/debug/app-debug.apk          # Debug build
app/build/outputs/apk/release/app-release.apk      # Release build (unsigned)
```

## Common Build Commands

```bash
# Clean build
./gradlew clean

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install debug build on connected device
./gradlew installDebug

# Uninstall app from device
./gradlew uninstallDebug

# Run all checks (lint, tests, etc.)
./gradlew check

# List all available tasks
./gradlew tasks
```

## Creating a Signed Release APK

For distribution outside of development:

### 1. Generate a Keystore

```bash
keytool -genkey -v -keystore mete-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias mete-key
```

### 2. Configure Signing in `app/build.gradle.kts`

Add signing config:

```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("../mete-release-key.jks")
            storePassword = "your-store-password"
            keyAlias = "mete-key"
            keyPassword = "your-key-password"
        }
    }
    
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            // ... other release settings
        }
    }
}
```

**Important**: Never commit keystore files or passwords to version control!

### 3. Build Signed Release APK

```bash
./gradlew assembleRelease
```

The signed APK will be at: `app/build/outputs/apk/release/app-release.apk`

## Troubleshooting

### Gradle Sync Failed

- Check internet connection
- Invalidate Caches: **File → Invalidate Caches / Restart**
- Update Gradle: Edit `gradle/wrapper/gradle-wrapper.properties`

### SDK Not Found

- Open **Tools → SDK Manager**
- Install required SDK platforms and build tools
- Set `ANDROID_HOME` environment variable

### Build Failed - Out of Memory

Add to `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4096m
```

### Device Not Detected

- Ensure USB debugging is enabled
- Try different USB cable or port
- Install device drivers (Windows)
- Run `adb devices` to verify connection

## Performance Optimization

For better app performance in release builds, enable ProGuard/R8:

```kotlin
buildTypes {
    release {
        isMinifyEnabled = true
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
        )
    }
}
```

## App Size Optimization

To reduce APK size:

1. Enable code shrinking (R8)
2. Use APK splits for different architectures
3. Optimize images and resources
4. Remove unused resources

## Continuous Integration

For automated builds, use:

```bash
# CI/CD environment
./gradlew clean assembleRelease --no-daemon --stacktrace
```

## Next Steps

- Test on multiple Android versions (API 24+)
- Test on different screen sizes
- Add instrumented tests for UI
- Set up Firebase for crash reporting
- Configure Google Play Store listing

## Resources

- [Android Developer Docs](https://developer.android.com)
- [Jetpack Compose Docs](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io)
- [Gradle Build Tool](https://gradle.org)

---

For any issues, check the Android Studio **Logcat** for detailed error messages.
