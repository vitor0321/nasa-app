package com.nasa.nasaApp.data.network.response.asteroids

import com.google.gson.annotations.SerializedName
import com.nasa.nasaApp.domain.model.Asteroids

data class CloseEarth(
    @SerializedName("absolute_magnitude_h")
    val absolute_magnitude_h: Double,
    @SerializedName("close_approach_data")
    val close_approach_data: List<CloseApproachData>,
    @SerializedName("estimated_diameter")
    val estimated_diameter: EstimatedDiameter,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_potentially_hazardous_asteroid")
    val is_potentially_hazardous_asteroid: Boolean,
    @SerializedName("is_sentry_object")
    val is_sentry_object: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("nasa_jpl_url")
    val nasa_jpl_url: String,
    @SerializedName("neo_reference_id")
    val neo_reference_id: String,
)

fun CloseEarth.toAsteroids(): Asteroids {
    return Asteroids(
        id = this.id,
        name = this.name,
        absoluteMagnitude = this.absolute_magnitude_h,
        maxDiameterKm = this.estimated_diameter.kilometers.estimated_diameter_max,
        minDiameterKm = this.estimated_diameter.kilometers.estimated_diameter_min,
        maxDiameterMeter = this.estimated_diameter.meters.estimated_diameter_max,
        minDiameterMeter = this.estimated_diameter.meters.estimated_diameter_min,
        isPotentiallyHazardous = this.is_potentially_hazardous_asteroid,
        earthImpact = this.is_sentry_object,
        closeApproachData = this.close_approach_data.map {
            it.toCloseApproach()
        }
    )
}