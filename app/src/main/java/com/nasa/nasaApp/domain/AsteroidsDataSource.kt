package com.nasa.nasaApp.domain

import com.nasa.nasaApp.domain.model.Asteroids
import java.time.LocalDate

internal interface AsteroidsDataSource {

    suspend fun getAsteroids(date: LocalDate, okHttpCallbacks: (List<Asteroids>) -> Unit)
}