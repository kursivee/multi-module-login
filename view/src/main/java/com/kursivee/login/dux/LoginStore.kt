package com.kursivee.login.dux

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kursivee.core.view.dux.DuxStore
import javax.inject.Inject

class LoginStore @Inject constructor(
    reducer: LoginReducer,
    defaultState: LoginState
): DuxStore<LoginAction, LoginReducer, LoginState>(reducer) {
    override val mutableState: MutableLiveData<LoginState> = MutableLiveData(defaultState)
    override val state: LiveData<LoginState> = mutableState
}