#!/bin/bash
# Create simple placeholder icons using ImageMagick if available, otherwise create empty files
# For a production app, proper icons should be created with Android Asset Studio

SIZES=(
    "mdpi:48"
    "hdpi:72"
    "xhdpi:96"
    "xxhdpi:144"
    "xxxhdpi:192"
)

for size_config in "${SIZES[@]}"; do
    IFS=':' read -r density pixels <<< "$size_config"
    dir="app/src/main/res/mipmap-${density}"
    
    # Create simple colored squares as placeholders
    # In production, use proper icon design tools
    if command -v convert &> /dev/null; then
        # Using ImageMagick
        convert -size ${pixels}x${pixels} xc:'#6366F1' "$dir/ic_launcher.png"
        convert -size ${pixels}x${pixels} xc:'#6366F1' "$dir/ic_launcher_round.png"
        convert -size ${pixels}x${pixels} xc:'#FFFFFF' "$dir/ic_launcher_foreground.png"
    else
        # Create empty placeholder files (will use default Android icon)
        touch "$dir/ic_launcher.png"
        touch "$dir/ic_launcher_round.png"
        touch "$dir/ic_launcher_foreground.png"
    fi
done

echo "Icon placeholders created. For production, use Android Asset Studio to create proper icons."
