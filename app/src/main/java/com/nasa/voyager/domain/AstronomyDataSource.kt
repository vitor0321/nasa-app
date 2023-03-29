package com.nasa.voyager.domain

import com.nasa.voyager.domain.model.AstronomyDay

internal interface AstronomyDataSource {

    suspend fun getAstronomyDay(): AstronomyDay?

    suspend fun getAstronomyDayOfDate(date: String): AstronomyDay?

}