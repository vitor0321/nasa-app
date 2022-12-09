package com.nasa.nasaApp.ui.components

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.nasaApp.ui.theme.AppDefaultTypography
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerAstronomyDay() {
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 18.dp, end = 70.dp, start = 70.dp).height(18.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))

        Spacer(modifier = Modifier.padding(top = 4.dp, end = 30.dp, start = 30.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 50.dp, start = 50.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 60.dp, start = 60.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 100.dp, start = 100.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))

        Spacer(modifier = Modifier.padding(top = 6.dp, end = 4.dp, start = 300.dp).height(14.dp).fillMaxWidth().shimmer(shimmerInstance).align(Alignment.End).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 30.dp, end = 70.dp, start = 70.dp).height(18.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 8.dp, end = 16.dp, start = 16.dp).height(250.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 2.dp, end = 100.dp, start = 100.dp).height(8.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))


        Spacer(modifier = Modifier.padding(top = 8.dp, end = 30.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 50.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 60.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 100.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 30.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 50.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 60.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 100.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 30.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 50.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 60.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 100.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 8.dp, end = 30.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 50.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 60.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 100.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 30.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 50.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 60.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 100.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 30.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 50.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 60.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
        Spacer(modifier = Modifier.padding(top = 4.dp, end = 100.dp, start = 16.dp).height(12.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ProgressIndicatorLightPreview() {
    NasaBasicTheme {
        ShimmerAstronomyDay()
    }
}