package com.messiaslima.promogamer.feature.main

import com.messiaslima.promogamer.core.navigation.contract.Navigator
import com.messiaslima.promogamer.feature.home.contract.HomeNavigator
import javax.inject.Inject

class CompositeNavigators @Inject constructor(
    val homeNavigator: HomeNavigator
) {
    val navigators = listOf<Navigator>(
        homeNavigator
    )
}
