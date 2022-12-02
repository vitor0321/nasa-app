package com.nasa.nasaApp.ui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.nasa.core.model.Asteroids
import com.nasa.core.usecase.FetchAstronomyDayUseCase
import com.nasa.core.usecase.GetAsteroidsUseCase
import com.nasa.core.usecase.base.CoroutinesDispatchers
import com.nasa.nasaApp.ui.common.watchStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AsteroidsViewModel @Inject constructor(
    private val getAsteroidsUseCase: GetAsteroidsUseCase,
    private val coroutinesDispatchers: CoroutinesDispatchers
) : ViewModel() {

    private val action = MutableLiveData<Action>()
    val state: LiveData<UiState> = action.switchMap {
        liveData(coroutinesDispatchers.main()) {
            when (it) {
                is Action.FetchAsteroids -> {
                    getAsteroidsUseCase.invoke(
                        GetAsteroidsUseCase.Params(it.date)
                    ).watchStatus(
                        loading = { emit(UiState.Loading) },
                        success = { asteroids -> emit(UiState.Success(asteroids)) },
                        error = { emit(UiState.Error(it.message)) }
                    )
                }
            }
        }
    }

    fun fetchAsteroids(date: LocalDate) {
        action.value = Action.FetchAsteroids(date)
    }

    sealed class UiState {
        data class Success(val asteroids: List<Asteroids>?) : UiState()
        data class Error(val throwable: String?) : UiState()
        object Loading : UiState()
    }

    sealed class Action {
        data class FetchAsteroids(val date: LocalDate) : Action()
    }
}