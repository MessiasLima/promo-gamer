package com.messiaslima.promogamer.feature.latestdeals.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class LatestDealsGamesViewModelFactory @Inject constructor(
    private val latestDealsGamesOrchestrator: LatestDealsGamesOrchestrator
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LatestDealsGamesViewModel(
            latestDealsGamesOrchestrator = latestDealsGamesOrchestrator
        ) as T
    }
}
