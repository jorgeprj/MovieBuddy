package com.seuprojeto.mymovie.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val RedColorScheme = lightColorScheme(
    primary = Red40,
    onPrimary = White,
    secondary = Red80,
    onSecondary = Black,
    background = LightGray,
    onBackground = Black,
    surface = White,
    onSurface = Black,
)

@Composable
fun MyMovieTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = RedColorScheme,
        typography = Typography(),
        content = content
    )
}