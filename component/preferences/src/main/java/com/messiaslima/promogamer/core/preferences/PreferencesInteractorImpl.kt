package com.messiaslima.promogamer.core.preferences

import androidx.datastore.preferences.core.stringPreferencesKey
import com.messiaslima.promogamer.component.preferences.contract.PreferencesInteractor
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

class PreferencesInteractorImpl @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) : PreferencesInteractor {
    override fun getDealsLastUpdateTime() = preferencesRepository.getProperty(LAST_DEALS_UPDATE_TIME) {
        it?.let(LocalDateTime::parse)
    }

    override suspend fun setDealsLastUpdateTime(lastUpdated: LocalDateTime) {
        preferencesRepository.updateProperty(LAST_DEALS_UPDATE_TIME, lastUpdated.toString())
    }

    override fun getStoreLastUpdateTime() = preferencesRepository.getProperty(LAST_STORE_UPDATE_TIME) {
        it?.let(LocalDateTime::parse)
    }

    override suspend fun setStoreLastUpdateTime(lastUpdated: LocalDateTime) {
        preferencesRepository.updateProperty(LAST_STORE_UPDATE_TIME, lastUpdated.toString())
    }

    companion object {
        private val LAST_DEALS_UPDATE_TIME = stringPreferencesKey("last_deals_update_time")
        private val LAST_STORE_UPDATE_TIME = stringPreferencesKey("last_store_update_time")
    }
}
