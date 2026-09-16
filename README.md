# RoadDrive Editor

A road background editor Android APK application for designing and editing road backgrounds with an intuitive user interface.

## Features

- 🎨 **Drawing Tools**: Pen, eraser, line, circle, and rectangle tools
- 🎯 **Precision Control**: Adjustable brush size for fine-tuned editing
- 💾 **Save & Export**: Save your designs and export as images
- ↩️ **Undo/Redo**: Revert or redo your actions
- 🌈 **Color Picker**: Wide range of colors to choose from

## Project Structure

```
RoadDrive-Editor/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── kotlin/com/roaddrive/editor/
│   │       │   ├── MainActivity.kt
│   │       │   └── ui/
│   │       │       ├── RoadEditorScreen.kt
│   │       │       ├── components/
│   │       │       │   ├── EditorCanvas.kt
│   │       │       │   └── ToolPanel.kt
│   │       │       └── theme/
│   │       │           └── Theme.kt
│   │       ├── AndroidManifest.xml
│   │       └── res/
│   └── build.gradle
├── build.gradle
└── settings.gradle
```

## Requirements

- Android SDK 24 (API level 24) or higher
- Android Studio 2022.1 or newer
- Kotlin 1.8.0 or newer

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/ukstyles76-lab/RoadDrive-Editor.git
   cd RoadDrive-Editor
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an Existing Project"
   - Navigate to the RoadDrive-Editor folder

3. **Build the APK**
   - Go to `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
   - The APK will be generated in `app/build/outputs/apk/debug/`

4. **Run on Device/Emulator**
   - Connect an Android device or start an emulator
   - Click `Run` → `Run 'app'`

## Building for Production

To create a release APK:

1. Go to `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
2. Select `release` build variant
3. Sign the APK with your keystore

## Technologies Used

- **Kotlin**: Modern Android development language
- **Jetpack Compose**: Modern declarative UI toolkit
- **Material Design 3**: Latest Material Design system

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

For issues, questions, or suggestions, please open an issue on GitHub.
