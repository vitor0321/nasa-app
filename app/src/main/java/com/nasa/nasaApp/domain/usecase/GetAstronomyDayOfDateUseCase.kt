package com.nasa.nasaApp.domain.usecase

import com.nasa.nasaApp.domain.model.AstronomyDay
import com.nasa.nasaApp.domain.repository.AstronomyRepository
import com.nasa.nasaApp.domain.usecase.base.CoroutinesDispatchers
import com.nasa.nasaApp.domain.usecase.base.ResultStatus
import com.nasa.nasaApp.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

interface GetAstronomyDayOfDateUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<AstronomyDay>>

    data class Params(val date: LocalDate)
}

class GetAstronomyDayOfDateUseCaseImpl @Inject constructor(
    private val astronomyRepository: AstronomyRepository,
    private val dispatchers: CoroutinesDispatchers
) : UseCase<GetAstronomyDayOfDateUseCase.Params, AstronomyDay>(), GetAstronomyDayOfDateUseCase {

    override suspend fun doWork(params: GetAstronomyDayOfDateUseCase.Params): ResultStatus<AstronomyDay> {
        return withContext(dispatchers.io()) {
            val date = "${params.date.year}-${params.date.monthValue}-${params.date.dayOfMonth}"
            val isAstronomyDay = astronomyRepository.getAstronomyDayOfDate(date)
            ResultStatus.Success(isAstronomyDay)
        }
    }
}