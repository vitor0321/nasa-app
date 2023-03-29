package com.nasa.voyager.data.response

import com.nasa.voyager.data.models.astronomyDay.DataAstronomyDayResponse

internal class AstronomyDayResponseFactory {

    fun create(astronomyDay: FakeDataAstronomyDayResponse) = when (astronomyDay) {
        FakeDataAstronomyDayResponse.FakeDataAstronomyDayResponse1 -> DataAstronomyDayResponse(
            copyright = "Yanninck Akar",
            date = "10-10-2010",
            explanation = "explanation",
            hdurl = "https://apod.nasa.gov/apod/image/2210/Europa_JunoLuck_2611.jpg",
            media_type = "image",
            title = "title",
            url = "url"
        )
    }

    sealed class FakeDataAstronomyDayResponse {
        object FakeDataAstronomyDayResponse1 : FakeDataAstronomyDayResponse()
    }
}