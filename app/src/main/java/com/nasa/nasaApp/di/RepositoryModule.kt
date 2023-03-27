package com.nasa.nasaApp.di

import com.nasa.nasaApp.data.AstronomyDataSourceImpl
import com.nasa.nasaApp.data.AsteroidsDataSourceImpl
import com.nasa.nasaApp.domain.AstronomyDataSource
import com.nasa.nasaApp.domain.AsteroidsDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule = DI.Module("repositoryModule") {

    bind<AstronomyDataSource>() with singleton {
        AstronomyDataSourceImpl(instance())
    }

    bind<AsteroidsDataSource>() with singleton {
        AsteroidsDataSourceImpl(instance())
    }
}