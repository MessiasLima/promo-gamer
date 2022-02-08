package com.messiaslima.promogamer.core.database.contract

import com.messiaslima.promogamer.domain.Store

interface StoreLocalDataSource {
    suspend fun findAll(): List<Store>
}