package com.kursivee.login.data.repository

import android.util.Log
import com.kursivee.core.domain.Either
import com.kursivee.core.domain.Error
import com.kursivee.login.data.api.AuthenticationApi
import com.kursivee.login.data.cache.AuthenticationCache
import com.kursivee.login.domain.Repository
import com.kursivee.login.domain.model.AuthResp
import com.kursivee.login.domain.model.AuthenticationRequest
import com.kursivee.login.domain.model.AuthenticationResponse
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val cache: AuthenticationCache,
    private val api: AuthenticationApi
): Repository {
    private val tag = AuthenticationRepository::class.java.simpleName

    override fun auth(username: String, password: String): Either<Error, AuthenticationResponse> =
        cache.get()?.let {
            Log.d(tag, "CACHED RESPONSE")
            Either.Success(it)
        } ?: Either.Success(AuthenticationResponse(true).also {
            Log.d(tag, "CACHING")
            cache.put(it)
        })

    override suspend fun realAuth(username: String, password: String): Either<Error, AuthResp> {
        val response = api.auth(AuthenticationRequest(username, password))
        return if(response.isSuccessful) {
            Either.Success(response.body()!!)
        } else {
            Either.Failure(Error(true))
        }
    }
}