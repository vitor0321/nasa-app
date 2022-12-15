package com.nasa.nasaApp.ui.components.astronomyDay

import android.content.res.Configuration
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nasa.core.model.AstronomyDay
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R

@Composable
fun ImageAstronomy(url: String, @StringRes description: Int? = null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current).data(url)
                .crossfade(true).build(),
            contentDescription = stringResource(id = (description ?: "") as Int),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ImageAstronomyPreview() {
    NasaBasicTheme {
        ImageAstronomy(url = "https://apod.nasa.gov/apod/image/2212/Mars-Stereo.png")
    }
}