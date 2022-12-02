package com.nasa.nasaApp.framework.network.response.asteroids

import com.google.gson.annotations.SerializedName

data class EstimatedDiameter(
    @SerializedName("feet")
    val feet: Feet,
    @SerializedName("kilometers")
    val kilometers: Kilometers,
    @SerializedName("meters")
    val meters: Meters,
    @SerializedName("miles")
    val miles: Miles
)