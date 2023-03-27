package com.nasa.nasaApp.domain

import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.domain.model.AstronomyDay
import java.time.LocalDate

internal interface AstronomyDataSource {

    suspend fun getAstronomyDay(): AstronomyDay

    suspend fun getAstronomyDayOfDate(date: String): AstronomyDay

    suspend fun getAsteroids(date: LocalDate): List<Asteroids>
}