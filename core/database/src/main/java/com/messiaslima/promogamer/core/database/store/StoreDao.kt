package com.messiaslima.promogamer.core.database.store

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StoreDao {
    @Insert
    fun save(vararg users: StoreEntity)

    @Query("SELECT * FROM store")
    suspend fun findAll(): List<StoreEntity>

    @Query("SELECT * FROM store WHERE id = :id")
    fun findById(id: Int): StoreEntity
}