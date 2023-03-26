package com.nasa.nasaApp.data.di

import com.nasa.nasaApp.data.network.NasaApiAsteroids
import com.nasa.nasaApp.data.network.NasaApiAsteroidsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AsteroidsModule {

    @Binds
    fun bindNasaApiUseCase(useCase: NasaApiAsteroidsImpl): NasaApiAsteroids
}