package com.nasa.voyager.view.steps.astronomy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.kodein.rememberScreenModel
import com.nasa.voyager.view.components.CalendarIndicator
import com.nasa.voyager.view.components.ErrorIndicator
import com.nasa.voyager.view.components.ProgressIndicator
import com.nasa.voyager.view.resource.LocalStrings
import com.nasa.voyager.view.steps.astronomy.area.AstronomyContent
import com.nasa.voyager.view.utils.Step

internal object AstronomyScreen : Step("AstronomyScreen") {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel<AstronomyViewModel>()
        AstronomyContent(viewModel = viewModel)
    }
}

@Composable
private fun AstronomyContent(viewModel: AstronomyViewModel) {
    val state by viewModel.state.collectAsState()

    val strings = LocalStrings.current.astronomy
    val openCalendar = remember { mutableStateOf(false) }

    when (state) {
        is AstronomyViewModel.UiState.Loading -> ProgressIndicator(progressText = strings.loading)
        is AstronomyViewModel.UiState.Success ->
            AstronomyContent(
                astronomyDay = (state as AstronomyViewModel.UiState.Success).astronomyDay,
                onClickImage = {},
                onClickOpenCalendar = { openCalendar.value = true }
            )
        is AstronomyViewModel.UiState.Error ->
            ErrorIndicator(
                exception = (state as AstronomyViewModel.UiState.Error).exception,
                errorText = strings.error
            )
    }

    if (openCalendar.value) {
        CalendarIndicator(onDateSelected = {
            viewModel.getAstronomyDayOfDate(it)
            openCalendar.value = false
        }, onDismissRequest = {
            openCalendar.value = false
        })
    }
}
