package com.kursivee.core.domain

sealed class Either<out F, out S> {
    data class Failure<out F>(val failure: F): Either<F, Nothing>()
    data class Success<out S>(val success: S): Either<Nothing, S>()

    val isFailure get() = this is Failure<F>
    val isSuccess get() = this is Success<S>

    fun asSuccess() = this as Success<S>
    fun asFailure() = this as Failure<F>

    fun handle(onFailure: (F) -> Any = {}, onSuccess: (S) -> Any = {}): Any =
        when(this) {
            is Failure -> onFailure(failure)
            is Success -> onSuccess(success)
        }
}

