package com.nasa.nasaApp.ui.components.astronomyDay

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.core.model.AstronomyDay
import com.nasa.nasaApp.ui.common.Constant
import com.nasa.nasaApp.ui.theme.AppDefaultTypography
import com.nasa.nasaApp.ui.theme.LocalExtendedColors
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R

@Composable
fun MainAstronomyDayIndicator(
    astronomyDay: AstronomyDay,
    onClickOpenAstronomyDay: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, colorResource(R.color.blue_sky))
    ) {

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
                modifier = Modifier.padding(10.dp),
                text = astronomyDay.title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = AppDefaultTypography.titleLarge
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {

                Spacer(Modifier.weight(1f))

                Box(modifier = Modifier.size(40.dp)) {
                    OutlinedButton(
                        modifier = Modifier.fillMaxSize(),
                        border = BorderStroke(0.dp, MaterialTheme.colorScheme.primaryContainer),
                        onClick = { onClickOpenAstronomyDay() },
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            Icons.Outlined.KeyboardArrowRight,
                            modifier = Modifier.fillMaxSize(),
                            contentDescription = "go to detail image Astronomy of Day",
                            tint = LocalExtendedColors.current.mars
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                when (astronomyDay.mediaType) {
                    Constant.IMAGE ->
                        ImageAstronomy(astronomyDay.url, R.string.astronomy_picture_of_day)
                    Constant.VIDEO -> {
                        Row {
                            Text(text = stringResource(R.string.video) + " ")
                            LinkifyText(text = astronomyDay.url)
                        }
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun AstronomyDayMainIndicatorPreview() {
    NasaBasicTheme {
        MainAstronomyDayIndicator(
            astronomyDay = AstronomyDay(
                copyright = "Yanninck Akar",
                date = "10-10-2010",
                explanation = "explanation",
                hdurl = "https://apod.nasa.gov/apod/image/2210/Europa_JunoLuck_2611.jpg",
                mediaType = "image",
                title = "title",
                url = "url"
            ),
        ) {}
    }
}