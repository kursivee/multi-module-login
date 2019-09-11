package com.kursivee.login.dux

sealed class LoginAction
data class AuthSuccess(val username: String = "", val password: String = "", val token: String): LoginAction()
data class AuthFailure(val failure: Boolean = true): LoginAction()
data class Request(val loading: Boolean = true): LoginAction()
data class ChangeUsername(val username: String): LoginAction()
data class ChangePassword(val password: String): LoginAction()