package com.messiaslima.promogamer.feature.splash

import androidx.lifecycle.ViewModel
import com.messiaslima.promogamer.domain.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
@FlowPreview
class SplashViewModel @Inject constructor(
    private val splashOrchestrator: SplashOrchestrator
) : ViewModel() {
    private val retryTrigger = RetryTrigger()

    val uiState = retryableFlow(retryTrigger) {
        splashOrchestrator.getStores()
            .map<List<Store>, UiState> { UiState.Success }
            .catch { throwable ->
                throwable.printStackTrace()
                emit(UiState.Error)
            }
            .onStart {
                emit(UiState.Loading)
            }
    }

    fun tryAgain() {
        retryTrigger.retry()
    }

    sealed class UiState {
        object Loading : UiState()
        object Success : UiState()
        object Error : UiState()
        object Idle : UiState()
    }
}
