package com.nasa.voyager.view.steps.astronomy.area

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nasa.voyager.view.resource.Astronomy
import com.nasa.voyager.view.resource.theme.AppDefaultTypography

@Composable
internal fun HeaderArea(strings: Astronomy, modifier: Modifier) {
    Text(
        text = strings.astronomyPictureOfDay,
        modifier = modifier,
        textAlign = TextAlign.Center,
        style = AppDefaultTypography.titleLarge
    )

    Text(
        text = strings.discoverTheCosmos,
        modifier = modifier,
        textAlign = TextAlign.Center,
        style = AppDefaultTypography.bodyMedium
    )
}