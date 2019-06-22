package com.kursivee.core.view.di

import com.kursivee.core.domain.Cache
import dagger.Component

@Component(modules = [CacheModule::class])
@CoreScope
interface CoreComponent {
    fun inMemoryCache(): Cache<Any, Any>
}