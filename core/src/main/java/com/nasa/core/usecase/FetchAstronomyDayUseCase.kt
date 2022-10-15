package com.nasa.core.usecase

import com.nasa.core.model.AstronomyDay
import com.nasa.core.repository.AstronomyRepository
import com.nasa.core.usecase.base.CoroutinesDispatchers
import com.nasa.core.usecase.base.ResultStatus
import com.nasa.core.usecase.base.UseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

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