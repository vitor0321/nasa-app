package com.example.nasaApp.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nasaApp.ui.theme.AppDefaultTypography
import com.example.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R

@Composable
fun ErrorIndicator(
    modifier: Modifier = Modifier,
    @StringRes errorTextId: Int = R.string.error,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Icon(
            modifier = Modifier.size(100.dp),
            imageVector = Icons.Default.Warning,
            contentDescription = stringResource(errorTextId),
            tint = MaterialTheme.colorScheme.error
        )
        Text(
            modifier = modifier,
            text = stringResource(id = errorTextId),
            style = AppDefaultTypography.titleLarge
        )
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
    }
}

@Composable
@Preview
fun ErrorIndicatorLightPreview() {
    NasaBasicTheme(useDarkTheme = false) {
        ErrorIndicator()
    }
}

@Composable
@Preview
fun ErrorIndicatorDarkPreview() {
    NasaBasicTheme(useDarkTheme = true) {
        ErrorIndicator()
    }
}