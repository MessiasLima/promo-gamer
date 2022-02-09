package com.messiaslima.promogamer.feature.splash.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.messiaslima.promogamer.core.ui.theme.PromoGamerColors
import com.messiaslima.promogamer.core.ui.theme.Shapes
import com.messiaslima.promogamer.core.ui.theme.Typography

private val DarkColorPalette = darkColors(
    primary = PromoGamerColors.White,
    primaryVariant = PromoGamerColors.White,
    secondary = PromoGamerColors.White,
    onPrimary = PromoGamerColors.Green,
    onSecondary = PromoGamerColors.Green,
    surface = PromoGamerColors.Green
)

@Composable
fun PromoGamerSplashTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
