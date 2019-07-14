package com.kursivee.login.view.di

import com.kursivee.core.domain.Cache
import com.kursivee.login.data.cache.AuthenticationCache
import dagger.Module
import dagger.Provides

@Module
internal object CacheModule {

    @Provides
    @JvmStatic
    @FeatureScope
    fun provideAuthCache(cache: Cache<Any, Any>) = AuthenticationCache(cache)
}