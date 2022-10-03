package com.example.nasaApp.framework.di

import com.example.core.usecase.GetAstronomyDayUseCase
import com.example.core.usecase.GetAstronomyDayUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetAstronomyDayUseCase(useCase: GetAstronomyDayUseCaseImpl): GetAstronomyDayUseCase
}