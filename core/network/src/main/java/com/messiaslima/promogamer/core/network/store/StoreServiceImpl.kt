package com.messiaslima.promogamer.core.network.store

import com.messiaslima.promogamer.core.network.CheapSharkService
import com.messiaslima.promogamer.core.network.NetworkServicesModule
import com.messiaslima.promogamer.core.network.PromoGamerNetworkException
import com.messiaslima.promogamer.core.network.contract.store.StoreService
import com.messiaslima.promogamer.core.network.util.parseResponse
import com.messiaslima.promogamer.domain.Store
import javax.inject.Inject

class StoreServiceImpl @Inject constructor(
    private val cheapSharkService: CheapSharkService,
) : StoreService {
    private var shouldFail = true
    override suspend fun getStores(): List<Store> {
        val storesResponse = cheapSharkService.getStores().parseResponse()

        if (shouldFail) {
            shouldFail = false
            throw PromoGamerNetworkException("deu ruim")
        }

        return storesResponse.toDomain()
    }
}
