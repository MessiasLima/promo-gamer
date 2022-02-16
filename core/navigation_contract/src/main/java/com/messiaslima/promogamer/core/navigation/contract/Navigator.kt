package com.messiaslima.promogamer.core.navigation.contract

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Navigator {
    val route: String
    fun configure(navGraphBuilder: NavGraphBuilder, navController: NavController)
}
