package com.messiaslima.promogamer.feature.splash

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.onEach

@FlowPreview
fun <T> retriableFlow(retryTrigger: RetryTrigger, flowProvider: () -> Flow<T>) =
    retryTrigger.retryEvent.filter { it }
        .flatMapConcat { flowProvider() }
        .onEach { retryTrigger.retryEvent.value = false }

class RetryTrigger {
    val retryEvent = MutableStateFlow(true)

    fun retry() {
        retryEvent.value = true
    }
}
