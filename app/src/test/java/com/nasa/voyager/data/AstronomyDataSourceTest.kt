package com.nasa.voyager.data

import com.nasa.voyager.MainCoroutineRule
import com.nasa.voyager.data.response.AstronomyDayResponseFactory
import com.nasa.voyager.domain.AstronomyDataSource
import com.nasa.voyager.domain.model.AstronomyDayFactory
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
internal class AstronomyDataSourceTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var nasaApi: NasaApi

    private val astronomyDayResponse = AstronomyDayResponseFactory()
        .create(AstronomyDayResponseFactory.FakeDataAstronomyDayResponse.FakeDataAstronomyDayResponse1)

    private val astronomyDay = AstronomyDayFactory()
        .create(AstronomyDayFactory.FakeAstronomyDay.FakeAstronomyDay1)

    private lateinit var astronomyRemoteDataSource: AstronomyDataSource

    @Before
    fun setUp() {
        astronomyRemoteDataSource = AstronomyDataSourceImpl(nasaApi)
    }

    @Test
    fun `should return AstronomyDay when getAstronomyDay with success`() =
        runTest {
            // Arrange
            whenever(nasaApi.getAstronomyDay()).thenReturn(astronomyDayResponse)

            //Act
            val result = astronomyRemoteDataSource.getAstronomyDay()

            //Assert
            Assert.assertEquals(astronomyDay, result)
            Assert.assertNotNull(result)
        }

    @Test
    fun `should return AstronomyDay when getAstronomyDay with error`() =
        runTest {
            // Arrange
            whenever(nasaApi.getAstronomyDay()).thenReturn(null)

            //Act
            val result = astronomyRemoteDataSource.getAstronomyDay()

            //Assert
            Assert.assertNotEquals(astronomyDay, result)
            Assert.assertNull(result)
        }

    @Test
    fun `should return AstronomyDay when get getAstronomyDayOfDate with success`() =
        runTest {
            // Arrange
            whenever(nasaApi.getAstronomyDayOfDate("2022-10-10")).thenReturn(astronomyDayResponse)

            //Act
            val result = astronomyRemoteDataSource.getAstronomyDayOfDate("2022-10-10")

            //Assert
            Assert.assertEquals(astronomyDay, result)
            Assert.assertNotNull(result)
        }

    @Test
    fun `should return AstronomyDay when get getAstronomyDayOfDate with error`() =
        runTest {
            // Arrange
            whenever(nasaApi.getAstronomyDayOfDate("2022-10-10")).thenReturn(null)

            //Act
            val result = astronomyRemoteDataSource.getAstronomyDayOfDate("2022-10-10")

            //Assert
            Assert.assertNotEquals(astronomyDay, result)
            Assert.assertNull(result)
        }
}