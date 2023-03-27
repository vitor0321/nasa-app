package com.nasa.nasaApp.domain

import com.nasa.nasaApp.domain.model.Asteroids
import okhttp3.OkHttpClient
import java.io.IOException
import java.time.LocalDate

internal interface AsteroidsDataSource {

    suspend fun getAsteroids(
        date: LocalDate,
        okHttpCallError: (IOException) -> Unit,
        okHttpCallbacks: (List<Asteroids>) -> Unit,
    )
}