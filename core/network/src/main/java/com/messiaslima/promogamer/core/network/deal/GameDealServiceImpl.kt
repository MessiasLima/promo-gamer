package com.messiaslima.promogamer.core.network.deal

import com.messiaslima.promogamer.core.network.CheapSharkService
import com.messiaslima.promogamer.core.network.contract.store.GameDealService
import com.messiaslima.promogamer.core.network.util.parseResponse
import com.messiaslima.promogamer.domain.GameDeal
import javax.inject.Inject

class GameDealServiceImpl @Inject constructor(
    private val cheapSharkService: CheapSharkService,
) : GameDealService {
    override suspend fun getLatestDeals(): List<GameDeal> {
        val dealsResponse = cheapSharkService.getDeals().parseResponse()
        return dealsResponse.toDomain()
    }
}
