package com.nasa.nasaApp.view.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.nasaApp.view.resource.theme.AppDefaultTypography
import com.nasa.nasaApp.view.resource.theme.NasaBasicTheme

@Composable
internal fun ProgressIndicator(
    modifier: Modifier = Modifier,
    progressText: String?,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 12.dp))
        CircularProgressIndicator()
        progressText?.let {
            Text(
                modifier = modifier,
                text = it,
                style = AppDefaultTypography.titleSmall
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ProgressIndicatorLightPreview() {
    NasaBasicTheme {
        ProgressIndicator(progressText = null)
    }
}