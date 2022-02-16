package com.messiaslima.promogamer.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun MainScreen(compositeNavigators: CompositeNavigators) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = compositeNavigators.homeNavigator.route
    ) {
        compositeNavigators.navigators.forEach { it.configure(this, navController) }
    }
}