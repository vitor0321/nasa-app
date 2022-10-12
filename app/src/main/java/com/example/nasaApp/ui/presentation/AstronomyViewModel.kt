package com.example.nasaApp.ui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.example.core.domain.model.AstronomyDay
import com.example.core.usecase.FetchAstronomyDayUseCase
import com.example.core.usecase.GetAstronomyDayOfDateUseCase
import com.example.core.usecase.base.CoroutinesDispatchers
import com.example.nasaApp.ui.common.watchStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AstronomyViewModel @Inject constructor(
    private val fetchAstronomyDayUseCase: FetchAstronomyDayUseCase,
    private val getAstronomyDayOfDateUseCase: GetAstronomyDayOfDateUseCase,
    private val coroutinesDispatchers: CoroutinesDispatchers
) : ViewModel() {

    private val action = MutableLiveData<Action>()
    val state: LiveData<UiState> = action.switchMap {
        liveData(coroutinesDispatchers.main()) {
            when (it) {
                is Action.FetchAstronomyDay -> {
                    fetchAstronomyDayUseCase.invoke(
                        FetchAstronomyDayUseCase.Params("")
                    ).watchStatus(
                        loading = { emit(UiState.Loading) },
                        success = { astronomyDay -> emit(UiState.Success(astronomyDay)) },
                        error = { emit(UiState.Error(it.message)) }
                    )
                }
                is Action.GetAstronomyDayOfDate -> {
                    getAstronomyDayOfDateUseCase.invoke(
                        GetAstronomyDayOfDateUseCase.Params(it.date)
                    ).watchStatus(
                        loading = { emit(UiState.Loading) },
                        success = { astronomyDay -> emit(UiState.Success(astronomyDay)) },
                        error = { emit(UiState.Error(it.message)) }
                    )
                }
                is Action.OpenCalendar -> { emit(UiState.OpenCalendar) }
            }
        }
    }

    fun fetchAstronomyDay() {
        action.value = Action.FetchAstronomyDay
    }

    fun getAstronomyDayOfDate(date: LocalDate) {
        action.value = Action.GetAstronomyDayOfDate(date)
    }

    fun openCalendar() {
        action.value = Action.OpenCalendar
    }

    sealed class UiState {
        data class Success(val astronomyDay: AstronomyDay) : UiState()
        data class Error(val throwable: String?) : UiState()
        object Loading : UiState()
        object OpenCalendar : UiState()
    }

    sealed class Action {
        data class GetAstronomyDayOfDate(val date: LocalDate) : Action()
        object FetchAstronomyDay : Action()
        object OpenCalendar : Action()
    }
}