package com.kursivee.login.domain

import com.kursivee.core.domain.Error
import com.kursivee.core.domain.UseCase
import com.kursivee.core.domain.Either
import com.kursivee.login.domain.model.AuthenticationResponse
import com.kursivee.login.domain.model.AuthenticationRequest

class AuthenticateUseCase(private val repository: Repository): UseCase<AuthenticationResponse, AuthenticationRequest>() {
    override suspend fun execute(params: AuthenticationRequest): Either<Error, AuthenticationResponse> =
        repository.auth(params.username, params.password)
}