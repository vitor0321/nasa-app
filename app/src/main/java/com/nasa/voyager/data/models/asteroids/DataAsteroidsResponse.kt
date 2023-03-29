package com.nasa.voyager.data.models.asteroids

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class DataAsteroidsResponse(
    @SerializedName("near_earth_objects")
    val near_earth_objects: NearEarthObjects
)