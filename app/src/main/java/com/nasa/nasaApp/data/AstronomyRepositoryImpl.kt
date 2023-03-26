package com.nasa.nasaApp.data

import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.domain.model.AstronomyDay
import com.nasa.nasaApp.domain.repository.AstronomyRemoteDataSource
import com.nasa.nasaApp.domain.repository.AstronomyRepository
import java.time.LocalDate
import javax.inject.Inject

class AstronomyRepositoryImpl @Inject constructor(
    private val astronomyRemoteDataSource: AstronomyRemoteDataSource
) : AstronomyRepository {

    override suspend fun fetchAstronomyDay(): AstronomyDay {
        return astronomyRemoteDataSource.fetchAstronomyDay()
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay {
        return astronomyRemoteDataSource.getAstronomyDayOfDate(date)
    }

    override suspend fun getAsteroids(date: LocalDate): List<Asteroids> {
        return astronomyRemoteDataSource.getAsteroids(date)
    }
}