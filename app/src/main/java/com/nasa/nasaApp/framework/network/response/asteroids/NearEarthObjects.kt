package com.nasa.nasaApp.framework.network.response.asteroids

import com.google.gson.annotations.SerializedName

data class NearEarthObjects(
    @SerializedName("data")
    val data : List<CloseEarth>
)