package com.kursivee.login.view.di

import com.kursivee.core.domain.Cache
import com.kursivee.login.domain.AuthenticationCache
import dagger.Module
import dagger.Provides

@Module
internal object CacheModule {
    @Provides
    @JvmStatic
    @FeatureScope
    fun provideCacheUseCase(cache: Cache<Any, Any>): AuthenticationCache =
        AuthenticationCache(cache)
}