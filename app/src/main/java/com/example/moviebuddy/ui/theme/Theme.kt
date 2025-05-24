package com.example.moviebuddy.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val RedColorScheme = lightColorScheme(
    primary = Color(0xFFD32F2F),
    onPrimary = Color.White,
    secondary = Color(0xFFC2185B),
    background = Color(0xFFFCE4EC),
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun MovieBuddyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = RedColorScheme,
        typography = Typography(),
        content = content
    )
}
