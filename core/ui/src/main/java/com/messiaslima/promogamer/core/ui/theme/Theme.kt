package com.messiaslima.promogamer.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PromoGamerColors.Green,
    primaryVariant = PromoGamerColors.Green,
    secondary = PromoGamerColors.Purple
)

private val LightColorPalette = lightColors(
    primary = PromoGamerColors.Green,
    primaryVariant = PromoGamerColors.Green,
    secondary = PromoGamerColors.Purple
)

@Composable
fun PromoGamerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}