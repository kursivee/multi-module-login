package com.kursivee.core.app.ext

import android.app.Application
import com.kursivee.core.app.App
import com.kursivee.core.app.di.CoreComponent

val Application.coreComponent: CoreComponent
    get() = (this as App).component