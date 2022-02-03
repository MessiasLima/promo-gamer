package com.messiaslima.promogamer.core.network.store

import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("banner") var banner: String? = null,
    @SerializedName("logo") var logo: String? = null,
    @SerializedName("icon") var icon: String? = null
)