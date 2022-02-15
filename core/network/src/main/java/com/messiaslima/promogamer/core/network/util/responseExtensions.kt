package com.messiaslima.promogamer.core.network.util

import com.messiaslima.promogamer.core.network.PromoGamerNetworkException
import retrofit2.Response

inline fun <reified T> Response<T>.parseResponse(
    errorMessage: String = "Cannot get ${T::class.simpleName} from server",
): T? {
    return if (isSuccessful) {
        body()
    } else {
        throw PromoGamerNetworkException(errorMessage)
    }
}
