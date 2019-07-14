package com.kursivee.login.domain

import com.kursivee.core.domain.Error
import com.kursivee.core.domain.UseCase
import com.kursivee.core.domain.Either
import com.kursivee.login.domain.model.AuthRequest
import com.kursivee.login.domain.model.AuthenticationResponse

class AuthenticateUseCase(private val repository: Repository): UseCase<AuthenticationResponse, AuthRequest>() {
    override suspend fun execute(params: AuthRequest): Either<Error, AuthenticationResponse> =
        repository.auth(params.username, params.password)
}