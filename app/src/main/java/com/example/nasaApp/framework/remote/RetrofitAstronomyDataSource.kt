package com.example.nasaApp.framework.remote

import com.example.core.domain.model.AstronomyDay
import com.example.core.repository.AstronomyRemoteDataSource
import com.example.nasaApp.framework.network.NasaApi
import com.example.nasaApp.framework.network.response.toAstronomyDay
import javax.inject.Inject

class RetrofitAstronomyDataSource @Inject constructor(
    private val nasaApi: NasaApi
) : AstronomyRemoteDataSource {

    override suspend fun fetchAstronomyDay(): AstronomyDay {
        return nasaApi.getAstronomyDay().toAstronomyDay()
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay {
        return nasaApi.getAstronomyDayOfDate(date).toAstronomyDay()
    }
}