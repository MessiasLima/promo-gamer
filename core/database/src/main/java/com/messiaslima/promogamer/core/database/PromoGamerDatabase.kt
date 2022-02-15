package com.messiaslima.promogamer.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.messiaslima.promogamer.core.database.store.StoreDao
import com.messiaslima.promogamer.core.database.store.StoreEntity

@Database(entities = [StoreEntity::class], version = 1, exportSchema = false)
abstract class PromoGamerDatabase : RoomDatabase() {
    abstract fun getStoreDao(): StoreDao
}
