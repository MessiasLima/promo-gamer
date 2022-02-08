package com.messiaslima.promogamer.core.database.store

import com.appmattus.kotlinfixture.kotlinFixture
import com.messiaslima.promogamer.domain.Store
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class StoreLocalDataSourceImplTest {
    private lateinit var underTest: StoreLocalDataSourceImpl
    private val fixture = kotlinFixture()
    private val mockStoreDao = mockk<StoreDao>()

    @Before
    fun setup() {
        underTest = StoreLocalDataSourceImpl(mockStoreDao)
    }

    @Test
    fun `should find all stores`() = runBlocking {
        val fixtEntities = fixture<List<StoreEntity>>()
        val fixtDomains = fixture<List<Store>>()

        mockkStatic(List<StoreEntity>::toDomain)
        coEvery { mockStoreDao.findAll() } returns fixtEntities
        every { fixtEntities.toDomain() } returns fixtDomains

        val actual = underTest.findAll()

        assertEquals(fixtDomains, actual)
    }
}