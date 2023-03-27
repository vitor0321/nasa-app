package com.nasa.nasaApp.view.components

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nasa.nasaApp.view.steps.MainActivity
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class AstronomyDayTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldShow_AstronomyPictureOfTheDay_whenViewIsCreated(): Unit = runBlocking{

    }
}