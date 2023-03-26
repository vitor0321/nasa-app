package com.nasa.nasaApp.data.network

import com.google.gson.GsonBuilder
import com.nasa.nasaApp.data.di.qualifier.BaseUrl
import com.nasa.nasaApp.data.network.response.asteroids.CloseEarth
import com.nasa.nasaApp.data.network.response.asteroids.toAsteroids
import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.view.common.Constant.SEVEN_DAY
import com.nasa.nasa_app.BuildConfig
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import org.json.JSONTokener
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class NasaApiAsteroidsImpl @Inject constructor(
    @BaseUrl private val baseUrl: String,
    private val okHttpClient: OkHttpClient,
) : NasaApiAsteroids {

    override suspend fun getAsteroids(date: LocalDate, okHttpCallbacks: (List<Asteroids>) -> Unit) {
        val asteroidsList = mutableListOf<Asteroids>()

        val formatters: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val dateString = date.format(formatters)

        val datePlusSeven: LocalDate = date.plusDays(SEVEN_DAY)

        val url =
            baseUrl + "neo/rest/v1/feed?start_date=" + dateString + "&end_date=" + datePlusSeven + "&" + BuildConfig.PRIVATE_KEY

        val request = Request.Builder().url(url).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val data = response.body?.string()
                    val gson = GsonBuilder().create()
                    val jsonData = JSONTokener(data).nextValue() as JSONObject
                    val jsonNearEarthObjects = jsonData.getJSONObject("near_earth_objects")

                    val closeEarth = jsonNearEarthObjects.getString(dateString)
                    val closeEarthList =
                        gson.fromJson(closeEarth, Array<CloseEarth>::class.java)

                    closeEarthList.map { asteroidsList.add(it.toAsteroids()) }
                    okHttpCallbacks(asteroidsList)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                okHttpCallbacks
            }
        })
    }
}