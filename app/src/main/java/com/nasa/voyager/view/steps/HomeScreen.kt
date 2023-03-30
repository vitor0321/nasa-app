package com.nasa.voyager.view.steps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.nasa.voyager.view.steps.astronomy.AstronomyScreen
import com.nasa.voyager.view.utils.Step

internal object HomeScreen: Step("homeScreen") {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
           navigator.push(AstronomyScreen)
        }
    }
}