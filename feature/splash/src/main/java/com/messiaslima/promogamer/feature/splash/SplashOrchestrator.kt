package com.messiaslima.promogamer.feature.splash

import com.messiaslima.promogamer.component.preferences.contract.PreferencesInteractor
import com.messiaslima.promogamer.core.database.contract.StoreLocalDataSource
import com.messiaslima.promogamer.core.network.contract.store.StoreService
import com.messiaslima.promogamer.domain.Store
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

@FlowPreview
class SplashOrchestrator @Inject constructor(
    private val storeService: StoreService,
    private val storeLocalDataSource: StoreLocalDataSource,
    private val preferencesInteractor: PreferencesInteractor,
) {
    fun getStores(): Flow<List<Store>> {
        return isCacheValid().flatMapConcat {
            if (it) getStoresFromLocalCache() else getStoresFromServer()
        }
    }

    private fun getStoresFromServer() = flow { emit(storeService.getStores()) }
        .onEach { storeLocalDataSource.save(it) }
        .onEach { preferencesInteractor.setStoreLastUpdateTime(LocalDateTime.now()) }

    private fun getStoresFromLocalCache() = flow { emit(storeLocalDataSource.findAll()) }

    private fun isCacheValid(): Flow<Boolean> {
        return preferencesInteractor.getStoreLastUpdateTime()
            .map { lastUpdatedTime ->
                lastUpdatedTime?.let {
                    LocalDateTime.now().isBefore(it.plusDays(STORE_CACHE_EXPIRATION_TIME_IN_DAYS))
                }
            }
            .filterNotNull()
            .onEmpty { emit(false) }
    }

    companion object {
        private const val STORE_CACHE_EXPIRATION_TIME_IN_DAYS = 7L
    }
}
