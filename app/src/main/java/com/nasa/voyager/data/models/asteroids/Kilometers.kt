package com.nasa.voyager.data.models.asteroids

import com.google.gson.annotations.SerializedName

internal data class Kilometers(
    @SerializedName("estimated_diameter_max")
    val estimated_diameter_max: Double,
    @SerializedName("estimated_diameter_min")
    val estimated_diameter_min: Double
)