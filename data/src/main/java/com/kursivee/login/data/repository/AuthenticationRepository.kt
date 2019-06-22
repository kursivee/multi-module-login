package com.kursivee.login.data.repository

import android.util.Log
import com.kursivee.core.domain.Cache
import com.kursivee.login.domain.Repository
import com.kursivee.login.domain.model.AuthenticationResponse
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(private val cache: Cache<Any, Any>): Repository {
    private val tag = AuthenticationRepository::class.java.simpleName

    override fun authenticate(username: String, password: String): AuthenticationResponse =
        (cache.get(AuthenticationResponse::class) as? AuthenticationResponse)?.also {
            Log.d(tag, "CACHED RESPONSE")
        } ?: AuthenticationResponse(true).also {
                Log.d(tag, "CACHING")
                cache.put(AuthenticationResponse::class, it)
            }
}