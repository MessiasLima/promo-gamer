package com.messiaslima.promogamer.core.network.contract.store

import com.messiaslima.promogamer.domain.Store

interface StoreService {
    suspend fun getStores(): List<Store>
}