package com.example.nasaApp.framework.di

import com.example.core.usecase.FetchAstronomyDayUseCase
import com.example.core.usecase.FetchAstronomyDayUseCaseImpl
import com.example.core.usecase.GetAstronomyDayOfDateUseCase
import com.example.core.usecase.GetAstronomyDayOfDateUseCaseImpl
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