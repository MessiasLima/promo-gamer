package com.messiaslima.promogamer.feature.main

import com.messiaslima.navigation_contract.Navigator
import com.messiaslima.promogamer.feature.home_contract.HomeNavigator
import javax.inject.Inject

class CompositeNavigators @Inject constructor(
    val homeNavigator: HomeNavigator
) {
    val navigators = listOf<Navigator>(
        homeNavigator
    )
}