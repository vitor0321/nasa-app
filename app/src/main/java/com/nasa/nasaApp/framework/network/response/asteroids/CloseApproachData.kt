package com.nasa.nasaApp.framework.network.response.asteroids

import com.google.gson.annotations.SerializedName
import com.nasa.core.model.CloseApproach

data class CloseApproachData(
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

fun CloseApproachData.toCloseApproach(): CloseApproach {
    return CloseApproach(
        closeApproachDate = this.close_approach_date,
        relativeVelocityKmPerHour = this.relative_velocity.kilometers_per_hour,
        relativeVelocityMilesPerHour = this.relative_velocity.miles_per_hour,
        missDistanceKilometers = this.miss_distance.kilometers,
        missDistanceMiles = this.miss_distance.miles,
        orbitingBody = this.orbiting_body
    )
}