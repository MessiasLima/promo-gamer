package com.messiaslima.promogamer.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.messiaslima.promogamer.feature.home.contract.HomeNavigator
import javax.inject.Inject

class HomeNavigatorImpl @Inject constructor(
    private val compositeNavigators: HomeCompositeNavigators,
    private val homeViewModelFactory: HomeViewModelFactory
) : HomeNavigator {
    override val route = "home"

    override fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route) {
            HomeScreen(homeViewModelFactory)
        }
    }
}
