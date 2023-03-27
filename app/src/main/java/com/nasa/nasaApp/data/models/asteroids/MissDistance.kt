package com.nasa.nasaApp.data.models.asteroids

import com.google.gson.annotations.SerializedName

internal data class MissDistance(
    @SerializedName("astronomical")
    val astronomical: String,
    @SerializedName("kilometers")
    val kilometers: String,
    @SerializedName("lunar")
    val lunar: String,
    @SerializedName("miles")
    val miles: String
)