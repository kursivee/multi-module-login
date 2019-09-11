package com.kursivee.login.domain.model

data class LoginResponse(
    val token: String,
    val authorized: Boolean
)