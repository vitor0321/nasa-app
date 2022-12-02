package com.nasa.nasaApp.framework.di

import com.nasa.core.repository.AstronomyRemoteDataSource
import com.nasa.core.repository.AstronomyRepository
import com.nasa.nasaApp.framework.AstronomyRepositoryImpl
import com.nasa.nasaApp.framework.remote.AstronomyDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AstronomyRepositoryModule {

    @Singleton
    @Binds
    fun bindRemoteDataSource(dataSource: AstronomyDataSource): AstronomyRemoteDataSource

    @Singleton
    @Binds
    fun bindAstronomyDataSource(repository: AstronomyRepositoryImpl): AstronomyRepository
}