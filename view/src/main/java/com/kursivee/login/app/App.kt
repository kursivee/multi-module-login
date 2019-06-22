package com.kursivee.login.app

import android.app.Application
import com.kursivee.login.core.di.CoreComponent
import com.kursivee.login.core.di.DaggerCoreComponent

class App: Application() {
    lateinit var component: CoreComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerCoreComponent.builder().build()
    }
}