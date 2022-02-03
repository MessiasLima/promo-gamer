package com.messiaslima.promogamer.feature.splash

import android.util.Log
import com.messiaslima.promogamer.core.network.store.StoreService
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class SplashOrchestrator @Inject constructor(
    private val storeService: StoreService
) {
    init {
        runBlocking {
            Log.i("Message", storeService.getStores().toString())
        }
    }
}
