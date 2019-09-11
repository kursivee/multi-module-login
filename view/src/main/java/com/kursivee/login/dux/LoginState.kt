package com.kursivee.login.dux

data class LoginState(
    val username: String = "",
    val password: String = "",
    val token: String = "",
    val success: Boolean = false,
    val loading: Boolean = false
)

data class MutableLoginState(
    var username: String = "",
    var password: String = "",
    var token: String = "",
    var success: Boolean = false,
    var loading: Boolean = false
)