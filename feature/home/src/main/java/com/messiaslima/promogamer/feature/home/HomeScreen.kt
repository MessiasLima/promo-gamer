package com.messiaslima.promogamer.feature.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun HomeScreen() {
    Text(text = "This is home screen")
}

@Preview
@Composable
fun HomeScreenPreview() {
    PromoGamerTheme {
        HomeScreen()
    }
}
