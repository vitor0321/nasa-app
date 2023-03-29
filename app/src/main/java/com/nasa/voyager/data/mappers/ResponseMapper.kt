package com.nasa.voyager.data.mappers

import com.nasa.voyager.data.models.asteroids.CloseApproachData
import com.nasa.voyager.data.models.asteroids.CloseEarth
import com.nasa.voyager.data.models.astronomyDay.DataAstronomyDayResponse
import com.nasa.voyager.domain.model.Asteroids
import com.nasa.voyager.domain.model.AstronomyDay
import com.nasa.voyager.domain.model.CloseApproach

internal object ResponseMapper {

    fun mapToDomain(response: CloseEarth) = with(response) {
        Asteroids(
            id = id,
            name = name,
            absoluteMagnitude = absolute_magnitude_h,
            maxDiameterKm = estimated_diameter.kilometers.estimated_diameter_max,
            minDiameterKm = estimated_diameter.kilometers.estimated_diameter_min,
            maxDiameterMeter = estimated_diameter.meters.estimated_diameter_max,
            minDiameterMeter = estimated_diameter.meters.estimated_diameter_min,
            isPotentiallyHazardous = is_potentially_hazardous_asteroid,
            earthImpact = is_sentry_object,
            closeApproachData = close_approach_data.map {
                mapToDomain(it)
            }
        )
    }

    private fun mapToDomain(response: CloseApproachData) = with(response) {
        CloseApproach(
            closeApproachDate = close_approach_date,
            relativeVelocityKmPerHour = relative_velocity.kilometers_per_hour,
            relativeVelocityMilesPerHour = relative_velocity.miles_per_hour,
            missDistanceKilometers = miss_distance.kilometers,
            missDistanceMiles = miss_distance.miles,
            orbitingBody = orbiting_body
        )
    }

    fun mapToDomain(response: DataAstronomyDayResponse?) = with(response) {
        this?.let {
            AstronomyDay(
                copyright = copyright,
                date = date,
                explanation = explanation,
                hdurl = hdurl,
                mediaType = media_type,
                title = title,
                url = url
            )
        }
    }
}