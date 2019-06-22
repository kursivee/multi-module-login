package com.kursivee.login.view.viewmodel

import androidx.lifecycle.ViewModel
import com.kursivee.login.domain.AuthenticateUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {
    fun authenticate(username: String, password: String): Boolean {
        return authenticateUseCase.execute(username, password).success
    }
}
