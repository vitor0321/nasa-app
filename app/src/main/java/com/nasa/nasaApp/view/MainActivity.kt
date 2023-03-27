package com.nasa.nasaApp.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.navigator.Navigator
import com.nasa.nasaApp.domain.model.AstronomyDay
import com.nasa.nasaApp.view.components.AstronomyDayIndicator
import com.nasa.nasaApp.view.components.CalendarIndicator
import com.nasa.nasaApp.view.components.ProgressIndicator
import com.nasa.nasaApp.view.resource.LocalStrings
import com.nasa.nasaApp.view.resource.strings
import com.nasa.nasaApp.view.resource.theme.NasaBasicTheme
import com.nasa.nasaApp.view.steps.HomeScreen
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import java.time.LocalDate

class MainActivity : ComponentActivity(), DIAware {

    override val di by closestDI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lyricist = rememberStrings(translations = strings)
            ProvideStrings(lyricist = lyricist, provider = LocalStrings) {
                NasaBasicTheme { Navigator(screen = HomeScreen) }
            }
        }
    }
}

@Composable
fun Loading() {
    NasaBasicTheme {
        ProgressIndicator(progressText = null)
    }
}

@Composable
internal fun AstronomyDay(
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
