package com.kursivee.core.view.di

import com.kursivee.core.domain.Cache
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [CacheModule::class, NetworkModule::class])
@CoreScope
interface CoreComponent {
    fun inMemoryCache(): Cache<Any, Any>
    fun retrofit(): Retrofit
}