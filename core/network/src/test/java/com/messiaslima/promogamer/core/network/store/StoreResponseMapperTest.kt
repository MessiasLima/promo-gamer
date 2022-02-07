package com.messiaslima.promogamer.core.network.store

import com.appmattus.kotlinfixture.kotlinFixture
import com.messiaslima.promogamer.core.network.store.model.ImagesResponse
import com.messiaslima.promogamer.core.network.store.model.StoreResponse
import com.messiaslima.promogamer.domain.Store
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StoreResponseMapperTest {
    private val fixture = kotlinFixture()

    @Test
    fun `should map StoreResponse to Store domain model`() {
        val validStoreResponse = StoreResponse(
            storeId = "1",
            storeName = fixture<String>(),
            isActive = 1,
            imagesResponse = ImagesResponse(
                logo = fixture<String>()
            )
        )

        val storeResponseList = listOf(
            validStoreResponse,
            StoreResponse(
                storeId = "invalid id",
                storeName = fixture(),
                isActive = fixture(),
                imagesResponse = fixture()
            ),
            StoreResponse(
                storeId = "3",
                storeName = null,
                isActive = fixture(),
                imagesResponse = fixture()
            ),
            StoreResponse(
                storeId = "4",
                storeName = fixture(),
                isActive = 2,
                imagesResponse = null
            ),
        )

        val actual = storeResponseList.toDomain()
        val expected = Store(
            id = 1,
            name = validStoreResponse.storeName!!,
            isActive = true,
            logo = validStoreResponse.imagesResponse!!.logo!!
        )

        assertThat(actual, equalTo(listOf(expected)))
    }
}