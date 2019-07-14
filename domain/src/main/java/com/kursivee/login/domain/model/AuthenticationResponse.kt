package com.kursivee.login.domain.model

data class AuthenticationResponse(
    val token: String,
    val refreshToken: String
)