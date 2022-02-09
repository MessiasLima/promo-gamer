package com.messiaslima.promogamer.core.network.store

import androidx.annotation.VisibleForTesting
import com.messiaslima.promogamer.core.network.store.model.StoreResponse
import com.messiaslima.promogamer.domain.Store

private const val INVALID_ID = -1
private const val INVALID_NAME = "store_invalid_name"
private const val INVALID_LOGO = "invalid_logo"

@VisibleForTesting
const val LOGO_HOST = "https://www.cheapshark.com"

fun List<StoreResponse>?.toDomain(): List<Store> {
    if (this == null) {
        return emptyList()
    }

    return asSequence()
        .map { it.toDomain() }
        .filter { it.id != INVALID_ID }
        .filter { it.name != INVALID_NAME }
        .filter { it.logo != INVALID_LOGO }
        .toList()
}

fun StoreResponse.toDomain() = Store(
    id = storeId?.toIntOrNull() ?: INVALID_ID,
    name = storeName ?: INVALID_NAME,
    isActive = isActive == 1,
    logo = imagesResponse?.logo?.let { LOGO_HOST + it } ?: INVALID_LOGO
)
