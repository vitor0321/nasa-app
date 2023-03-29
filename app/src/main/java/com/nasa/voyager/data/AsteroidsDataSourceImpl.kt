package com.nasa.voyager.data

import com.google.gson.GsonBuilder
import com.nasa.voyager.data.mappers.ResponseMapper
import com.nasa.voyager.data.models.asteroids.CloseEarth
import com.nasa.voyager.domain.AsteroidsDataSource
import com.nasa.voyager.domain.model.Asteroids
import com.nasa.voyager.domain.constants.Constant.SEVEN_DAY
import com.nasa.voyager.BuildConfig
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

internal class AsteroidsDataSourceImpl(
    private val okHttpClient: OkHttpClient,
) : AsteroidsDataSource {

    override suspend fun getAsteroids(
        date: LocalDate,
        okHttpCallError: (IOException) -> Unit,
        okHttpCallbacks: (List<Asteroids>) -> Unit,
    ) {
        val asteroidsList = mutableListOf<Asteroids>()

        val formatters: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val dateString = date.format(formatters)

        val datePlusSeven: LocalDate = date.plusDays(SEVEN_DAY)

        val url =
            BuildConfig.BASE_URL + "neo/rest/v1/feed?start_date=" + dateString + "&end_date=" + datePlusSeven + "&" + BuildConfig.PRIVATE_KEY

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

                    closeEarthList.map { asteroidsList.add(ResponseMapper.mapToDomain(it)) }
                    okHttpCallbacks(asteroidsList)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                okHttpCallError(e)
            }
        })
    }
}