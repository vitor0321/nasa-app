package com.example.nasaApp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.example.nasaApp.ui.theme.NasaBasicTheme

@Composable
fun ImageFullIndicator(
    modifier: Modifier = Modifier,
    image: String
) {
    Box() {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .fillMaxWidth()

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