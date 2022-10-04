package com.example.nasaApp.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.core.domain.model.AstronomyDay
import com.example.nasaApp.ui.common.Constant
import com.example.nasaApp.ui.theme.AppDefaultTypography
import com.example.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R

@Composable
fun AstronomyDayIndicator(
    modifier: Modifier = Modifier,
    astronomyDay: AstronomyDay,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(top = 12.dp))
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
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Text(
            modifier = modifier.align(Alignment.End),
            text = astronomyDay.date,
            style = AppDefaultTypography.titleSmall
        )
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
                Constant.IMAGE ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth(1f)
                            .fillMaxHeight(1f)
                            .clickable {

                            }
                    ) {
                        AsyncImage(
                            modifier = Modifier,
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(astronomyDay.url)
                                .crossfade(true)
                                .build(),
                            contentDescription = stringResource(id = R.string.astronomy_picture_of_day),
                            contentScale = ContentScale.Crop
                        )
                    }
            }
            if (astronomyDay.copyright != null) {
                Text(
                    modifier = modifier,
                    text = stringResource(R.string.copyright) + astronomyDay.copyright!!,
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

@Composable
@Preview
fun AstronomyDayIndicatorLightPreview() {
    NasaBasicTheme(useDarkTheme = false) {
        AstronomyDayIndicator(
            astronomyDay = AstronomyDay(
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

@Composable
@Preview
fun AstronomyDayIndicatorDarkPreview() {
    NasaBasicTheme(useDarkTheme = true) {
        AstronomyDayIndicator(
            astronomyDay = AstronomyDay(
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