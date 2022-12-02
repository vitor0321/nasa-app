package com.nasa.nasaApp.framework.network.response.asteroids

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataAsteroidsResponse(
    @SerializedName("near_earth_objects")
    val near_earth_objects: NearEarthObjects
)