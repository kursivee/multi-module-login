package com.kursivee.login.domain

import com.kursivee.core.domain.Error
import com.kursivee.core.domain.Either
import com.kursivee.login.domain.model.AuthenticationResponse
import com.kursivee.login.domain.model.AuthorizeResponse

interface Repository {
    suspend fun auth(username: String, password: String): Either<Error, AuthenticationResponse>
    suspend fun authorize(token: String): Either<Error, AuthorizeResponse>
}