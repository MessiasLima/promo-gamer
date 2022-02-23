package com.messiaslima.promogamer.feature.latestdeals.products

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.messiaslima.promogamer.feature.latestdeals.products.contract.LatestDealsProductsNavigator
import javax.inject.Inject

class LatestDealsProductsNavigatorImpl @Inject constructor() : LatestDealsProductsNavigator {
    override val route: String
        get() = "latest_deals_products"

    override fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = route) {
            LatestDealsProductsScreen()
        }
    }
}
