package com.kursivee.core.domain

interface Cache<K, V> {
    fun put(key: K, value: V)
    fun get(key: K): V
    fun clear()
    fun contains(key: K): Boolean
}