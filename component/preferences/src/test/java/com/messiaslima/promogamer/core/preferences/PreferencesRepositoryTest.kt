package com.messiaslima.promogamer.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.appmattus.kotlinfixture.kotlinFixture
import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PreferencesRepositoryTest {
    private lateinit var underTest: PreferencesRepository
    private val fixture = kotlinFixture()
    private val mockPreferences = mockk<Preferences>()
    private val mockDataStore = mockk<DataStore<Preferences>> {
        every { data } returns flowOf(mockPreferences)
    }

    @Before
    fun setup() {
        underTest = PreferencesRepository(mockDataStore)
    }

    @Test
    fun `should get property`() = runBlockingTest {
        val fixtPreferenceValue = fixture<String>()
        val preferenceKey = stringPreferencesKey(fixture())

        every { mockPreferences[preferenceKey] } returns fixtPreferenceValue

        val actual = underTest.getProperty(preferenceKey) { it }

        assertEquals(fixtPreferenceValue, actual)
    }

    @Test
    fun `should return null when getting missing property`() = runBlockingTest {
        val preferenceKey = stringPreferencesKey(fixture())

        every { mockPreferences[preferenceKey] } returns null

        val actual = underTest.getProperty(preferenceKey) { it }

        assertNull(actual)
    }
}
