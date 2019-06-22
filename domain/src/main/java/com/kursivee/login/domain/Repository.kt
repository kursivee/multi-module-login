package com.kursivee.login.domain

import com.kursivee.login.data.model.AuthenticationResponse
import com.kursivee.login.data.repository.DataRepository

class Repository: DataRepository {
    override fun authenticate(username: String, password: String): AuthenticationResponse {
        return AuthenticationResponse(true)
    }
}