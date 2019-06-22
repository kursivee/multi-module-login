package com.kursivee.core.view

import android.app.Application
import com.kursivee.core.view.di.DaggerCoreComponent

class App: Application() {
    lateinit var component: com.kursivee.core.view.di.CoreComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerCoreComponent.builder().build()
    }
}