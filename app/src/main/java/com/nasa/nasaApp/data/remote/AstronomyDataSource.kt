package com.nasa.nasaApp.data.remote

import com.nasa.nasaApp.data.network.NasaApi
import com.nasa.nasaApp.data.network.NasaApiAsteroids
import com.nasa.nasaApp.data.network.response.astronomyDay.toAstronomyDay
import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.domain.model.AstronomyDay
import com.nasa.nasaApp.domain.repository.AstronomyRemoteDataSource
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