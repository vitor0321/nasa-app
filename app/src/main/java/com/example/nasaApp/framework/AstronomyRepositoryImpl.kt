package com.example.nasaApp.framework

import com.example.core.domain.model.AstronomyDay
import com.example.core.repository.AstronomyRemoteDataSource
import com.example.core.repository.AstronomyRepository
import javax.inject.Inject

class AstronomyRepositoryImpl @Inject constructor(
    private val astronomyRemoteDataSource: AstronomyRemoteDataSource
):AstronomyRepository {

    override suspend fun fetchAstronomyDay(): AstronomyDay {
        return astronomyRemoteDataSource.fetchAstronomyDay()
    }

    override suspend fun getAstronomyDayOfDate(date: String): AstronomyDay {
        return astronomyRemoteDataSource.getAstronomyDayOfDate(date)
    }
}