package com.nasa.core.repository

import com.nasa.core.model.AstronomyDay

interface AstronomyRepository {

    suspend fun fetchAstronomyDay(): AstronomyDay

    suspend fun getAstronomyDayOfDate(date: String): AstronomyDay
}