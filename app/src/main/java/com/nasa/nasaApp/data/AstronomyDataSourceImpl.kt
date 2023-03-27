package com.nasa.nasaApp.data

import com.nasa.nasaApp.data.mappers.ResponseMapper
import com.nasa.nasaApp.domain.AsteroidsDataSource
import com.nasa.nasaApp.domain.AstronomyDataSource
import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.domain.model.AstronomyDay
import java.time.LocalDate

internal class AstronomyDataSourceImpl(
    private val nasaApi: NasaApi,
) : AstronomyDataSource {

    override suspend fun getAstronomyDay(): AstronomyDay? {
        return ResponseMapper.mapToDomain(nasaApi.getAstronomyDay())
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay? {
        return ResponseMapper.mapToDomain(nasaApi.getAstronomyDayOfDate(date))
    }
}