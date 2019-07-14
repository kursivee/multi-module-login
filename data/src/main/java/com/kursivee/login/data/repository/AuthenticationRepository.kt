package com.kursivee.login.data.repository

import android.util.Log
import com.kursivee.core.domain.Either
import com.kursivee.core.domain.Error
import com.kursivee.login.data.api.AuthenticationApi
import com.kursivee.login.data.cache.AuthCache
import com.kursivee.login.domain.Repository
import com.kursivee.login.domain.model.AuthResp
import com.kursivee.login.domain.model.AuthenticationRequest
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val api: AuthenticationApi,
    private val authCache: AuthCache
): Repository {
    private val tag = AuthenticationRepository::class.java.simpleName

    override suspend fun realAuth(username: String, password: String): Either<Error, AuthResp> {
        authCache.get()?.let {
            Log.d(tag, "CACHED RESPONSE")
            return Either.Success(it)
        } ?: run {
            val response = api.auth(AuthenticationRequest(username, password))
            return if(response.isSuccessful) {
                Log.d(tag, "CACHING")
                response.body()?.let {
                    authCache.put(it)
                    Either.Success(it)
                } ?: Either.Failure(Error(true))
            } else {
                Either.Failure(Error(true))
            }
        }
    }
}