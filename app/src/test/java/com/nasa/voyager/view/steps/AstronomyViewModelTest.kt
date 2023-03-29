package com.nasa.voyager.view.steps

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nasa.voyager.MainCoroutineRule
import com.nasa.voyager.domain.AstronomyDataSource
import com.nasa.voyager.domain.model.AstronomyDayFactory
import com.nhaarman.mockitokotlin2.any
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
import java.time.LocalDate

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
internal class AstronomyViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val astronomyDay = AstronomyDayFactory()
        .create(AstronomyDayFactory.FakeAstronomyDay.FakeAstronomyDay1)

    @Mock
    private lateinit var astronomyDataSource: AstronomyDataSource

    private lateinit var astronomyViewModel: AstronomyViewModel

    @Before
    fun setUp() {
        astronomyViewModel = AstronomyViewModel(
            astronomyDataSource,
            mainCoroutineRule.testDispatcherProvider
        )
    }

    @Test
    fun `should notify uiState with Success from UiState when getAstronomyDay returns success`() =
        runTest {
            // Arrange
            whenever(astronomyDataSource.getAstronomyDay()).thenReturn(astronomyDay)

            //Act
            astronomyViewModel.getAstronomyDay()


            //Assert
            Assert.assertEquals(astronomyViewModel.state.value, AstronomyViewModel.UiState.Success(astronomyDay))
        }

    @Test
    fun `should notify uiState with Loading from UiState when init getAstronomyDay`() =
        runTest {
            // Arrange
            whenever(astronomyDataSource.getAstronomyDay()).thenReturn(null)

            //Act
            astronomyViewModel.getAstronomyDay()

            //Assert
            Assert.assertEquals(astronomyViewModel.state.value, AstronomyViewModel.UiState.Loading)
        }


    @Test
    fun `should notify uiState with Success from UiState when getAstronomyDayOfDate returns success`() =
        runTest {
            // Arrange
            val date = LocalDate.now()
            val params = "${date.year}-${date.monthValue}-${date.dayOfMonth}"
            whenever(astronomyDataSource.getAstronomyDayOfDate(params)).thenReturn(astronomyDay)

            //Act
            astronomyViewModel.getAstronomyDayOfDate(LocalDate.now())

            //Assert
            Assert.assertEquals(astronomyViewModel.state.value, AstronomyViewModel.UiState.Success(astronomyDay))
        }

    @Test
    fun `should notify uiState with Loading from UiState when getAstronomyDayOfDate returns loading`() =
        runTest {
            // Arrange
            val date = LocalDate.now()
            val params = "${date.year}-${date.monthValue}-${date.dayOfMonth}"
            whenever(astronomyDataSource.getAstronomyDayOfDate(params)).thenReturn(any())

            //Act
            astronomyViewModel.getAstronomyDayOfDate(LocalDate.now())

            //Assert
            Assert.assertEquals(astronomyViewModel.state.value, AstronomyViewModel.UiState.Loading)
        }
}