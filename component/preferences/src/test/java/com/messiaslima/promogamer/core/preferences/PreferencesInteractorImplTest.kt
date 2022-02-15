package com.messiaslima.promogamer.core.preferences

import com.appmattus.kotlinfixture.kotlinFixture
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.threeten.bp.LocalDateTime

@ExperimentalCoroutinesApi
class PreferencesInteractorImplTest {
    private lateinit var underTest: PreferencesInteractorImpl
    private val fixture = kotlinFixture()
    private val mockPreferencesRepository = mockk<PreferencesRepository>()

    @Before
    fun setup() {
        underTest = PreferencesInteractorImpl(mockPreferencesRepository)
    }

    @Test
    fun `should get latest deals update time`() = runBlockingTest {
        val mockDateTime = mockk<LocalDateTime>()
        coEvery {
            mockPreferencesRepository.getProperty(
                PreferencesInteractorImpl.LAST_DEALS_UPDATE_TIME,
                underTest.parseLocalDateTime,
            )
        } returns mockDateTime

        val actual = underTest.getDealsLastUpdateTime().firstOrNull()

        assertEquals(actual, mockDateTime)
    }

    @Test
    fun `should set latest deals update time`() = runBlockingTest {
        val mockDateTime = mockk<LocalDateTime>()
        val fixtDateTimeString = fixture<String>()

        coEvery {
            mockPreferencesRepository.updateProperty(
                PreferencesInteractorImpl.LAST_DEALS_UPDATE_TIME,
                any()
            )
        } returns Unit
        every { mockDateTime.toString() } returns fixtDateTimeString

        underTest.setDealsLastUpdateTime(mockDateTime)

        coVerify {
            mockPreferencesRepository.updateProperty(
                PreferencesInteractorImpl.LAST_DEALS_UPDATE_TIME,
                fixtDateTimeString
            )
        }
    }

    @Test
    fun `should get stores latest update time`() = runBlockingTest {
        val mockDateTime = mockk<LocalDateTime>()
        coEvery {
            mockPreferencesRepository.getProperty(
                PreferencesInteractorImpl.LAST_STORE_UPDATE_TIME,
                underTest.parseLocalDateTime,
            )
        } returns mockDateTime

        val actual = underTest.getStoreLastUpdateTime().firstOrNull()

        assertEquals(actual, mockDateTime)
    }

    @Test
    fun `should set store latest update time`() = runBlockingTest {
        val mockDateTime = mockk<LocalDateTime>()
        val fixtDateTimeString = fixture<String>()

        coEvery {
            mockPreferencesRepository.updateProperty(
                PreferencesInteractorImpl.LAST_STORE_UPDATE_TIME,
                any()
            )
        } returns Unit
        every { mockDateTime.toString() } returns fixtDateTimeString

        underTest.setStoreLastUpdateTime(mockDateTime)

        coVerify {
            mockPreferencesRepository.updateProperty(
                PreferencesInteractorImpl.LAST_STORE_UPDATE_TIME,
                fixtDateTimeString
            )
        }
    }

    @Test
    fun `should parse local date time`() {
        val fixtDateTimeString = fixture<String>()
        val mockDateTime = mockk<LocalDateTime>()

        mockkStatic("org.threeten.bp.LocalDateTime")

        every { LocalDateTime.parse(fixtDateTimeString) } returns mockDateTime

        val actual = underTest.parseLocalDateTime(fixtDateTimeString)
        val actualNull = underTest.parseLocalDateTime(null)

        assertEquals(mockDateTime, actual)
        assertNull(actualNull)
    }
}
