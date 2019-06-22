package com.kursivee.login.data.repository

import com.kursivee.login.data.model.AuthenticationResponse

interface DataRepository {
    fun authenticate(username: String, password: String): AuthenticationResponse
}