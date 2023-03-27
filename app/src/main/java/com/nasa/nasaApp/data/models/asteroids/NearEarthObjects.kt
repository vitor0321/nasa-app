package com.nasa.nasaApp.data.models.asteroids

import com.google.gson.annotations.SerializedName

internal data class NearEarthObjects(
    @SerializedName("data")
    val data : List<CloseEarth>
)