package com.kursivee.core.util

sealed class Either<out F, out S> {
    data class Failure<out F>(val failure: F): Either<F, Nothing>()
    data class Success<out S>(val success: S): Either<Nothing, S>()

    val isFailure get() = this is Failure<F>
    val isSuccess get() = this is Success<S>
}