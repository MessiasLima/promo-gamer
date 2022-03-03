package com.messiaslima.promogamer.domain

data class GameDeal(
    val id: String,
    val title: String,
    val metacriticLink: String?,
    val storeId: Int,
    val gameId: Int,
    val salePrice: String,
    val normalPrice: String,
    val isOnSale: Boolean
)