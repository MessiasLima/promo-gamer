package com.messiaslima.promogamer.core.network.store

interface StoreService {
    suspend fun getStores(): List<StoreResponse>
}