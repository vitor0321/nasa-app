package com.nasa.voyager.data

import com.nasa.voyager.data.models.astronomyDay.DataAstronomyDayResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NasaApi {

    @GET("planetary/apod")
    suspend fun getAstronomyDay(): DataAstronomyDayResponse

    @GET("planetary/apod")
    suspend fun getAstronomyDayOfDate(
        @Query("date")
        date: String
    ): DataAstronomyDayResponse
}