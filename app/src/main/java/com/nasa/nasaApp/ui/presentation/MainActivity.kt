package com.nasa.nasaApp.ui.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nasa.core.model.AstronomyDay
import com.nasa.nasaApp.ui.components.astronomyDay.CalendarIndicator
import com.nasa.nasaApp.ui.components.astronomyDay.ErrorIndicator
import com.nasa.nasaApp.ui.components.activity.MainComposeActivity
import com.nasa.nasaApp.ui.components.astronomyDay.MainShimmerAstronomyDay
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val astronomyViewModel: AstronomyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        astronomyViewModel.fetchAstronomyDay()
        astronomyViewModel.state.observe(this) { uiSate ->
            initCompose(uiSate)
        }
    }

    private fun initCompose(uiSate: AstronomyViewModel.UiState) {
        setContent {
            NasaBasicTheme {
                when (uiSate) {
                    is AstronomyViewModel.UiState.Loading -> MainShimmerAstronomyDay()
                    is AstronomyViewModel.UiState.Success -> MainComposeActivity(uiSate.astronomyDay)
                    is AstronomyViewModel.UiState.Error -> ErrorIndicator(uiSate.throwable)
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun LoadingLightPreview() {
    NasaBasicTheme {
        MainShimmerAstronomyDay()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun AstronomyDayDarkPreview() {
    NasaBasicTheme {
        MainComposeActivity(
            AstronomyDay(
                copyright = "Yanninck Akar",
                date = "10-10-2010",
                explanation = "explanation",
                hdurl = "https://apod.nasa.gov/apod/image/2210/Europa_JunoLuck_2611.jpg",
                mediaType = "image",
                title = "title",
                url = "url"
            )
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
