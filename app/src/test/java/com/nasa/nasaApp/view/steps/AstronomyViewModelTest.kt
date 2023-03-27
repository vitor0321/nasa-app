package com.nasa.nasaApp.view.steps

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nasa.core.usecase.FetchAstronomyDayUseCase
import com.nasa.core.usecase.GetAstronomyDayOfDateUseCase
import com.nasa.core.usecase.base.ResultStatus
import com.nasa.nasaApp.MainCoroutineRule
import com.nasa.nasaApp.domain.model.AstronomyDayFactory
import com.nasa.testing.MainCoroutineRule
import com.nasa.testing.model.AstronomyDayFactory
import com.nhaarman.mockitokotlin2.isA
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import java.time.LocalDate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
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
internal class AstronomyViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val astronomyDay = AstronomyDayFactory()
        .create(AstronomyDayFactory.FakeAstronomyDay.FakeAstronomyDay1)

    @Mock
    private lateinit var fetchAstronomyDayUseCase: FetchAstronomyDayUseCase

    @Mock
    private lateinit var getAstronomyDayOfDateUseCase: GetAstronomyDayOfDateUseCase

    @Mock
    private lateinit var uiStateObserver: Observer<AstronomyViewModel.UiState>

    private lateinit var astronomyViewModel: AstronomyViewModel

    @Before
    fun setUp() {
        astronomyViewModel = AstronomyViewModel(
            fetchAstronomyDayUseCase,
            getAstronomyDayOfDateUseCase,
            mainCoroutineRule.testDispatcherProvider
        ).apply {
            state.observeForever(uiStateObserver)
        }
    }

    @Test
    fun `should notify uiState with Success from UiState when fetchAstronomyDayUseCase returns success`() =
        runTest {
            // Arrange
            whenever(fetchAstronomyDayUseCase.invoke(FetchAstronomyDayUseCase.Params("")))
                .thenReturn(flowOf(ResultStatus.Success(astronomyDay)))

            //Act
            astronomyViewModel.fetchAstronomyDay()

            //Assert
            verify(uiStateObserver).onChanged(isA<AstronomyViewModel.UiState.Success>())
            val uiStateSuccess =
                astronomyViewModel.state.value as AstronomyViewModel.UiState.Success

            Assert.assertEquals(astronomyDay, uiStateSuccess.astronomyDay)
        }

    @Test
    fun `should notify uiState with Success from UiState when fetchAstronomyDayUseCase returns error`() =
        runTest {
            // Arrange
            whenever(fetchAstronomyDayUseCase.invoke(FetchAstronomyDayUseCase.Params("")))
                .thenReturn(flowOf(ResultStatus.Error(Throwable())))

            //Act
            astronomyViewModel.fetchAstronomyDay()

            //Assert
            verify(uiStateObserver).onChanged(isA<AstronomyViewModel.UiState.Error>())
        }

    @Test
    fun `should notify uiState with Success from UiState when getAstronomyDayOfDate returns success`() =
        runTest {
            // Arrange
            whenever(
                getAstronomyDayOfDateUseCase.invoke(
                    GetAstronomyDayOfDateUseCase.Params(LocalDate.now())
                )
            ).thenReturn(flowOf(ResultStatus.Success(astronomyDay)))

            //Act
            astronomyViewModel.getAstronomyDayOfDate(LocalDate.now())

            //Assert
            verify(uiStateObserver).onChanged(isA<AstronomyViewModel.UiState.Success>())
            val uiStateSuccess =
                astronomyViewModel.state.value as AstronomyViewModel.UiState.Success

            Assert.assertEquals(astronomyDay, uiStateSuccess.astronomyDay)
        }

    @Test
    fun `should notify uiState with Success from UiState when getAstronomyDayOfDate returns error`() =
        runTest {
            // Arrange
            whenever(
                getAstronomyDayOfDateUseCase.invoke(
                    GetAstronomyDayOfDateUseCase.Params(LocalDate.now())
                )
            ).thenReturn(flowOf(ResultStatus.Error(Throwable())))

            //Act
            astronomyViewModel.getAstronomyDayOfDate(LocalDate.now())

            //Assert
            verify(uiStateObserver).onChanged(isA<AstronomyViewModel.UiState.Error>())
        }

    @Test
    fun `should notify uiState with Success from UiState when call openCalendar`() =
        runTest {
            //Act
            astronomyViewModel.openCalendar()

            //Assert
            verify(uiStateObserver).onChanged(isA<AstronomyViewModel.UiState.OpenCalendar>())
            val uiStateSuccess =
                astronomyViewModel.state.value as AstronomyViewModel.UiState.OpenCalendar

            Assert.assertEquals(AstronomyViewModel.UiState.OpenCalendar, uiStateSuccess)
        }

}