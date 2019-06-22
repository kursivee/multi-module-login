package com.kursivee.core.view.di

import com.kursivee.core.data.InMemoryCache
import com.kursivee.core.domain.Cache
import dagger.Binds
import dagger.Module

@Module
internal abstract class CacheModule {

    @Binds
    @CoreScope
    abstract fun provideInMemoryCache(inMemoryCache: InMemoryCache): Cache<Any, Any>
}