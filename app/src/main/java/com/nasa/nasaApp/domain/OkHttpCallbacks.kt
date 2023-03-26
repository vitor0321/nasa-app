package com.nasa.nasaApp.domain

import com.nasa.nasaApp.domain.model.Asteroids

interface OkHttpCallbacks {
    fun onSuccess(asteroids: List<Asteroids>?)
    fun onFailed(error: Throwable?)
}

