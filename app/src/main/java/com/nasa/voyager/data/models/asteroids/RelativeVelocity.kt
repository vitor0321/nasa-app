package com.nasa.voyager.data.models.asteroids

import com.google.gson.annotations.SerializedName

internal data class RelativeVelocity(
    @SerializedName("kilometers_per_hour")
    val kilometers_per_hour: String,
    @SerializedName("kilometers_per_second")
    val kilometers_per_second: String,
    @SerializedName("miles_per_hour")
    val miles_per_hour: String
)