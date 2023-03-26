package com.nasa.nasaApp.data.di

import com.nasa.nasaApp.domain.usecase.FetchAstronomyDayUseCase
import com.nasa.nasaApp.domain.usecase.FetchAstronomyDayUseCaseImpl
import com.nasa.nasaApp.domain.usecase.GetAsteroidsUseCase
import com.nasa.nasaApp.domain.usecase.GetAsteroidsUseCaseImpl
import com.nasa.nasaApp.domain.usecase.GetAstronomyDayOfDateUseCase
import com.nasa.nasaApp.domain.usecase.GetAstronomyDayOfDateUseCaseImpl
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

    @Binds
    fun bindGetAsteroidsDateUseCase(useCase: GetAsteroidsUseCaseImpl): GetAsteroidsUseCase
}