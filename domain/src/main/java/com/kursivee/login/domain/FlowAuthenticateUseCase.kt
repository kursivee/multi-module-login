package com.kursivee.login.domain

import com.kursivee.core.domain.Either
import com.kursivee.core.domain.Error
import com.kursivee.core.domain.FlowUseCase
import com.kursivee.login.domain.model.AuthenticationRequest
import com.kursivee.login.domain.model.AuthenticationResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlowAuthenticateUseCase(private val repository: Repository): FlowUseCase<AuthenticationResponse, AuthenticationRequest>() {
    override suspend fun execute(params: AuthenticationRequest): Flow<Either<Error, AuthenticationResponse>> =
        flow {
            emit(Either.Start())
            val resp = repository.auth(params.username, params.password)
            emit(resp)
        }
}