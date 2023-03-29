package com.nasa.voyager.domain.model

internal data class Asteroids(
    val id: String,
    val name: String,
    val absoluteMagnitude: Double,
    val maxDiameterKm: Double,
    val minDiameterKm: Double,
    val maxDiameterMeter: Double,
    val minDiameterMeter: Double,
    val isPotentiallyHazardous: Boolean,
    val earthImpact: Boolean,
    val closeApproachData: List<CloseApproach>? = null
)

internal data class CloseApproach(
    val closeApproachDate: String,
    val relativeVelocityKmPerHour: String,
    val relativeVelocityMilesPerHour: String,
    val missDistanceKilometers: String,
    val missDistanceMiles: String,
    val orbitingBody: String,
)