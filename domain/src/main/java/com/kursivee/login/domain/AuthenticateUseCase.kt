package com.kursivee.login.domain

import com.kursivee.login.domain.model.AuthenticationResponse

class AuthenticateUseCase(private val repository: Repository) {
    fun execute(username: String, password: String): AuthenticationResponse =
        repository.authenticate(username, password)
}