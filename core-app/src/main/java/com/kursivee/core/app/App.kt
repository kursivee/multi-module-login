package com.kursivee.core.app

import android.app.Application
import com.kursivee.core.app.di.CoreComponent
import com.kursivee.core.app.di.DaggerCoreComponent

class App: Application() {
    lateinit var component: CoreComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerCoreComponent.builder().build()
    }
}