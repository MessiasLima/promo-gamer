package com.messiaslima.navigation_contract

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Navigator {
    val route: String
    fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController)
}
