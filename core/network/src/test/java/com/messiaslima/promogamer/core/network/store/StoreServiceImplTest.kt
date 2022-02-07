package com.messiaslima.promogamer.core.network.store

import com.appmattus.kotlinfixture.kotlinFixture
import com.messiaslima.promogamer.core.network.CheapSharkService
import com.messiaslima.promogamer.core.network.contract.store.StoreService
import com.messiaslima.promogamer.core.network.store.model.StoreResponse
import com.messiaslima.promogamer.domain.Store
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class StoreServiceImplTest {
    private val fixture = kotlinFixture()
    private lateinit var storeService: StoreService
    private val mockCheapSharkService = mockk<CheapSharkService>()

    @Before
    fun setup() {
        storeService = StoreServiceImpl(mockCheapSharkService)
    }

    @Test
    fun `should get stores`() = runBlocking {
        val storeResponseList = fixture<List<StoreResponse>>()
        val storeResponse = Response.success(storeResponseList)
        val expectedStores = fixture<List<Store>>()

        mockkStatic(List<StoreResponse>::toDomain)
        coEvery { mockCheapSharkService.getStores() } returns storeResponse
        every { storeResponseList.toDomain() } returns expectedStores

        val actualStores = storeService.getStores()

        assertThat(actualStores, equalTo(expectedStores))
    }
}
