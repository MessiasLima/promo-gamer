package com.messiaslima.promogamer.feature.saveddeals

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.messiaslima.promogamer.feature.saveddeals.contract.SavedDealsNavigator

class SavedDealsNavigatorImpl : SavedDealsNavigator {
    override val route = "saveddeals"

    override fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route) {
            SavedDealsScreen()
        }
    }
}