package com.messiaslima.promogamer.core.database.store

import com.messiaslima.promogamer.core.database.contract.StoreLocalDataSource
import com.messiaslima.promogamer.domain.Store
import javax.inject.Inject

class StoreLocalDataSourceImpl @Inject constructor(
    private val storeDao: StoreDao
) : StoreLocalDataSource {
    override suspend fun findAll(): List<Store> {
        return storeDao.findAll().toDomain()
    }
}