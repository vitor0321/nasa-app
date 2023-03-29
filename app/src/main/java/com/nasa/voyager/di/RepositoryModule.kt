package com.nasa.voyager.di

import com.nasa.voyager.data.AstronomyDataSourceImpl
import com.nasa.voyager.data.AsteroidsDataSourceImpl
import com.nasa.voyager.domain.AstronomyDataSource
import com.nasa.voyager.domain.AsteroidsDataSource
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