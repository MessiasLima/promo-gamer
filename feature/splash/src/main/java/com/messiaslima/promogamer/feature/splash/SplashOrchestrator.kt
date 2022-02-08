package com.messiaslima.promogamer.feature.splash

import com.messiaslima.promogamer.core.network.contract.store.StoreService
import com.messiaslima.promogamer.domain.Store
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SplashOrchestrator @Inject constructor(
    private val storeService: StoreService
) {
    fun getStores() {
        if (shouldGetStoresFromLocalCache()){
            getStoresFromLocalCache()
        } else {
            getStoresFromServer()
        }
    }

    private fun getStoresFromServer() {
        flow<List<Store>> { storeService.getStores() }
            .map { it }
    }

    private fun getStoresFromLocalCache() {
        // TODO get stores from database
    }


    private fun shouldGetStoresFromLocalCache(): Boolean {
        TODO("verify on shared preferences")
    }
}
