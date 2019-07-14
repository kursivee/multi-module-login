package com.kursivee.login.data.api

import com.kursivee.login.domain.model.AuthResp
import com.kursivee.login.domain.model.AuthenticationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("/auth")
    suspend fun auth(@Body authenticationRequest: AuthenticationRequest): Response<AuthResp>
}