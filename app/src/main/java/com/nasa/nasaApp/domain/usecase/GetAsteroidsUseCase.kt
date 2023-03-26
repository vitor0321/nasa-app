package com.nasa.nasaApp.domain.usecase

import com.nasa.nasaApp.domain.model.Asteroids
import com.nasa.nasaApp.domain.repository.AstronomyRepository
import com.nasa.nasaApp.domain.usecase.base.CoroutinesDispatchers
import com.nasa.nasaApp.domain.usecase.base.ResultStatus
import com.nasa.nasaApp.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

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