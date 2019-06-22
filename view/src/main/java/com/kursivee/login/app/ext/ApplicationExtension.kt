package com.kursivee.login.app.ext

import android.app.Application
import com.kursivee.login.app.App
import com.kursivee.login.core.di.CoreComponent

val Application.coreComponent: CoreComponent
    get() = (this as App).component