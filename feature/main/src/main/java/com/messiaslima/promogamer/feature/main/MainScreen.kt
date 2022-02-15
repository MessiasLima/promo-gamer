package com.messiaslima.promogamer.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.home_contract.HomeNavigator

@Composable
fun MainScreen(homeNavigator: HomeNavigator) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = homeNavigator.route) {
        homeNavigator.configure(this)
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    PromoGamerTheme {
    }
}