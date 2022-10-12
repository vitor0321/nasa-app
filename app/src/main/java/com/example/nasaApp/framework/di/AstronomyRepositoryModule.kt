package com.example.nasaApp.framework.di

import com.example.core.repository.AstronomyRemoteDataSource
import com.example.core.repository.AstronomyRepository
import com.example.nasaApp.framework.AstronomyRepositoryImpl
import com.example.nasaApp.framework.remote.RetrofitAstronomyDataSource
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
    fun bindRemoteDataSource(dataSource: RetrofitAstronomyDataSource): AstronomyRemoteDataSource

    @Singleton
    @Binds
    fun bindAstronomyDataSource(repository: AstronomyRepositoryImpl): AstronomyRepository
}