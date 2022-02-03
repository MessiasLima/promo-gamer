package com.messiaslima.promogamer.network.contract

interface StoreService {
    suspend fun getStores(): List<String>
}