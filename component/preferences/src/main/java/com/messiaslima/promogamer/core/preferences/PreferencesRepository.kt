package com.messiaslima.promogamer.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    suspend fun <T, R> getProperty(
        preferenceKey: Preferences.Key<T>,
        parser: (T?) -> R?
    ): R? = dataStore.data
        .map { preferences -> preferences[preferenceKey] }
        .map { parser(it) }
        .firstOrNull()

    suspend fun <T> updateProperty(preferenceKey: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences -> preferences[preferenceKey] = value }
    }
}
