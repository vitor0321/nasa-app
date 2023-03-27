package com.nasa.nasaApp.data

import com.nasa.core.repository.AstronomyRemoteDataSource
import com.nasa.nasaApp.data.AstronomyDataSourceImpl
import com.nasa.nasaApp.data.NasaApi
import com.nasa.testing.MainCoroutineRule
import com.nasa.testing.model.AstronomyDayFactory
import com.nasa.nasaApp.data.response.AstronomyDayResponseFactory
import com.nasa.nasaApp.domain.AsteroidsDataSource
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
class AstronomyDataSourceTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var nasaApi: NasaApi
    @Mock
    lateinit var nasaApiAsteroids: AsteroidsDataSource


    private val astronomyDayResponse = AstronomyDayResponseFactory()
        .create(AstronomyDayResponseFactory.FakeDataAstronomyDayResponse.FakeDataAstronomyDayResponse1)

    private val astronomyDay = AstronomyDayFactory()
        .create(AstronomyDayFactory.FakeAstronomyDay.FakeAstronomyDay1)

    private lateinit var astronomyRemoteDataSource: AstronomyRemoteDataSource

    @Before
    fun setUp() {
        astronomyRemoteDataSource = AstronomyDataSourceImpl(nasaApi,nasaApiAsteroids)
    }

    @Test
    fun `should return AstronomyDay when get fetchAstronomyDay with success`() =
        runTest {
            // Arrange
            whenever(nasaApi.getAstronomyDay()).thenReturn(astronomyDayResponse)

            //Act
            val result = astronomyRemoteDataSource.fetchAstronomyDay()

            //Assert
            Assert.assertEquals(astronomyDay, result)
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
        }
}