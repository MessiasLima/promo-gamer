package com.messiaslima.promogamer.core.network.contract.store

interface StoreService {
    suspend fun getStores(): List<String>
}