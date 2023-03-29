package com.nasa.voyager.di

import com.nasa.voyager.domain.data.AppCoroutinesDispatchers
import com.nasa.voyager.domain.data.CoroutinesDispatchers
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val coroutinesModule = DI.Module("coroutinesModule") {

    bind<CoroutinesDispatchers>() with singleton {
        AppCoroutinesDispatchers()
    }
}