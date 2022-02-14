package com.messiaslima.promogamer.core.network.store

import com.appmattus.kotlinfixture.kotlinFixture
import com.messiaslima.promogamer.core.network.store.model.ImagesResponse
import com.messiaslima.promogamer.core.network.store.model.StoreResponse
import com.messiaslima.promogamer.domain.Store
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class StoreResponseMapperTest {
    private val fixture = kotlinFixture()

    @Test
    fun `should map StoreResponse to Store domain model`() {
        val validStoreResponse = StoreResponse(
            storeId = "1",
            storeName = "Steam",
            isActive = 1,
            imagesResponse = ImagesResponse(
                banner = "banner.png",
                logo = "logo.png",
                icon = "icon.ico"
            )
        )

        val storeResponseList = listOf(
            validStoreResponse,
            StoreResponse(
                storeId = "invalid id",
                storeName = null,
                isActive = 0,
                imagesResponse = ImagesResponse(
                    banner = null,
                    logo = null,
                    icon = null
                )
            ),
            StoreResponse(
                storeId = null,
                storeName = "Invalid store",
                isActive = null,
                imagesResponse = fixture<ImagesResponse>().copy(logo = fixture<String>())
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
            logo = LOGO_HOST + validStoreResponse.imagesResponse!!.logo!!
        )

        assertThat(actual, equalTo(listOf(expected)))
    }

    @Test
    fun `should return an empty list when the list is null`() {
        val nullList: List<StoreResponse>? = null

        assertEquals(emptyList<StoreResponse>(), nullList.toDomain())
    }
}
