package com.messiaslima.promogamer.core.network.deal

import com.google.gson.annotations.SerializedName

data class DealResponse(
    @SerializedName("internalName") var internalName: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("metacriticLink") var metacriticLink: String? = null,
    @SerializedName("dealID") var dealId: String? = null,
    @SerializedName("storeID") var storeId: String? = null,
    @SerializedName("gameID") var gameId: String? = null,
    @SerializedName("salePrice") var salePrice: String? = null,
    @SerializedName("normalPrice") var normalPrice: String? = null,
    @SerializedName("isOnSale") var isOnSale: String? = null,
    @SerializedName("savings") var savings: String? = null,
    @SerializedName("metacriticScore") var metacriticScore: String? = null,
    @SerializedName("steamRatingText") var steamRatingText: String? = null,
    @SerializedName("steamRatingPercent") var steamRatingPercent: String? = null,
    @SerializedName("steamRatingCount") var steamRatingCount: String? = null,
    @SerializedName("steamAppID") var steamAppID: String? = null,
    @SerializedName("releaseDate") var releaseDate: Int? = null,
    @SerializedName("lastChange") var lastChange: Int? = null,
    @SerializedName("dealRating") var dealRating: String? = null,
    @SerializedName("thumb") var thumb: String? = null
)
