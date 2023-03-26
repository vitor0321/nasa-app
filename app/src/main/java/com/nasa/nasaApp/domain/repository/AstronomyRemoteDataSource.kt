package com.nasa.nasaApp.domain.repository

import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.domain.model.AstronomyDay
import java.time.LocalDate

interface AstronomyRemoteDataSource {

    suspend fun fetchAstronomyDay(): AstronomyDay

    suspend fun getAstronomyDayOfDate(date: String): AstronomyDay

    suspend fun getAsteroids(date: LocalDate): List<Asteroids>
}