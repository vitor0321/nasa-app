package com.nasa.nasaApp.domain.usecase

import com.nasa.nasaApp.domain.model.AstronomyDay
import com.nasa.nasaApp.domain.repository.AstronomyRepository
import com.nasa.nasaApp.domain.usecase.base.CoroutinesDispatchers
import com.nasa.nasaApp.domain.usecase.base.ResultStatus
import com.nasa.nasaApp.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface FetchAstronomyDayUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<AstronomyDay>>

    data class Params(val date: String)
}

class FetchAstronomyDayUseCaseImpl @Inject constructor(
    private val astronomyRepository: AstronomyRepository,
    private val dispatchers: CoroutinesDispatchers
) : UseCase<FetchAstronomyDayUseCase.Params, AstronomyDay>(), FetchAstronomyDayUseCase {

    override suspend fun doWork(params: FetchAstronomyDayUseCase.Params): ResultStatus<AstronomyDay> {
        return withContext(dispatchers.io()) {
            val isAstronomyDay = astronomyRepository.fetchAstronomyDay()
            ResultStatus.Success(isAstronomyDay)
        }
    }
}