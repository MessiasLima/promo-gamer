package com.messiaslima.promogamer.core.database.store

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store")
data class StoreEntity(
    @ColumnInfo(name = "id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "isActive") val isActive: Boolean,
    @ColumnInfo(name = "logo") val logo: String,
)