package com.messiaslima.promogamer.core.database.store

import com.appmattus.kotlinfixture.kotlinFixture
import com.messiaslima.promogamer.domain.Store
import org.junit.Assert.assertEquals
import org.junit.Test

class StoreEntityMapperKtTest {
    private val fixture = kotlinFixture()

    @Test
    fun `should map StoreEntity to store domain model`() {
        val fixtStoreEntityList = fixture<List<StoreEntity>>()
        val expected = fixtStoreEntityList.map { fixtStoreEntity ->
            Store(
                id = fixtStoreEntity.id,
                name = fixtStoreEntity.name,
                isActive = fixtStoreEntity.isActive,
                logo = fixtStoreEntity.logo
            )
        }

        assertEquals(expected, fixtStoreEntityList.toDomain())
    }
}