package com.nasa.nasaApp.view.steps

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.nasa.nasaApp.domain.data.CoroutinesDispatchers
import com.nasa.nasaApp.domain.AsteroidsDataSource
import com.nasa.nasaApp.domain.model.Asteroids
import kotlinx.coroutines.launch
import java.io.IOException
import java.time.LocalDate

internal class AsteroidsViewModel(
    private val asteroidsDataSource: AsteroidsDataSource,
    private val coroutinesDispatchers: CoroutinesDispatchers,
) : StateScreenModel<AsteroidsViewModel.UiState>(UiState.Loading) {

    init {
        fetchAsteroids(LocalDate.now())
    }

    private fun fetchAsteroids(date: LocalDate) {
        coroutineScope.launch(coroutinesDispatchers.io()) {
            try {
                asteroidsDataSource.getAsteroids(date) {
                    mutableState.value = UiState.Success(it)
                }
            } catch (error: IOException) {
                mutableState.value = UiState.Error(error)
            }
        }
    }

    sealed class UiState {
        data class Success(val asteroids: List<Asteroids>?) : UiState()
        data class Error(val exception: IOException?) : UiState()
        object Loading : UiState()
    }
}