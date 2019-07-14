package com.kursivee.login.data.cache

import com.kursivee.core.domain.Cache
import com.kursivee.login.domain.model.AuthResp
import com.kursivee.login.domain.model.AuthenticationResponse

class AuthCache(private val cache: Cache<Any, Any>) {
    fun put(response: AuthResp) {
        cache.put(AuthResp::class.java.simpleName, response)
    }

    fun get(): AuthResp? =
        cache.get(AuthResp::class.java.simpleName) as? AuthResp
}