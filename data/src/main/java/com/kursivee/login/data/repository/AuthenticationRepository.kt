package com.kursivee.login.data.repository

import android.util.Log
import com.kursivee.login.domain.CacheUseCase
import com.kursivee.login.domain.Repository
import com.kursivee.login.domain.model.AuthenticationResponse
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val cache: CacheUseCase
): Repository {
    private val tag = AuthenticationRepository::class.java.simpleName

    override fun authenticate(username: String, password: String): AuthenticationResponse =
        cache.get() ?.also {
            Log.d(tag, "CACHED RESPONSE")
        } ?: AuthenticationResponse(true).also {
                Log.d(tag, "CACHING")
                cache.put(it)
        }
}