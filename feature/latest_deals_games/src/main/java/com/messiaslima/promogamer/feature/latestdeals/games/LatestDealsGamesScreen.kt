package com.messiaslima.promogamer.feature.latestdeals.games

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun LatestDealsGamesScreen(
    mainNavController: NavController,
    viewModelFactory: LatestDealsGamesViewModelFactory
) {
    val viewModel = viewModel<LatestDealsGamesViewModel>(factory = viewModelFactory)

    Text(text = "This is latest deals games screen")
}
