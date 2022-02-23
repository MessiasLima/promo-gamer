package com.messiaslima.promogamer.core.network.di

import com.messiaslima.promogamer.core.network.contract.store.StoreService
import com.messiaslima.promogamer.core.network.store.StoreServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [CheapSharkModule::class])
@InstallIn(SingletonComponent::class)
interface NetworkServicesModule {
    @Binds
    fun bindStoreService(impl: StoreServiceImpl): StoreService
}
