package com.kursivee.login.domain

import com.kursivee.login.domain.model.AuthenticationResponse

interface Repository {
    fun authenticate(username: String, password: String): AuthenticationResponse
}