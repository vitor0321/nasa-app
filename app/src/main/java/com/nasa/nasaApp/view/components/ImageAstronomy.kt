package com.nasa.nasaApp.view.components

import android.content.res.Configuration
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
import com.nasa.nasaApp.domain.model.AstronomyDay
import com.nasa.nasaApp.view.theme.NasaBasicTheme
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
            },
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current).data(astronomyDay.url)
                .crossfade(true).build(),
            contentDescription = stringResource(id = R.string.astronomy_picture_of_day),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ImageAstronomyPreview() {
    NasaBasicTheme {
        ImageAstronomy(astronomyDay = AstronomyDay(
            copyright = "Marco Lorenzi",
            date = "2022-12-03",
            explanation = "Mars looks sharp in these two rooftop telescope views captured in late " +
                    "November from Singapore, planet Earth. At the time, Mars was about 82 million " +
                    "kilometers from Singapore and approaching its opposition, opposite the Sun in " +
                    "planet Earth's sky on December 8. Olympus Mons, largest of the volcanoes in the " +
                    "Tharsis Montes region (and largest known volcano in the Solar System), is near " +
                    "Mars' western limb. In both the images it's the whitish donut-shape at the upper " +
                    "right. The dark area visible near center is the Terra Sirenum region while the " +
                    "long dark peninsula closest to the planet's eastern limb is Sinus Gomer. Near " +
                    "its tip is Gale crater, the Curiosity rover's landing site in 2012. Above Sinus" +
                    " Gomer, white spots are other volcanoes in the Elysium region. At top of the " +
                    "planet is the north polar cap covered with ice and clouds. Taken about two days " +
                    "apart, these images of the same martian hemisphere form a stereo pair. Look at " +
                    "the center of the frame and cross your eyes until the separate images come together " +
                    "to see the Red Planet in 3D.",
            hdurl = "https://apod.nasa.gov/apod/image/2212/Mars-Stereo.png",
            mediaType = "image",
            title = "Stereo Mars near Opposition",
            url = "https://apod.nasa.gov/apod/image/2212/Mars-Stereo.png"
        ), onClickImage = {})
    }
}