package com.messiaslima.promogamer.core.network.util

import com.appmattus.kotlinfixture.kotlinFixture
import com.messiaslima.promogamer.core.network.PromoGamerNetworkException
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

class ResponseExtensionsKtTest {
    private val fixture = kotlinFixture()

    @Test
    fun `should return body when the response is successful`() {
        val responseBody = fixture<String>()
        val response = Response.success(responseBody)

        assertEquals(responseBody, response.parseResponse())
    }

    @Test(expected = PromoGamerNetworkException::class)
    fun `should throw exception when response is not sucessful`() {
        val response = Response.error<String>(400, ResponseBody.create(MediaType.parse(""), ""))

        response.parseResponse()
    }
}
