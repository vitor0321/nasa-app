package com.nasa.nasaApp.framework.remote

import com.nasa.core.model.AstronomyDay
import com.nasa.core.repository.AstronomyRemoteDataSource
import com.nasa.nasaApp.framework.network.NasaApi
import com.nasa.nasaApp.framework.network.response.toAstronomyDay
import javax.inject.Inject

class AstronomyDataSource @Inject constructor(
    private val nasaApi: NasaApi
) : AstronomyRemoteDataSource {

    override suspend fun fetchAstronomyDay(): AstronomyDay {
        return nasaApi.getAstronomyDay().toAstronomyDay()
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay {
        return nasaApi.getAstronomyDayOfDate(date).toAstronomyDay()
    }
}