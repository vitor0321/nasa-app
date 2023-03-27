package com.nasa.nasaApp.view.steps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.kodein.rememberScreenModel
import com.nasa.nasaApp.view.Calendar
import com.nasa.nasaApp.view.components.AstronomyDayIndicator
import com.nasa.nasaApp.view.components.ErrorIndicator
import com.nasa.nasaApp.view.components.ProgressIndicator
import com.nasa.nasaApp.view.resource.LocalStrings
import com.nasa.nasaApp.view.utils.Step

internal object HomeScreen: Step("homeScreen") {

    @Composable
    override fun Content() {
        val strings = LocalStrings.current.components

        val viewModelAsteroids = rememberScreenModel<AsteroidsViewModel>()
        val stateAsteroids by viewModelAsteroids.state.collectAsState()

        val viewModelAstronomy = rememberScreenModel<AstronomyViewModel>()
        val stateAstronomy by viewModelAstronomy.state.collectAsState()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when (stateAstronomy) {
                is AstronomyViewModel.UiState.Loading -> ProgressIndicator(progressText = strings.loading)
                is AstronomyViewModel.UiState.Success -> {
                    AstronomyDayIndicator(
                        astronomyDay = (stateAstronomy as AstronomyViewModel.UiState.Success).astronomyDay,
                        onClickImage = {},
                        onClickOpenCalendar = { viewModelAstronomy.openCalendar() }
                    )
                }
                is AstronomyViewModel.UiState.Error -> ErrorIndicator(
                    exception = (stateAstronomy as AstronomyViewModel.UiState.Error).exception,
                    errorText = strings.error
                )
                is AstronomyViewModel.UiState.OpenCalendar -> Calendar(
                    onDateSelected = { viewModelAstronomy.getAstronomyDayOfDate(it) },
                    onDismissRequest = { viewModelAstronomy.getAstronomyDayOfDate(it) }
                )
            }
        }
    }
}