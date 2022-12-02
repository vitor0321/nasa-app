package com.nasa.nasaApp.framework.network

import com.nasa.core.model.Asteroids
import java.time.LocalDate

interface NasaApiAsteroids {

    suspend fun getAsteroids(date: LocalDate, okHttpCallbacks: (List<Asteroids>) -> Unit)
}