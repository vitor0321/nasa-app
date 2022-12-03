package com.nasa.nasaApp.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.core.model.AstronomyDay
import com.nasa.nasaApp.ui.common.Constant
import com.nasa.nasaApp.ui.theme.AppDefaultTypography
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AstronomyDayIndicator(
    modifier: Modifier = Modifier,
    astronomyDay: AstronomyDay,
    onClickImage: () -> Unit,
    onClickOpenCalendar: () -> Unit
) {
    val date: Date =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(astronomyDay.date) as Date
    val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(date)

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
            text = stringResource(id = R.string.astronomy_picture_of_day),
            style = AppDefaultTypography.titleLarge
        )
        Text(
            modifier = modifier,
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.discover_the_cosmos),
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
                text = astronomyDay.title,
                textAlign = TextAlign.Center,
                style = AppDefaultTypography.titleMedium
            )
            when (astronomyDay.mediaType) {
                Constant.IMAGE -> ImageAstronomy(astronomyDay = astronomyDay, onClickImage)
                Constant.VIDEO -> {
                    Row {
                        Text(text = stringResource(R.string.video) + " ")
                        LinkifyText(text = astronomyDay.url)
                    }
                }
            }
            if (astronomyDay.copyright != null) {
                Text(
                    modifier = modifier,
                    text = stringResource(R.string.copyright) + " " + astronomyDay.copyright!!,
                    style = AppDefaultTypography.bodySmall
                )
            }
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Text(
                modifier = modifier.padding(8.dp),
                text = astronomyDay.explanation,
                style = AppDefaultTypography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(bottom = 12.dp))
        }
    }
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