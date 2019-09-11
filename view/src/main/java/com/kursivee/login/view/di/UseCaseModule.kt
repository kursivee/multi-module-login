package com.kursivee.login.view.di

import com.kursivee.login.domain.AuthenticateUseCase
import com.kursivee.login.domain.FlowAuthenticateUseCase
import com.kursivee.login.domain.Repository
import dagger.Module
import dagger.Provides

@Module
internal object UseCaseModule {
    @Provides
    @JvmStatic
    @FeatureScope
    fun provideAuthenticationUseCase(repository: Repository): AuthenticateUseCase =
        AuthenticateUseCase(repository)


    @Provides
    @JvmStatic
    @FeatureScope
    fun provideFlowAuthenticationUseCase(repository: Repository): FlowAuthenticateUseCase =
        FlowAuthenticateUseCase(repository)
}