package com.kursivee.login.data.cache

import com.kursivee.core.domain.Cache
import com.kursivee.login.domain.model.AuthenticationResponse
import com.kursivee.login.domain.model.AuthorizeResponse

class AuthenticationCache(private val cache: Cache<Any, Any>) {
    fun put(response: AuthenticationResponse) {
        cache.put(AuthenticationResponse::class.java.simpleName, response)
    }

    fun get(): AuthenticationResponse? =
        cache.get(AuthenticationResponse::class.java.simpleName) as? AuthenticationResponse

    fun put(response: AuthorizeResponse) {
        cache.put(AuthorizeResponse::class.java.simpleName, response)
    }

    fun getAuthorizeResponse(): AuthorizeResponse? =
        cache.get(AuthorizeResponse::class.java.simpleName) as? AuthorizeResponse
}