package com.nasa.voyager.domain

import com.nasa.voyager.domain.model.Asteroids
import java.io.IOException
import java.time.LocalDate

internal interface AsteroidsDataSource {

    suspend fun getAsteroids(
        date: LocalDate,
        okHttpCallError: (IOException) -> Unit,
        okHttpCallbacks: (List<Asteroids>) -> Unit,
    )
}