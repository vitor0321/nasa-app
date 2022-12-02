package com.nasa.nasaApp.framework.network.response.asteroids

import com.google.gson.annotations.SerializedName

data class Meters(
    @SerializedName("estimated_diameter_max")
    val estimated_diameter_max: Double,
    @SerializedName("estimated_diameter_min")
    val estimated_diameter_min: Double
)