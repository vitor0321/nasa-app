package com.nasa.nasaApp.framework.network.response.asteroids

import com.google.gson.annotations.SerializedName

data class MissDistance(
    @SerializedName("astronomical")
    val astronomical: String,
    @SerializedName("kilometers")
    val kilometers: String,
    @SerializedName("lunar")
    val lunar: String,
    @SerializedName("miles")
    val miles: String
)