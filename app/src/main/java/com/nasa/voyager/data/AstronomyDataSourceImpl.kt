package com.nasa.voyager.data

import com.nasa.voyager.data.mappers.ResponseMapper
import com.nasa.voyager.domain.AstronomyDataSource
import com.nasa.voyager.domain.model.AstronomyDay

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