package com.nasa.nasaApp.framework.di

import com.nasa.core.usecase.FetchAstronomyDayUseCase
import com.nasa.core.usecase.FetchAstronomyDayUseCaseImpl
import com.nasa.core.usecase.GetAstronomyDayOfDateUseCase
import com.nasa.core.usecase.GetAstronomyDayOfDateUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetAstronomyDayUseCase(useCase: FetchAstronomyDayUseCaseImpl): FetchAstronomyDayUseCase

    @Binds
    fun bindGetAstronomyDayOfDateUseCase(useCase: GetAstronomyDayOfDateUseCaseImpl): GetAstronomyDayOfDateUseCase
}