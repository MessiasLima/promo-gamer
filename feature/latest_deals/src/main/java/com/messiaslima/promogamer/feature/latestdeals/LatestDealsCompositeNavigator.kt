package com.messiaslima.promogamer.feature.latestdeals

import com.messiaslima.promogamer.feature.latestdeals.games.contract.LatestDealsGamesNavigator
import javax.inject.Inject

class LatestDealsCompositeNavigator @Inject constructor(
    val latestDealsGamesNavigator: LatestDealsGamesNavigator
)