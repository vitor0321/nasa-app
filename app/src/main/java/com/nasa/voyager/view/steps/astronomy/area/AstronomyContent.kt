package com.nasa.voyager.view.steps.astronomy.area

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.voyager.domain.constants.Constant
import com.nasa.voyager.domain.model.AstronomyDay
import com.nasa.voyager.view.components.ImageAstronomy
import com.nasa.voyager.view.components.LinkifyText
import com.nasa.voyager.view.resource.Astronomy
import com.nasa.voyager.view.resource.LocalStrings
import com.nasa.voyager.view.resource.theme.AppDefaultTypography
import com.nasa.voyager.view.resource.theme.NasaBasicTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun AstronomyContent(
    modifier: Modifier = Modifier,
    astronomyDay: AstronomyDay,
    onClickImage: () -> Unit,
    onClickOpenCalendar: () -> Unit,
) {
    val strings = LocalStrings.current.astronomy

    val date: Date =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(astronomyDay.date) as Date
    val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(date)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.padding(top = 6.dp))

        HeaderArea(strings, modifier)

        Spacer(modifier = Modifier.padding(top = 6.dp))

        DateArea(modifier, onClickOpenCalendar, dateFormat)

        Spacer(modifier = Modifier.padding(top = 6.dp))

        BodyArea(modifier, astronomyDay, onClickImage, strings)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun AstronomyDayIndicatorLightPreview() {
    NasaBasicTheme {
        AstronomyContent(
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