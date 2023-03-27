package com.nasa.nasaApp.domain

import com.nasa.nasaApp.domain.model.AstronomyDay

internal interface AstronomyDataSource {

    suspend fun getAstronomyDay(): AstronomyDay?

    suspend fun getAstronomyDayOfDate(date: String): AstronomyDay?

}