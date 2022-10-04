package com.example.nasaApp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R

@Composable
fun ImageFullIndicator(
    modifier: Modifier = Modifier,
    image: String
) {
    Box() {
        AsyncImage(
            modifier = Modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(id = R.string.astronomy_picture_of_day),
        )
    }
}

@Composable
@Preview
fun ImageFullIndicatorLightPreview() {
    NasaBasicTheme(useDarkTheme = false) {
        ImageFullIndicator(
            image = "https://apod.nasa.gov/apod/image/2210/Europa_JunoLuck_2611.jpg"
        )
    }
}

@Composable
@Preview
fun ImageFullIndicatorDarkPreview() {
    NasaBasicTheme(useDarkTheme = true) {
        ImageFullIndicator(
            image = "https://apod.nasa.gov/apod/image/2210/Europa_JunoLuck_2611.jpg"
        )
    }
}