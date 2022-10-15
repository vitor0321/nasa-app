package com.nasa.nasaApp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nasa.core.model.AstronomyDay
import com.nasa.nasa_app.R

@Composable
fun ImageAstronomy(
    astronomyDay: AstronomyDay,
    onClickImage: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClickImage()
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