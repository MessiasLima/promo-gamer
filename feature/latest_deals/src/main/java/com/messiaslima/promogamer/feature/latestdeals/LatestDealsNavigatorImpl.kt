package com.messiaslima.promogamer.feature.latestdeals

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.messiaslima.promogamer.feature.latestdeals.contract.LatestDealsNavigator
import javax.inject.Inject

class LatestDealsNavigatorImpl @Inject constructor(
    private val latestDealsCompositeNavigator: LatestDealsCompositeNavigator
) : LatestDealsNavigator {
    override val route = "latest_deals"

    override fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = route) {
            LatestDealsScreen(
                mainNavController = navController,
                compositeNavigator = latestDealsCompositeNavigator
            )
        }
    }
}
