package com.messiaslima.promogamer.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.messiaslima.promogamer.feature.home_contract.HomeNavigator
import javax.inject.Inject

class HomeNavigatorImpl @Inject constructor() : HomeNavigator {
    override val route = "home"

    override fun configure(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(route) { HomeScreen() }
    }
}