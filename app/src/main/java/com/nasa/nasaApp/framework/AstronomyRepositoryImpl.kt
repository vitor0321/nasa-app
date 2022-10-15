package com.nasa.nasaApp.framework

import com.nasa.core.model.AstronomyDay
import com.nasa.core.repository.AstronomyRemoteDataSource
import com.nasa.core.repository.AstronomyRepository
import javax.inject.Inject

class AstronomyRepositoryImpl @Inject constructor(
    private val astronomyRemoteDataSource: AstronomyRemoteDataSource
): AstronomyRepository {

    override suspend fun fetchAstronomyDay(): AstronomyDay {
        return astronomyRemoteDataSource.fetchAstronomyDay()
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay {
        return astronomyRemoteDataSource.getAstronomyDayOfDate(date)
    }
}