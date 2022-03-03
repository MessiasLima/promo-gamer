package com.messiaslima.promogamer.core.network.contract.store

import com.messiaslima.promogamer.domain.GameDeal

interface GameDealService {
    suspend fun getLatestDeals(): List<GameDeal>
}