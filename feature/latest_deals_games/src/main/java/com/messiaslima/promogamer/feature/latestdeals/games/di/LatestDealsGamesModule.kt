package com.messiaslima.promogamer.feature.latestdeals.games.di

import com.messiaslima.promogamer.feature.latestdeals.games.LatestDealsGamesNavigatorImpl
import com.messiaslima.promogamer.feature.latestdeals.games.contract.LatestDealsGamesNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface LatestDealsGamesModule {
    @Binds
    fun bindLatestDealsGamesNavigator(implementation: LatestDealsGamesNavigatorImpl): LatestDealsGamesNavigator
}
