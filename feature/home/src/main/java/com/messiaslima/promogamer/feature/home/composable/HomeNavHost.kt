package com.messiaslima.promogamer.feature.home.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.messiaslima.promogamer.feature.home.HomeCompositeNavigators

@Composable
fun HomeNavHost(
    homeNavController: NavHostController,
    mainNavController: NavController,
    compositeNavigators: HomeCompositeNavigators,
) {
    NavHost(
        navController = homeNavController,
        startDestination = compositeNavigators.latestDealsNavigator.route
    ) {
        compositeNavigators.latestDealsNavigator.configure(
            navGraphBuilder = this,
            navController = mainNavController
        )

        compositeNavigators.savedDealsNavigator.configure(
            navGraphBuilder = this,
            navController = mainNavController,
        )
    }
}
