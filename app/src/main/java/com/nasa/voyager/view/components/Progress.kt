package com.nasa.voyager.view.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.voyager.view.resource.theme.AppDefaultTypography
import com.nasa.voyager.view.resource.theme.NasaBasicTheme

@Composable
internal fun ProgressIndicator(
    modifier: Modifier = Modifier,
    progressText: String?,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        progressText?.let {
            Text(
                modifier = modifier,
                text = it,
                style = AppDefaultTypography.titleSmall
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ProgressIndicatorLightPreview() {
    NasaBasicTheme {
        ProgressIndicator(progressText = "Loading")
    }
}