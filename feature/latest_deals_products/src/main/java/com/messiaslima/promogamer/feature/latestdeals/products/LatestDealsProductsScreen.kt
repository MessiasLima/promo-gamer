package com.messiaslima.promogamer.feature.latestdeals.products

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun LatestDealsProductsScreen() {
    Text(text = "This is the latest deals products screen")
}

@Preview
@Composable
private fun LatestDealsProductsScreenPreview() {
    PromoGamerTheme {
        LatestDealsProductsScreen()
    }
}