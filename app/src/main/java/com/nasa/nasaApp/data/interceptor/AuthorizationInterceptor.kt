package com.nasa.nasaApp.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

internal class AuthorizationInterceptor(
    private val privateKey: String,
) : Interceptor {

    @Suppress("MagicNumber")
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestUrl = request.url

        val hash = privateKey
        val newUrl = requestUrl.newBuilder()
            .addQueryParameter(QUERY_PARAMETER_HASH, hash)
            .build()

        return chain.proceed(
            request.newBuilder()
                .url(newUrl)
                .build()
        )
    }

    companion object {
        private const val QUERY_PARAMETER_HASH = "api_key"
    }
}