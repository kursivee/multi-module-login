package com.kursivee.login.obs

import androidx.lifecycle.*
import com.kursivee.login.domain.AuthenticateUseCase
import com.kursivee.login.domain.model.AuthenticationRequest
import com.kursivee.login.dux.LoginState
import com.kursivee.login.dux.MutableLoginState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginObservableViewModel @Inject constructor(
    private val authenticate: AuthenticateUseCase
): ViewModel() {
    var state: MediatorLiveData<LoginState> = MediatorLiveData()


    private val mutableLoading = MutableLiveData(false)

    init {
        state.addSource(mutableLoading) {
            state.postValue(state.value?.copy(success = it))
        }
    }

    fun authenticate(username: String, password: String) {
        request {
            authenticate.execute(AuthenticationRequest(username, password))
                .handle(
                    onStart = {
                        mutableLoading.value = true
                    },
                    onFailure = {

                    },
                    onSuccess = {

                    }
                )
        }
    }
}

fun ViewModel.request(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch {
        block()
    }
}

fun ViewModel.io(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.IO) {
        block()
    }
}