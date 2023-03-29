package com.nasa.voyager.data.models.asteroids

import com.google.gson.annotations.SerializedName

internal data class CloseApproachData(
    @SerializedName("close_approach_date")
    val close_approach_date: String,
    @SerializedName("close_approach_date_full")
    val close_approach_date_full: String,
    @SerializedName("epoch_date_close_approach")
    val epoch_date_close_approach: Long,
    @SerializedName("miss_distance")
    val miss_distance: MissDistance,
    @SerializedName("orbiting_body")
    val orbiting_body: String,
    @SerializedName("relative_velocity")
    val relative_velocity: RelativeVelocity
)
