package com.kursivee.login.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kursivee.login.domain.AuthenticateUseCase
import com.kursivee.core.domain.Error
import com.kursivee.login.domain.model.AuthRequest
import com.kursivee.login.domain.model.AuthenticationResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class LoginViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {
    private val successMLD = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = successMLD

    fun authenticate(username: String, password: String) {
        viewModelScope.launch {
            authenticateUseCase(AuthRequest(username, password)) {
                it.handle(::onAuthFail, ::onAuthSuccess)
            }
        }
    }

    private fun onAuthSuccess(response: AuthenticationResponse) {
        successMLD.postValue(response.success)
    }

    private fun onAuthFail(error: Error) {
        successMLD.postValue(false)
    }
}
