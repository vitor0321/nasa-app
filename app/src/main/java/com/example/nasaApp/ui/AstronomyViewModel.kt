package com.example.nasaApp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.liveData
import com.example.core.domain.model.AstronomyDay
import com.example.core.usecase.GetAstronomyDayUseCase
import com.example.core.usecase.base.CoroutinesDispatchers
import com.example.nasaApp.ui.common.watchStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AstronomyViewModel @Inject constructor(
    private val getAstronomyDayUseCase: GetAstronomyDayUseCase,
    private val coroutinesDispatchers: CoroutinesDispatchers
) : ViewModel() {

    private val action = MutableLiveData<Action>()
    val state: LiveData<UiState> = action.switchMap {
        liveData(coroutinesDispatchers.main()) {
            when (it) {
                is Action.GetAstronomyDay -> {
                    getAstronomyDayUseCase.invoke(
                        GetAstronomyDayUseCase.Params("")
                    ).watchStatus(
                        loading = {
                            emit(UiState.Loading)
                        },
                        success = { astronomyDay ->
                            emit(UiState.Success(astronomyDay))
                        },
                        error = {
                            emit(UiState.Error)
                        }
                    )
                }
            }
        }
    }

    fun getAstronomyDay() {
        action.value = Action.GetAstronomyDay
    }

    sealed class UiState {
        data class Success(val astronomyDay: AstronomyDay) : UiState()
        object Loading : UiState()
        object Error : UiState()
    }

    sealed class Action {
        object GetAstronomyDay : Action()
    }
}