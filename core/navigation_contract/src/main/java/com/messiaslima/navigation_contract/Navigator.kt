package com.messiaslima.navigation_contract

import androidx.navigation.NavGraphBuilder

interface Navigator {
    val route: String
    fun configure(navGraphBuilder: NavGraphBuilder)
}
