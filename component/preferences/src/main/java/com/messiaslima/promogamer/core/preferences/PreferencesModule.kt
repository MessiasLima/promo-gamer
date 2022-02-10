package com.messiaslima.promogamer.core.preferences

import com.messiaslima.promogamer.component.preferences.contract.PreferencesInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface PreferencesModule {
    @Binds
    fun bindPreferencesInteractor(implementation: PreferencesInteractorImpl): PreferencesInteractor
}
