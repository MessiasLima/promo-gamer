package com.messiaslima.promogamer.feature.latestdeals.games

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.messiaslima.promogamer.feature.latestdeals.games.contract.LatestDealsGamesNavigator
import javax.inject.Inject

class LatestDealsGamesNavigatorImpl @Inject constructor() : LatestDealsGamesNavigator {
    override val route: String
        get() = "latest_deals_games"

    override fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = route) {
            LatestDealsGamesScreen(navController)
        }
    }
}
