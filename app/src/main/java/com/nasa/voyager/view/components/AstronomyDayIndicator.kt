package com.nasa.voyager.view.components

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.voyager.domain.constants.Constant
import com.nasa.voyager.domain.model.AstronomyDay
import com.nasa.voyager.view.resource.LocalStrings
import com.nasa.voyager.view.resource.theme.AppDefaultTypography
import com.nasa.voyager.view.resource.theme.NasaBasicTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun AstronomyDayIndicator(
    modifier: Modifier = Modifier,
    astronomyDay: AstronomyDay,
    onClickImage: () -> Unit,
    onClickOpenCalendar: () -> Unit
) {
    val strings = LocalStrings.current.components

    val date: Date =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(astronomyDay.date) as Date
    val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(date)

    val state = rememberSaveable(saver = AstronomyStateSaver) {
        AstronomyDay(
            copyright = astronomyDay.copyright,
            date = astronomyDay.date,
            explanation = astronomyDay.explanation,
            hdurl = astronomyDay.hdurl,
            mediaType = astronomyDay.mediaType,
            title = astronomyDay.title,
            url = astronomyDay.url
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(top = 6.dp))
        Text(
            modifier = modifier,
            textAlign = TextAlign.Center,
            text = strings.astronomyPictureOfDay,
            style = AppDefaultTypography.titleLarge
        )
        Text(
            modifier = modifier,
            textAlign = TextAlign.Center,
            text = strings.discoverTheCosmos,
            style = AppDefaultTypography.bodyMedium
        )
        Spacer(modifier = Modifier.padding(top = 6.dp))
        Box(
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(5.dp)
                )
                .align(Alignment.End)
                .clickable { onClickOpenCalendar() }
        ) {
            Text(
                text = dateFormat,
                Modifier.padding(6.dp),
                style = AppDefaultTypography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Spacer(modifier = Modifier.padding(top = 6.dp))
        Column(
            modifier = Modifier
                .verticalScroll(state = ScrollState(1))
                .fillMaxWidth()
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Text(
                modifier = modifier.padding(10.dp),
                text = state.title,
                textAlign = TextAlign.Center,
                style = AppDefaultTypography.titleMedium
            )
            when (state.mediaType) {
                Constant.IMAGE -> ImageAstronomy(astronomyDay = state, onClickImage)
                Constant.VIDEO -> {
                    Row {
                        Text(text = strings.video)
                        LinkifyText(text = state.url)
                    }
                }
            }
            if (state.copyright != null) {
                Text(
                    modifier = modifier,
                    text = strings.copyright + " " + state.copyright,
                    style = AppDefaultTypography.bodySmall
                )
            }
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Text(
                modifier = modifier.padding(8.dp),
                text = state.explanation,
                style = AppDefaultTypography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(bottom = 12.dp))
        }
    }
}

private val AstronomyStateSaver = run {
    val copyright = "copyright"
    val date = "date"
    val explanation = "explanation"
    val hdurl = "hdurl"
    val mediaType = "mediaType"
    val title = "title"
    val url = "url"

    mapSaver(
        save = { state: AstronomyDay ->
            mapOf(
                copyright to state.copyright,
                date to state.date,
                explanation to state.explanation,
                hdurl to state.hdurl,
                mediaType to state.mediaType,
                title to state.title,
                url to state.url
            )
        },
        restore = { restorarionMap: Map<String, Any?> ->
            AstronomyDay(
                copyright = restorarionMap[copyright] as String?,
                date = restorarionMap[date] as String,
                explanation = restorarionMap[explanation] as String,
                hdurl = restorarionMap[hdurl] as String?,
                mediaType = restorarionMap[mediaType] as String,
                title = restorarionMap[title] as String,
                url = restorarionMap[url] as String,
            )
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun AstronomyDayIndicatorLightPreview() {
    NasaBasicTheme {
        AstronomyDayIndicator(
            astronomyDay = AstronomyDay(
                copyright = "Yanninck Akar",
                date = "10-10-2010",
                explanation = "explanation",
                hdurl = "https://apod.nasa.gov/apod/image/2210/Europa_JunoLuck_2611.jpg",
                mediaType = "image",
                title = "title",
                url = "url"
            ),
            onClickImage = {},
            onClickOpenCalendar = {}
        )
    }
}