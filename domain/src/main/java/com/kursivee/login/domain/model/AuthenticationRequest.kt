package com.kursivee.login.domain.model

data class AuthenticationRequest(
    val username: String,
    val password: String
)