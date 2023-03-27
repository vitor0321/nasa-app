package com.nasa.nasaApp.data.models.asteroids

import com.google.gson.annotations.SerializedName

internal data class Miles(
    @SerializedName("estimated_diameter_max")
    val estimated_diameter_max: Double,
    @SerializedName("estimated_diameter_min")
    val estimated_diameter_min: Double
)