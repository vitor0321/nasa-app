package com.nasa.nasaApp.framework.network

import com.nasa.nasaApp.framework.network.response.asteroids.DataAsteroidsResponse
import com.nasa.nasaApp.framework.network.response.astronomyDay.DataAstronomyDayResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaApi {

    @GET("planetary/apod")
    suspend fun getAstronomyDay(): DataAstronomyDayResponse

    @GET("planetary/apod")
    suspend fun getAstronomyDayOfDate(
        @Query("date")
        date: String
    ): DataAstronomyDayResponse

    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(
        @Query("start_date")
        startDate: String,
        @Query("end_date")
        endDate: String
    ): DataAsteroidsResponse

    @GET("neo/rest/v1/neo/{asteroidId}")
    suspend fun getAsteroidId(
        @Path("asteroidId")
        asteroidId: Int
    ): DataAsteroidsResponse
}