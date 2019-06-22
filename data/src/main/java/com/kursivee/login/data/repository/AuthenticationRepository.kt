package com.kursivee.login.data.repository

import com.kursivee.login.domain.Repository
import com.kursivee.login.domain.model.AuthenticationResponse
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(): Repository {
    override fun authenticate(username: String, password: String): AuthenticationResponse {
        return AuthenticationResponse(true)
    }
}