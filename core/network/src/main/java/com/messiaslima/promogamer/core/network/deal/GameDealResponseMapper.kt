package com.messiaslima.promogamer.core.network.deal

import android.util.Log
import com.messiaslima.promogamer.domain.GameDeal

fun List<GameDealResponse>?.toDomain(): List<GameDeal> {
    if (this == null) return emptyList()

    return mapNotNull { it.toDomain() }
}

@Suppress("TooGenericExceptionCaught")
fun GameDealResponse.toDomain(): GameDeal? {
    return try {
        val storeIdInt = requireNotNull(storeId).toInt()
        val gameIdInt = requireNotNull(gameId).toInt()
        GameDeal(
            id = requireNotNull(dealId),
            title = requireNotNull(title),
            metacriticLink = parseMetacriticLink(metacriticLink),
            storeId = storeIdInt,
            gameId = gameIdInt,
            salePrice = requireNotNull(salePrice),
            normalPrice = requireNotNull(normalPrice),
            isOnSale = requireNotNull(normalPrice) == "1"
        )
    } catch (throwable: Throwable) {
        Log.e("GameDealResponse", "mapping to domain", throwable)
        null
    }
}

fun parseMetacriticLink(metacriticLink: String?): String? {
    val metacriticHost = "https://www.metacritic.com/"
    return metacriticLink?.let { "$metacriticHost$metacriticLink" }
}
