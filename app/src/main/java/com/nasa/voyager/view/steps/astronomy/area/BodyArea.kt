package com.nasa.voyager.view.steps.astronomy.area

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nasa.voyager.domain.constants.Constant
import com.nasa.voyager.domain.model.AstronomyDay
import com.nasa.voyager.view.components.ImageAstronomy
import com.nasa.voyager.view.components.LinkifyText
import com.nasa.voyager.view.resource.Astronomy
import com.nasa.voyager.view.resource.theme.AppDefaultTypography

@Composable
internal fun BodyArea(
    modifier: Modifier,
    astronomyDay: AstronomyDay,
    onClickImage: () -> Unit,
    strings: Astronomy,
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
            modifier = modifier.padding(10.dp),
            text = astronomyDay.title,
            textAlign = TextAlign.Center,
            style = AppDefaultTypography.titleMedium
        )
        when (astronomyDay.mediaType) {
            Constant.IMAGE -> ImageAstronomy(astronomyDay = astronomyDay) {
                onClickImage()
            }
            Constant.VIDEO -> {
                Row {
                    Text(text = strings.video)
                    LinkifyText(text = astronomyDay.url)
                }
            }
        }
        if (astronomyDay.copyright != null) {
            Text(
                modifier = modifier,
                text = strings.copyright + " " + astronomyDay.copyright,
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

