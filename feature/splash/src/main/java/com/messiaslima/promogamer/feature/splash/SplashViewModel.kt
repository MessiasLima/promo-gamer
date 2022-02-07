package com.messiaslima.promogamer.feature.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    // splashOrchestrator: SplashOrchestrator
) : ViewModel() {
    val message = "Sample message"
}
