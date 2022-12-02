package com.nasa.testing.model

import com.nasa.core.model.AstronomyDay

class AstronomyDayFactory {

    fun create(astronomyDay: FakeAstronomyDay) = when (astronomyDay) {
        FakeAstronomyDay.FakeAstronomyDay1 -> AstronomyDay(
            copyright = "Yanninck Akar",
            date = "10-10-2010",
            explanation = "explanation",
            hdurl = "https://apod.nasa.gov/apod/image/2210/Europa_JunoLuck_2611.jpg",
            mediaType = "image",
            title = "title",
            url = "url"
        )
    }

    sealed class FakeAstronomyDay {
        object FakeAstronomyDay1 : FakeAstronomyDay()
    }
}