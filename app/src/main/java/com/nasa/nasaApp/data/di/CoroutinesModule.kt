package com.nasa.nasaApp.data.di

import com.nasa.nasaApp.domain.usecase.base.AppCoroutinesDispatchers
import com.nasa.nasaApp.domain.usecase.base.CoroutinesDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoroutinesModule {

    @Singleton
    @Binds
    fun bindDispatcher(dispatchers: AppCoroutinesDispatchers): CoroutinesDispatchers
}