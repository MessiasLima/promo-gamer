package com.messiaslima.promogamer.feature.main

import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.feature.home.contract.HomeNavigator
import javax.inject.Inject

class CompositeNavigators @Inject constructor(
    val homeNavigator: HomeNavigator
) {
    val navigators = listOf<AppNavigator>(
        homeNavigator
    )
}
