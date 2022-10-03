package com.example.nasaApp.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nasaApp.ui.theme.NasaBasicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AstronomyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()

        setContent {
            NasaBasicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Greeting("Android Vitor")
                }
            }
        }
    }

    private fun initObserver(){
        viewModel.state.observe(this) { uiSate ->
            when(uiSate){
                is AstronomyViewModel.UiState.Loading -> {
                    Log.d("state","Loading")
                }
                is AstronomyViewModel.UiState.Success -> {
                    uiSate.astronomyDay
                    Log.d("state","Sucesso")
                }
                is AstronomyViewModel.UiState.Error -> {
                    Log.d("state","Error")
                }
            }
        }
        viewModel.getAstronomyDay()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NasaBasicTheme {
        Greeting("Android")
    }
}