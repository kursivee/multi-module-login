package com.kursivee.login.dux

import com.kursivee.core.domain.Either
import com.kursivee.core.domain.Error
import com.kursivee.core.view.dux.DuxViewModel
import com.kursivee.login.domain.AuthenticateUseCase
import com.kursivee.login.domain.FlowAuthenticateUseCase
import com.kursivee.login.domain.model.AuthenticationRequest
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    store: LoginStore,
    private val authenticate: AuthenticateUseCase,
    private val auth: FlowAuthenticateUseCase
): DuxViewModel<LoginAction, LoginReducer, LoginState>(store) {
    override val loadingAction: LoginAction = Request()

    fun authenticate() {
        request {
            authenticate.execute(AuthenticationRequest(state.username, state.password))
                .handle(onFailure = {
                    dispatch(AuthFailure())
                }, onSuccess = {
                    dispatch(AuthSuccess(token = it.token))
                })
        }
    }

    fun auth() {
        request {
            auth.execute(AuthenticationRequest(state.username, state.password))
                .collect {
                    when(it) {
                        is Either.Failure -> dispatch(AuthFailure())
                        is Either.Success -> dispatch(AuthSuccess(token = it.success.token))
                    }
                }
        }
    }
}