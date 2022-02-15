package com.messiaslima.promogamer.core.network.store.model

import com.google.gson.annotations.SerializedName

data class StoreResponse(
    @SerializedName("storeID") var storeId: String? = null,
    @SerializedName("storeName") var storeName: String? = null,
    @SerializedName("isActive") var isActive: Int? = null,
    @SerializedName("images") var imagesResponse: ImagesResponse? = null
)
