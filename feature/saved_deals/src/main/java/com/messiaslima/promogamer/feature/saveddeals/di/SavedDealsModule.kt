package com.messiaslima.promogamer.feature.saveddeals.di

import com.messiaslima.promogamer.feature.saveddeals.SavedDealsNavigatorImpl
import com.messiaslima.promogamer.feature.saveddeals.contract.SavedDealsNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface SavedDealsModule {
    @Binds
    fun bindSavedDealsNavigator(implementation: SavedDealsNavigatorImpl): SavedDealsNavigator
}