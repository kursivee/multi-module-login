package com.kursivee.login.view.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {
    fun authenticate(username: String, password: String): Boolean {
        return true
    }
}
