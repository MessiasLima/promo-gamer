package com.messiaslima.promogamer.component.preferences.contract
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface PreferencesInteractor {
    fun getDealsLastUpdateTime(): Flow<LocalDateTime?>

    suspend fun setDealsLastUpdateTime(lastUpdated: LocalDateTime)

    fun getStoreLastUpdateTime(): Flow<LocalDateTime?>

    suspend fun setStoreLastUpdateTime(lastUpdated: LocalDateTime)
}