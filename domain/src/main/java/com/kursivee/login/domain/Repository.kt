package com.kursivee.login.domain

import com.kursivee.core.domain.Error
import com.kursivee.core.domain.Either
import com.kursivee.login.domain.model.AuthenticationResponse

interface Repository {
    fun auth(username: String, password: String): Either<Error, AuthenticationResponse>
}