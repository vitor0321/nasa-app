package com.example.nasaApp.framework.network.response

import com.example.core.domain.model.AstronomyDay
import com.google.gson.annotations.SerializedName

data class DataAstronomyDayResponse(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val hdurl: String?,
    @SerializedName("media_type")
    val media_type: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)

fun DataAstronomyDayResponse.toAstronomyDay(): AstronomyDay {
    return AstronomyDay(
        copyright = this.copyright,
        date = this.date,
        explanation = this.explanation,
        hdurl = this.hdurl,
        mediaType = this.media_type,
        title = this.title,
        url = this.url
    )
}