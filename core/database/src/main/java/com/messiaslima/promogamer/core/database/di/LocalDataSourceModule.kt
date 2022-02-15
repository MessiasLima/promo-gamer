package com.messiaslima.promogamer.core.database.di

import com.messiaslima.promogamer.core.database.contract.StoreLocalDataSource
import com.messiaslima.promogamer.core.database.store.StoreLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LocalDataSourceModule {
    @Binds
    fun bindStoreLocalDataSource(impl: StoreLocalDataSourceImpl): StoreLocalDataSource
}
