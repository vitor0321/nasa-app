package com.example.nasaApp.ui.presentation

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
import com.example.core.domain.model.AstronomyDay
import com.example.nasaApp.ui.components.AstronomyDayIndicator
import com.example.nasaApp.ui.components.CalendarIndicator
import com.example.nasaApp.ui.components.ErrorIndicator
import com.example.nasaApp.ui.components.ProgressIndicator
import com.example.nasaApp.ui.theme.NasaBasicTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AstronomyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()
    }

    private fun initObserver() {
        viewModel.state.observe(this) { uiSate ->
            initCompose(uiSate)
        }
        viewModel.fetchAstronomyDay()
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
                                onClickImage = {

                                },
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

@Preview(showBackground = true)
@Composable
fun LoadingLightPreview() {
    NasaBasicTheme(isDynamic = false) {
        Loading()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingDarkPreview() {
    NasaBasicTheme(isDynamic = true) {
        Loading()
    }
}

@Preview(showBackground = true)
@Composable
fun AstronomyDayDarkPreview() {
    NasaBasicTheme(useDarkTheme = true) {
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

@Preview(showBackground = true)
@Composable
fun AstronomyDayLightPreview() {
    NasaBasicTheme(isDynamic = false) {
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
            onClickOpenCalendar = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorLightPreview() {
    NasaBasicTheme(isDynamic = false) {
        Error()
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorDarkPreview() {
    NasaBasicTheme(isDynamic = true) {
        Error()
    }
}
