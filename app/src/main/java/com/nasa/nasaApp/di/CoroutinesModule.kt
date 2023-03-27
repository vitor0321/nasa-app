package com.nasa.nasaApp.di

import com.nasa.nasaApp.domain.data.AppCoroutinesDispatchers
import com.nasa.nasaApp.domain.data.CoroutinesDispatchers
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val coroutinesModule = DI.Module("coroutinesModule") {

    bind<CoroutinesDispatchers>() with singleton {
        AppCoroutinesDispatchers()
    }
}