package com.nasa.nasaApp.data.models.astronomyDay

import com.google.gson.annotations.SerializedName
import com.nasa.nasaApp.domain.model.AstronomyDay

internal data class DataAstronomyDayResponse(
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