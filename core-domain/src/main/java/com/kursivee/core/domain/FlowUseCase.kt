package com.kursivee.core.domain

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<out T, in P> where T: Any {
    abstract suspend fun execute(params: P): Flow<Either<Error, T>>
}