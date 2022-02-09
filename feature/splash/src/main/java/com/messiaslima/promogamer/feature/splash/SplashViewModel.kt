package com.messiaslima.promogamer.feature.splash

import androidx.lifecycle.ViewModel
import com.messiaslima.promogamer.domain.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    splashOrchestrator: SplashOrchestrator
) : ViewModel() {
    val uiState: Flow<UiState> = splashOrchestrator.getStores()
        .map<List<Store>, UiState> { UiState.Success }
        .catch { emit(UiState.Error) }
        .onStart { emit(UiState.Loading) }

    @Suppress("EmptyFunctionBlock")
    fun tryAgain() {
    }

    sealed class UiState {
        object Loading : UiState()
        object Success : UiState()
        object Error : UiState()
    }
}
