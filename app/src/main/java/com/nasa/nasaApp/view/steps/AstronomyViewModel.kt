package com.nasa.nasaApp.view.steps

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.nasa.nasaApp.domain.data.CoroutinesDispatchers
import com.nasa.nasaApp.domain.AstronomyDataSource
import com.nasa.nasaApp.domain.model.AstronomyDay
import kotlinx.coroutines.launch
import java.io.IOException
import java.time.LocalDate
import javax.inject.Inject

internal class AstronomyViewModel @Inject constructor(
    private val astronomyDataSource: AstronomyDataSource,
    private val coroutinesDispatchers: CoroutinesDispatchers,
) : StateScreenModel<AstronomyViewModel.UiState>(UiState.Loading) {

    init {
        fetchAstronomyDay()
    }

    private fun fetchAstronomyDay() {
        coroutineScope.launch(coroutinesDispatchers.io()) {
            try {
                mutableState.value = UiState.Success(astronomyDataSource.getAstronomyDay())
            } catch (error: IOException) {
                mutableState.value = UiState.Error(error)
            }
        }
    }

    fun getAstronomyDayOfDate(date: LocalDate) {
        coroutineScope.launch(coroutinesDispatchers.io()) {
            try {
                val dateToString = "${date.year}-${date.monthValue}-${date.dayOfMonth}"
                mutableState.value = UiState.Success(
                    astronomyDataSource.getAstronomyDayOfDate(dateToString)
                )
            } catch (error: IOException) {
                mutableState.value = UiState.Error(error)
            }
        }
    }

    fun openCalendar() {
        mutableState.value = UiState.OpenCalendar
    }

    sealed class UiState {
        data class Success(val astronomyDay: AstronomyDay) : UiState()
        data class Error(val exception: IOException?) : UiState()
        object Loading : UiState()
        object OpenCalendar : UiState()
    }
}