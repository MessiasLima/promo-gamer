package com.messiaslima.promogamer.feature.latestdeals.di

import com.messiaslima.promogamer.feature.latestdeals.LatestDealsNavigatorImpl
import com.messiaslima.promogamer.feature.latestdeals.contract.LatestDealsNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface LatestDealsModule {
    @Binds
    fun bindLatestDealsNavigator(impl: LatestDealsNavigatorImpl): LatestDealsNavigator
}
