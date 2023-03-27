package com.nasa.nasaApp.data

import com.nasa.nasaApp.data.mappers.ResponseMapper
import com.nasa.nasaApp.domain.AsteroidsDataSource
import com.nasa.nasaApp.domain.AstronomyDataSource
import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.domain.model.AstronomyDay
import java.time.LocalDate

internal class AstronomyDataSourceImpl(
    private val nasaApi: NasaApi,
    private val nasaApiAsteroids: AsteroidsDataSource,
) : AstronomyDataSource {

    override suspend fun getAstronomyDay(): AstronomyDay {
        return ResponseMapper.mapToDomain(nasaApi.getAstronomyDay())
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay {
        return ResponseMapper.mapToDomain(nasaApi.getAstronomyDayOfDate(date))
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