package com.messiaslima.promogamer.feature.splash

import com.messiaslima.promogamer.core.database.contract.StoreLocalDataSource
import com.messiaslima.promogamer.core.network.contract.store.StoreService
import com.messiaslima.promogamer.domain.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SplashOrchestrator @Inject constructor(
    private val storeService: StoreService,
    private val storeLocalDataSource: StoreLocalDataSource,
) {
    fun getStores(): Flow<List<Store>> {
        return if (shouldGetStoresFromLocalCache()) {
            getStoresFromLocalCache()
        } else {
            getStoresFromServer()
        }
    }

    private fun getStoresFromServer() = flow { emit(storeService.getStores()) }
        .onEach { storeLocalDataSource.save(it) }

    private fun getStoresFromLocalCache() = flow { emit(storeLocalDataSource.findAll()) }

    @Suppress("FunctionOnlyReturningConstant")
    private fun shouldGetStoresFromLocalCache(): Boolean {
        return false
    }
}
