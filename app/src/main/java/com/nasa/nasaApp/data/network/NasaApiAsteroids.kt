package com.nasa.nasaApp.data.network

import com.nasa.nasaApp.domain.model.Asteroids
import java.time.LocalDate

interface NasaApiAsteroids {

    suspend fun getAsteroids(date: LocalDate, okHttpCallbacks: (List<Asteroids>) -> Unit)
}