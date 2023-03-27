package com.nasa.nasaApp.view.components

import android.content.res.Configuration
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
import com.nasa.nasaApp.view.resource.LocalStrings
import com.nasa.nasaApp.view.resource.theme.AppDefaultTypography
import com.nasa.nasaApp.view.resource.theme.NasaBasicTheme
import java.io.IOException

@Composable
internal fun ErrorIndicator(
    exception: IOException?,
    modifier: Modifier = Modifier,
    errorText: String?,
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
            contentDescription =errorText,
            tint = MaterialTheme.colorScheme.error
        )
        errorText?.let {
            Text(
                modifier = modifier,
                text = it,
                style = AppDefaultTypography.titleLarge
            )
        }
        exception?.message?.let {
            Text(
                modifier = modifier,
                text = it,
                style = AppDefaultTypography.titleLarge
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ErrorIndicatorLightPreview() {
    NasaBasicTheme {
        ErrorIndicator(null, errorText = null)
    }
}