package com.messiaslima.promogamer.core.preferences

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

const val PREFERENCES_NAME = "PromoGamer_Preferences"

val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

class PreferencesRepository @Inject constructor(@ApplicationContext context: Context) {
    private val dataStore = context.dataStore

    fun <T, R> getProperty(
        preferenceKey: Preferences.Key<T>,
        parser: (T?) -> R?
    ): Flow<R?> = dataStore.data
        .map { preferences -> preferences[preferenceKey] }
        .map { parser(it) }

    suspend fun <T> updateProperty(preferenceKey: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences -> preferences[preferenceKey] = value }
    }
}
