package com.messiaslima.promogamer.core.network

import com.messiaslima.promogamer.core.network.contract.store.StoreService
import com.messiaslima.promogamer.core.network.store.StoreServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module(includes = [CheapSharkModule::class])
@InstallIn(ViewModelComponent::class)
interface NetworkServicesModule {
    @Binds
    fun bindStoreService(impl: StoreServiceImpl): StoreService
}