package com.kursivee.login.view.viewmodel.di

import com.kursivee.login.dux.LoginState
import dagger.Module
import dagger.Provides

@Module
object LoginDuxModule {
    @Provides
    @JvmStatic
    fun provideLoginState(): LoginState = LoginState()
}