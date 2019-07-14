package com.kursivee.login.view.di

import com.kursivee.login.data.api.AuthenticationApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object ApiModule {
    @JvmStatic
    @Provides
    fun provideAuthenticationApi(retrofit: Retrofit): AuthenticationApi =
        retrofit.create(AuthenticationApi::class.java)
}