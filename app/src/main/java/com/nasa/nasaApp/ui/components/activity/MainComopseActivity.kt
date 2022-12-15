package com.nasa.nasaApp.ui.components.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nasa.core.model.AstronomyDay
import com.nasa.nasaApp.ui.components.astronomyDay.MainAstronomyDayIndicator
import com.nasa.nasaApp.ui.components.mars.MainMarsIndicator

@Composable
fun MainComposeActivity(
    astronomyDay: AstronomyDay,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MainMarsIndicator()

            MainAstronomyDayIndicator(astronomyDay = astronomyDay){}
        }
    }
}