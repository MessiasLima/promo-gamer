package com.messiaslima.promogamer.feature.home.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.messiaslima.promogamer.feature.home.HomeCompositeNavigators

@Composable
fun HomeNavHost(
    modifier: Modifier = Modifier,
    homeNavController: NavHostController,
    mainNavController: NavController,
    compositeNavigators: HomeCompositeNavigators,
) {
    NavHost(
        modifier = modifier,
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
