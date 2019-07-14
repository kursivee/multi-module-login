package com.kursivee.core.domain

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out T, in P> where T: Any {
    abstract suspend fun execute(params: P): Either<Error, T>

    operator fun invoke(params: P, onResult: (Either<Error, T>) -> Unit = {}) {
        val job = GlobalScope.async {
            execute(params)
        }
        GlobalScope.launch {
            onResult(job.await())
        }
    }
}