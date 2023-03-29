package com.nasa.voyager.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.navigator.Navigator
import com.nasa.voyager.domain.model.AstronomyDay
import com.nasa.voyager.view.components.AstronomyDayIndicator
import com.nasa.voyager.view.components.CalendarIndicator
import com.nasa.voyager.view.resource.LocalStrings
import com.nasa.voyager.view.resource.strings
import com.nasa.voyager.view.resource.theme.NasaBasicTheme
import com.nasa.voyager.view.steps.HomeScreen
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
