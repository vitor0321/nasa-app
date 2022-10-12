package com.example.core.usecase

import com.example.core.domain.model.AstronomyDay
import com.example.core.repository.AstronomyRepository
import com.example.core.usecase.base.CoroutinesDispatchers
import com.example.core.usecase.base.ResultStatus
import com.example.core.usecase.base.UseCase
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

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