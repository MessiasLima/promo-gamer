package com.messiaslima.promogamer.feature.home

import com.messiaslima.promogamer.feature.latestdeals.contract.LatestDealsNavigator
import javax.inject.Inject

class HomeCompositeNavigators @Inject constructor(
    val latestDealsNavigator: LatestDealsNavigator
)