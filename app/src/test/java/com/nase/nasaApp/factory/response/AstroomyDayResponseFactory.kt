package com.nase.nasaApp.factory.response

import com.nasa.nasaApp.framework.network.response.DataAstronomyDayResponse

class AstronomyDayResponseFactory {

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