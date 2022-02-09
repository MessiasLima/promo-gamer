package com.messiaslima.promogamer.core.database.store

import com.messiaslima.promogamer.domain.Store

fun List<StoreEntity>.toDomain() = map { it.toDomain() }

private fun StoreEntity.toDomain() = Store(
    id = id,
    name = name,
    isActive = isActive,
    logo = logo
)

fun List<Store>.toEntity() = map { it.toEntity() }

private fun Store.toEntity() = StoreEntity(
    id = id,
    name = name,
    isActive = isActive,
    logo = logo
)
