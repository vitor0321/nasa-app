package com.nasa.nasaApp.data.models.asteroids

import com.google.gson.annotations.SerializedName
import com.nasa.nasaApp.domain.model.Asteroids

internal data class CloseEarth(
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