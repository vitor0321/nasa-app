package com.example.core.repository

import com.example.core.domain.model.AstronomyDay

interface AstronomyRemoteDataSource {

    suspend fun fetchAstronomyDay(): AstronomyDay

    suspend fun getAstronomyDayOfDate(date: String): AstronomyDay
}