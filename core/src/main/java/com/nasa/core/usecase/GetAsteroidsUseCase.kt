package com.nasa.core.usecase

import com.nasa.core.model.Asteroids
import com.nasa.core.repository.AstronomyRepository
import com.nasa.core.usecase.base.CoroutinesDispatchers
import com.nasa.core.usecase.base.ResultStatus
import com.nasa.core.usecase.base.UseCase
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface GetAsteroidsUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<List<Asteroids>>>

    data class Params(val date: LocalDate)
}

class GetAsteroidsUseCaseImpl @Inject constructor(
    private val astronomyRepository: AstronomyRepository,
    private val dispatchers: CoroutinesDispatchers
) : UseCase<GetAsteroidsUseCase.Params, List<Asteroids>>(), GetAsteroidsUseCase {

    override suspend fun doWork(params: GetAsteroidsUseCase.Params): ResultStatus<List<Asteroids>>{
        return withContext(dispatchers.io()) {
            val isAsteroids = astronomyRepository.getAsteroids(params.date)
            ResultStatus.Success(isAsteroids)
        }
    }
}