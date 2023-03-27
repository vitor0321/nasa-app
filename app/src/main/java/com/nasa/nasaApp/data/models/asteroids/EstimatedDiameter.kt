package com.nasa.nasaApp.data.models.asteroids

import com.google.gson.annotations.SerializedName

internal data class EstimatedDiameter(
    @SerializedName("feet")
    val feet: Feet,
    @SerializedName("kilometers")
    val kilometers: Kilometers,
    @SerializedName("meters")
    val meters: Meters,
    @SerializedName("miles")
    val miles: Miles
)