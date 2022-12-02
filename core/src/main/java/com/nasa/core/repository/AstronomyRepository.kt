package com.nasa.core.repository

import com.nasa.core.model.Asteroids
import com.nasa.core.model.AstronomyDay
import java.time.LocalDate

interface AstronomyRepository {

    suspend fun fetchAstronomyDay(): AstronomyDay

    suspend fun getAstronomyDayOfDate(date: String): AstronomyDay

    suspend fun getAsteroids(date: LocalDate): List<Asteroids>
}