package com.nasa.core

import com.nasa.core.model.Asteroids

interface OkHttpCallbacks {
    fun onSuccess(asteroids: List<Asteroids>?)
    fun onFailed(error: Throwable?)
}

