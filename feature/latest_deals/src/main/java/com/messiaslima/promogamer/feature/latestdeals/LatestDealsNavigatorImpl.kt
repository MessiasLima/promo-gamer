package com.messiaslima.promogamer.feature.latestdeals

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.messiaslima.promogamer.feature.latestdeals.contract.LatestDealsNavigator

class LatestDealsNavigatorImpl : LatestDealsNavigator {
    override val route = "latestdeals"

    override fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = route) {
            LatestDealsScreen()
        }
    }
}