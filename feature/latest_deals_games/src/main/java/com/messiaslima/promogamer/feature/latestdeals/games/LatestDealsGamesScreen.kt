package com.messiaslima.promogamer.feature.latestdeals.games

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun LatestDealsGamesScreen(mainNavController: NavController) {
    Text(text = "This is latest deals games screen")
}

@Preview
@Composable
private fun LatestDealsGamesScreenPreview() {
    PromoGamerTheme {
        val previewNavController = rememberNavController()
        LatestDealsGamesScreen(mainNavController = previewNavController)
    }
}
