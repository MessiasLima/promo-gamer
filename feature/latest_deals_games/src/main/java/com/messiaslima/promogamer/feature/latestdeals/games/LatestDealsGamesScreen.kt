package com.messiaslima.promogamer.feature.latestdeals.games

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun LatestDealsGamesScreen(
    mainNavController: NavController,
    viewModelFactory: LatestDealsGamesViewModelFactory
) {
    val viewModel = viewModel<LatestDealsGamesViewModel>(factory = viewModelFactory)

    Text(text = "This is latest deals games screen")
}