package com.nasa.nasaApp.ui.components

import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.nasaApp.ui.theme.AppDefaultTypography
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    @StringRes progressTextId: Int = R.string.loading,
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
        Text(
            modifier = modifier,
            text = stringResource(id = progressTextId),
            style = AppDefaultTypography.titleSmall
        )
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
    }
}

@Composable
@Preview
fun ProgressIndicatorLightPreview() {
    NasaBasicTheme(useDarkTheme = false) {
        ProgressIndicator()
    }
}

@Composable
@Preview
fun ProgressIndicatorDarkPreview() {
    NasaBasicTheme(useDarkTheme = true) {
        ProgressIndicator()
    }
}