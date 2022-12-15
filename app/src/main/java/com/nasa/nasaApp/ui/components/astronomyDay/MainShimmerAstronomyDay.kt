package com.nasa.nasaApp.ui.components.astronomyDay

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun MainShimmerAstronomyDay() {
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.padding(top = 14.dp))
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column {
                Spacer(modifier = Modifier.padding(top = 18.dp, start = 18.dp, bottom = 16.dp, end = 250.dp).height(30.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(0.dp),
                    border = BorderStroke(1.dp, colorResource(R.color.blue_sky))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Box(modifier = Modifier.size(38.dp).padding(4.dp).clip(CircleShape).shimmer(shimmerInstance).background(color = Color.Gray),contentAlignment = Alignment.CenterStart) {}

                        Spacer(modifier = Modifier.padding(12.dp, end = 200.dp).height(20.dp).fillMaxWidth().shimmer(shimmerInstance).background(color = Color.Gray))

                        Box(modifier = Modifier.size(28.dp).padding(4.dp).shimmer(shimmerInstance).background(color = Color.Gray), contentAlignment = Alignment.CenterStart) {}
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ShimmerMainAstronomyDayPreview() {
    NasaBasicTheme {
        MainShimmerAstronomyDay()
    }
}