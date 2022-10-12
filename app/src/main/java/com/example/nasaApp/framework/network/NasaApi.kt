package com.example.nasaApp.framework.network

import com.example.nasaApp.framework.network.response.DataAstronomyDayResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaApi {

    @GET("apod")
    suspend fun getAstronomyDay(): DataAstronomyDayResponse

    @GET("apod")
    suspend fun getAstronomyDayOfDate(
        @Query("date")
        date: String
    ): DataAstronomyDayResponse
}