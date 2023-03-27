package com.nasa.nasaApp.di

import com.nasa.nasaApp.data.NasaApi
import com.nasa.nasaApp.data.interceptor.AuthorizationInterceptor
import com.nasa.nasaApp.di.Constants.TIMEOUT_SECONDS
import com.nasa.nasa_app.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = DI.Module("networkModule") {

    bind<HttpLoggingInterceptor>() with singleton {
        HttpLoggingInterceptor().apply {
            setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else HttpLoggingInterceptor.Level.NONE
            )
        }
    }

    bind<AuthorizationInterceptor>() with singleton {
        AuthorizationInterceptor(
            privateKey = BuildConfig.PRIVATE_KEY,
        )
    }

    bind<OkHttpClient>() with singleton {
        OkHttpClient.Builder()
            .addInterceptor(instance<HttpLoggingInterceptor>())
            .addInterceptor(instance<AuthorizationInterceptor>())
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }

    bind<GsonConverterFactory>() with singleton {
        GsonConverterFactory.create()
    }

    bind<NasaApi>() with singleton {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(instance<OkHttpClient>())
            .addConverterFactory(instance<GsonConverterFactory>())
            .build()
            .create(NasaApi::class.java)
    }
}

internal object Constants {
    const val TIMEOUT_SECONDS = 15L
}
