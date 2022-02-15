package com.messiaslima.promogamer.core.preferences.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.migration.DisableInstallInCheck

const val PREFERENCES_NAME = "PromoGamer_Preferences"

val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

@Module
@DisableInstallInCheck
object DataStorePreferencesModule {
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }
}
