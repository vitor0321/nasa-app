package com.nasa.nasaApp.data.di

import com.nasa.nasaApp.data.AstronomyRepositoryImpl
import com.nasa.nasaApp.data.remote.AstronomyDataSource
import com.nasa.nasaApp.domain.repository.AstronomyRemoteDataSource
import com.nasa.nasaApp.domain.repository.AstronomyRepository
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