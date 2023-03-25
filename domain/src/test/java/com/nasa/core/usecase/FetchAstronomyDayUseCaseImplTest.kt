package com.nasa.core.usecase

import com.nasa.core.repository.AstronomyRepository
import com.nasa.core.usecase.base.ResultStatus
import com.nasa.testing.MainCoroutineRule
import com.nasa.testing.model.AstronomyDayFactory
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FetchAstronomyDayUseCaseImplTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var repository: AstronomyRepository
    private val astronomyDay = AstronomyDayFactory()
        .create(AstronomyDayFactory.FakeAstronomyDay.FakeAstronomyDay1)

    private lateinit var fetchAstronomyDayUseCase: FetchAstronomyDayUseCase

    @Before
    fun setUp() {
        fetchAstronomyDayUseCase = FetchAstronomyDayUseCaseImpl(
            repository,
            mainCoroutineRule.testDispatcherProvider
        )
    }

    @Test
    fun `should return Success from ResultStatus when get both requests return success`() =
        runTest {
            // Arrange
            whenever(repository.fetchAstronomyDay()).thenReturn(astronomyDay)

            //Act
            val result = fetchAstronomyDayUseCase
                .invoke(FetchAstronomyDayUseCase.Params(""))

            //Assert
            val resultList = result.toList()
            Assert.assertEquals(ResultStatus.Loading, resultList[0])
            Assert.assertTrue(resultList[1] is ResultStatus.Success)
        }

    @Test
    fun `should return Error from ResultStatus when get events request returns error`()=
        runTest {
            // Arrange
            whenever(repository.fetchAstronomyDay()).thenAnswer { throw Throwable() }

            //Act
            val result = fetchAstronomyDayUseCase
                .invoke(FetchAstronomyDayUseCase.Params(""))

            //Assert
            val resultList = result.toList()
            Assert.assertEquals(ResultStatus.Loading, resultList[0])
            Assert.assertTrue(resultList[1] is ResultStatus.Error)
        }
}