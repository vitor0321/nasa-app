package com.nasa.nasaApp.framework.remote

import com.nasa.core.model.Asteroids
import com.nasa.core.model.AstronomyDay
import com.nasa.core.repository.AstronomyRemoteDataSource
import com.nasa.nasaApp.framework.network.NasaApi
import com.nasa.nasaApp.framework.network.NasaApiAsteroids
import com.nasa.nasaApp.framework.network.response.astronomyDay.toAstronomyDay
import java.time.LocalDate
import javax.inject.Inject

class AstronomyDataSource @Inject constructor(
    private val nasaApi: NasaApi,
    private val nasaApiAsteroids: NasaApiAsteroids
) : AstronomyRemoteDataSource {

    override suspend fun fetchAstronomyDay(): AstronomyDay {
        return nasaApi.getAstronomyDay().toAstronomyDay()
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay {
        return nasaApi.getAstronomyDayOfDate(date).toAstronomyDay()
    }

    override suspend fun getAsteroids(date: LocalDate): List<Asteroids> {
        val asteroids = mutableListOf<Asteroids>()
        nasaApiAsteroids.getAsteroids(date) {
            it.map { asteroid ->
                asteroids.add(asteroid)
            }
        }
        return asteroids
    }
}