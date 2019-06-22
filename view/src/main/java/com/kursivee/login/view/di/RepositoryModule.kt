package com.kursivee.login.view.di

import com.kursivee.login.data.repository.AuthenticationRepository
import com.kursivee.login.domain.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    @FeatureScope
    abstract fun provideAuthenticationRepository(authenticationRepository: AuthenticationRepository): Repository
}