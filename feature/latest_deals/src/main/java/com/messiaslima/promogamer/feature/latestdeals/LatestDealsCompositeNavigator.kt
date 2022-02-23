package com.messiaslima.promogamer.feature.latestdeals

import com.messiaslima.promogamer.feature.latestdeals.games.contract.LatestDealsGamesNavigator
import com.messiaslima.promogamer.feature.latestdeals.products.contract.LatestDealsProductsNavigator
import javax.inject.Inject

class LatestDealsCompositeNavigator @Inject constructor(
    val latestDealsGamesNavigator: LatestDealsGamesNavigator,
    val latestDealsProductsNavigator: LatestDealsProductsNavigator,
)