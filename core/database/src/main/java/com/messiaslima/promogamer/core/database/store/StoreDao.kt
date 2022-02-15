package com.messiaslima.promogamer.core.database.store

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(stores: List<StoreEntity>)

    @Query("SELECT * FROM store")
    suspend fun findAll(): List<StoreEntity>

    @Query("SELECT * FROM store WHERE id = :id")
    suspend fun findById(id: Int): StoreEntity
}
