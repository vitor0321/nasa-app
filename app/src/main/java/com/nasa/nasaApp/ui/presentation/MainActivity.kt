package com.nasa.nasaApp.ui.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nasa.core.model.AstronomyDay
import com.nasa.nasaApp.ui.components.AstronomyDayIndicator
import com.nasa.nasaApp.ui.components.CalendarIndicator
import com.nasa.nasaApp.ui.components.ErrorIndicator
import com.nasa.nasaApp.ui.components.ProgressIndicator
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AstronomyViewModel by viewModels()
    private val viewModelAsteroids: AsteroidsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()
    }

    private fun initObserver() {
        viewModelAsteroids.state.observe(this){ uiState ->
            uiState
        }
        viewModel.state.observe(this) { uiSate ->
            initCompose(uiSate)
        }
        viewModel.fetchAstronomyDay()
        viewModelAsteroids.fetchAsteroids(LocalDate.now())
    }

    private fun initCompose(uiSate: AstronomyViewModel.UiState) {
        setContent {
            NasaBasicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (uiSate) {
                        is AstronomyViewModel.UiState.Loading -> Loading()
                        is AstronomyViewModel.UiState.Success -> {
                            AstronomyDay(
                                astronomyDay = uiSate.astronomyDay,
                                onClickImage = {},
                                onClickOpenCalendar = { viewModel.openCalendar() }
                            )
                        }
                        is AstronomyViewModel.UiState.Error -> Error(uiSate.throwable)
                        is AstronomyViewModel.UiState.OpenCalendar -> Calendar(
                            onDateSelected = { viewModel.getAstronomyDayOfDate(it) },
                            onDismissRequest = { viewModel.getAstronomyDayOfDate(it) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Loading() {
    NasaBasicTheme {
        ProgressIndicator()
    }
}

@Composable
fun AstronomyDay(
    astronomyDay: AstronomyDay,
    onClickImage: () -> Unit,
    onClickOpenCalendar: () -> Unit
) {
    NasaBasicTheme {
        AstronomyDayIndicator(
            astronomyDay = astronomyDay,
            onClickImage = { onClickImage() },
            onClickOpenCalendar = { onClickOpenCalendar() }
        )
    }
}

@Composable
fun Error(throwable: String?) {
    NasaBasicTheme {
        ErrorIndicator(throwable)
    }
}

@Composable
fun Calendar(
    onDateSelected: (LocalDate) -> Unit,
    onDismissRequest: (LocalDate) -> Unit
) {
    NasaBasicTheme {
        CalendarIndicator(
            onDateSelected = { onDateSelected(it) },
            onDismissRequest = { onDismissRequest(it) }
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun LoadingLightPreview() {
    NasaBasicTheme {
        Loading()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun AstronomyDayDarkPreview() {
    NasaBasicTheme {
        AstronomyDay(
            AstronomyDay(
                copyright = null,
                date = "10-10-2010",
                explanation = "explanation",
                hdurl = null,
                mediaType = "image",
                title = "title",
                url = "url"
            ),
            onClickImage = {},
            onClickOpenCalendar = {}
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ErrorDarkPreview() {
    NasaBasicTheme {
        ErrorIndicator(null)
    }
}
