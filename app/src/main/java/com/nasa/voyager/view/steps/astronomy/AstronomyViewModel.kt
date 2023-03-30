package com.nasa.voyager.view.steps.astronomy

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.nasa.voyager.domain.data.CoroutinesDispatchers
import com.nasa.voyager.domain.AstronomyDataSource
import com.nasa.voyager.domain.model.AstronomyDay
import kotlinx.coroutines.launch
import java.io.IOException
import java.time.LocalDate
import javax.inject.Inject

internal class AstronomyViewModel @Inject constructor(
    private val astronomyDataSource: AstronomyDataSource,
    private val coroutinesDispatchers: CoroutinesDispatchers,
) : StateScreenModel<AstronomyViewModel.UiState>(UiState.Loading) {

    init {
        getAstronomyDay()
    }

    fun getAstronomyDay() {
        coroutineScope.launch(coroutinesDispatchers.io()) {
            mutableState.value = UiState.Loading
            try {
                astronomyDataSource.getAstronomyDay()?.let {
                    mutableState.value = UiState.Success(it)
                }
            } catch (error: IOException) {
                mutableState.value = UiState.Error(error)
            }
        }
    }

    fun getAstronomyDayOfDate(date: LocalDate) {
        coroutineScope.launch(coroutinesDispatchers.io()) {
            mutableState.value = UiState.Loading
            try {
                val dateToString = "${date.year}-${date.monthValue}-${date.dayOfMonth}"
                astronomyDataSource.getAstronomyDayOfDate(dateToString)?.let {
                    mutableState.value = UiState.Success(it)
                }
            } catch (error: IOException) {
                mutableState.value = UiState.Error(error)
            }
        }
    }

    sealed class UiState {
        data class Success(val astronomyDay: AstronomyDay) : UiState()
        data class Error(val exception: IOException?) : UiState()
        object Loading : UiState()
    }
}