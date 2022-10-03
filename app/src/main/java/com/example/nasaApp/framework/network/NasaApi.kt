package com.example.nasaApp.framework.network

import com.example.nasaApp.framework.network.response.DataAstronomyDayResponse
import retrofit2.http.GET

interface NasaApi {

    @GET("apod")
    suspend fun getAstronomyDay(): DataAstronomyDayResponse
}