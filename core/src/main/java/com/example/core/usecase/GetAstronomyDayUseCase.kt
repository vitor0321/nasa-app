package com.example.core.usecase

import com.example.core.domain.model.AstronomyDay
import com.example.core.repository.AstronomyRepository
import com.example.core.usecase.base.CoroutinesDispatchers
import com.example.core.usecase.base.ResultStatus
import com.example.core.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetAstronomyDayUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<AstronomyDay>>

    data class Params(val data: String)
}

class GetAstronomyDayUseCaseImpl @Inject constructor(
    private val astronomyRepository: AstronomyRepository,
    private val dispatchers: CoroutinesDispatchers
) : UseCase<GetAstronomyDayUseCase.Params, AstronomyDay>(), GetAstronomyDayUseCase {

    override suspend fun doWork(params: GetAstronomyDayUseCase.Params): ResultStatus<AstronomyDay> {
        return withContext(dispatchers.io()) {
            val isFavorite = astronomyRepository.fetchAstronomyDay()
            ResultStatus.Success(isFavorite)
        }
    }

}