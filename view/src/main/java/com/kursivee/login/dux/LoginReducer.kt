package com.kursivee.login.dux

import com.kursivee.core.view.dux.DuxReducer
import javax.inject.Inject

class LoginReducer @Inject constructor(): DuxReducer<LoginState, LoginAction>() {
    override fun reduce(state: LoginState, action: LoginAction): LoginState =
        when(action) {
            is Request -> state.copy(loading = true)
            is AuthSuccess -> state.copy(loading = false, success = true, token = action.token, isAuthorized = action.isAuthorized)
            is AuthFailure -> state.copy(loading = false, success = false)
            is ChangeUsername -> state.copy(username = action.username)
            is ChangePassword -> state.copy(username = action.password)
        }
}