package com.messiaslima.promogamer.feature.home.di

import com.messiaslima.promogamer.feature.home_contract.HomeNavigator
import com.messiaslima.promogamer.feature.home.HomeNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface HomeModule {
    @Binds
    fun bindHomeNavigator(impl: HomeNavigatorImpl): HomeNavigator
}