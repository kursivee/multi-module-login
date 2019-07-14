package com.kursivee.login.domain.model

data class AuthResp(
    val token: String,
    val refreshToken: String
)