package com.kursivee.login.domain

import com.kursivee.core.domain.Either
import com.kursivee.core.domain.Error
import com.kursivee.core.domain.FlowUseCase
import com.kursivee.login.domain.model.AuthenticationRequest
import com.kursivee.login.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(
    private val repository: Repository
): FlowUseCase<LoginResponse, AuthenticationRequest>() {
    override suspend fun execute(params: AuthenticationRequest): Flow<Either<Error, LoginResponse>> =
        flow {
            emit(Either.Start())
            val authenticateResp = repository.auth(params.username, params.password)
            if(authenticateResp.isSuccess) {
                val token = authenticateResp.asSuccess().success.token
                val authorizeResponse = repository.authorize(token)
                if(authorizeResponse.isSuccess) {
                    val isAuthorized = authorizeResponse.asSuccess().success.authorized
                    emit(Either.Success(LoginResponse(token, isAuthorized)))
                } else {
                    emit(Either.Failure(Error()))
                }
            } else {
                emit(Either.Failure(Error()))
            }
        }
}