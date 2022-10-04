package com.example.nasaApp.ui

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
import com.example.nasaApp.ui.components.ErrorIndicator
import com.example.nasaApp.ui.components.ImageFullIndicator
import com.example.nasaApp.ui.components.ProgressIndicator
import com.example.nasaApp.ui.theme.NasaBasicTheme
import dagger.hilt.android.AndroidEntryPoint

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
        viewModel.getAstronomyDay()
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
                            AstronomyDay(data = uiSate.astronomyDay)
                        }
                        is AstronomyViewModel.UiState.Error -> Error()
                    }
                }
            }
        }
    }
}

@Composable
fun Loading() {
    ProgressIndicator()
}

@Composable
fun AstronomyDay(data: AstronomyDay, ) {
    AstronomyDayIndicator(astronomyDay = data)
}

@Composable
fun Error() {
    ErrorIndicator()
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
            )
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
            )
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
