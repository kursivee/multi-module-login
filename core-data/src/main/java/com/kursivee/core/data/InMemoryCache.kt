package com.kursivee.core.data

import com.kursivee.core.domain.Cache
import javax.inject.Inject

class InMemoryCache @Inject constructor(): Cache<Any, Any> {
    private val map: MutableMap<Any, Any> = mutableMapOf()

    override fun put(key: Any, value: Any) {
        map[key] = value
    }

    override fun get(key: Any): Any? = map[key]

    override fun clear() = map.clear()

    override fun contains(key: Any): Boolean = map.contains(key)
}