package com.nasa.nasaApp.ui.components.mars

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nasa.nasaApp.ui.theme.AppDefaultTypography
import com.nasa.nasaApp.ui.theme.LocalExtendedColors
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R

@Composable
fun MainMarsIndicator() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.padding(top = 6.dp))
        Box(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    text = "Explore",
                    style = AppDefaultTypography.headlineSmall,
                )
                SettingsItemAnimated()
            }
        }
    }
}

@Composable
private fun SettingsItemAnimated() {
    val expanded = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, colorResource(R.color.blue_sky))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.CenterStart
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_mars),
                    contentDescription = null,
                    modifier = Modifier.padding(2.dp).fillMaxSize(),
                    colorFilter = ColorFilter.tint(LocalExtendedColors.current.mars)
                )
            }
            Text(
                modifier = Modifier.padding(12.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                text = "Mars",
                style = AppDefaultTypography.titleLarge,
            )
            Spacer(Modifier.weight(1f))
            Box(modifier = Modifier.size(28.dp)) {
                OutlinedButton(
                    modifier = Modifier.height(32.dp),
                    border = BorderStroke(0.dp, MaterialTheme.colorScheme.primaryContainer),
                    onClick = {
                        if (expanded.value) expanded.value = !expanded.value else expanded.value = !expanded.value
                    },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        if (expanded.value) Icons.Outlined.ArrowDropDown else Icons.Outlined.KeyboardArrowUp,
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "expand",
                        tint = LocalExtendedColors.current.mars
                    )
                }
            }
        }
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(2.dp, colorResource(R.color.blue_sky))
    ) {
        Column(
            modifier = Modifier
        ) {
            AnimatedVisibility(visible = expanded.value) {
                ListRovers()
            }
        }
    }
}

@Composable
private fun ListRovers() {
    Column {
        Rovers(name = "Curiosity", R.drawable.ic_curiosity)
        Rovers(name = "Opportunity", R.drawable.ic_oportunity)
        Rovers(name = "Spirit", R.drawable.ic_spirit)
    }
}

@Composable
private fun Rovers(name: String, @DrawableRes image: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, colorResource(R.color.blue_sky))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Box(modifier = Modifier.size(28.dp).clip(CircleShape)) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.padding(2.dp).fillMaxSize(),
                    colorFilter = ColorFilter.tint(LocalExtendedColors.current.mars)
                )
            }
            Box(modifier = Modifier.width(110.dp).height(50.dp),) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 18.dp, start = 18.dp)
                        .clickable { },
                    textAlign = TextAlign.Start,
                    text = name,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 16.sp,
                    style = AppDefaultTypography.titleSmall
                )
            }
            Spacer(Modifier.weight(1f))
            Box(modifier = Modifier.size(28.dp)) {
                OutlinedButton(
                    modifier = Modifier.height(60.dp).align(Alignment.CenterEnd),
                    border = BorderStroke(0.dp, MaterialTheme.colorScheme.primaryContainer),
                    onClick = {},
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        Icons.Outlined.KeyboardArrowRight,
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "navigation to $name, image",
                        tint = LocalExtendedColors.current.mars
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun MarsMainIndicatorPreview() {
    NasaBasicTheme {
        MainMarsIndicator()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ListRoversPreview() {
    NasaBasicTheme {
        ListRovers()
    }
}