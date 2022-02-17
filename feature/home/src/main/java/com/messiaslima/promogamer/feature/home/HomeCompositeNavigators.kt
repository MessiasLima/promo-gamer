package com.messiaslima.promogamer.feature.home

import com.messiaslima.promogamer.feature.latestdeals.contract.LatestDealsNavigator
import com.messiaslima.promogamer.feature.saveddeals.contract.SavedDealsNavigator
import javax.inject.Inject

class HomeCompositeNavigators @Inject constructor(
    val latestDealsNavigator: LatestDealsNavigator,
    val savedDealsNavigator: SavedDealsNavigator,
)
