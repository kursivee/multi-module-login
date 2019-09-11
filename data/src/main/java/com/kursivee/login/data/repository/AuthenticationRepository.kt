package com.kursivee.login.data.repository

import android.util.Log
import com.kursivee.core.domain.Either
import com.kursivee.core.domain.Error
import com.kursivee.login.data.api.AuthenticationApi
import com.kursivee.login.data.cache.AuthenticationCache
import com.kursivee.login.domain.Repository
import com.kursivee.login.domain.model.AuthenticationResponse
import com.kursivee.login.domain.model.AuthenticationRequest
import kotlinx.coroutines.delay
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val api: AuthenticationApi,
    private val authCache: AuthenticationCache
): Repository {
    private val tag = AuthenticationRepository::class.java.simpleName

    override suspend fun auth(username: String, password: String): Either<Error, AuthenticationResponse> {
        authCache.get()?.let {
            Log.d(tag, "CACHED RESPONSE")
            return Either.Success(it)
        } ?: run {
            delay(1000)
            return Either.Success(AuthenticationResponse("token", "refresh"))
//            val response = api.auth(AuthenticationRequest(username, password))
//            return if(response.isSuccessful) {
//                Log.d(tag, "CACHING")
//                response.body()?.let {
//                    authCache.put(it)
//                    Either.Success(it)
//                } ?: Either.Failure(Error(true))
//            } else {
//                Either.Failure(Error(true))
//            }
        }
    }
}