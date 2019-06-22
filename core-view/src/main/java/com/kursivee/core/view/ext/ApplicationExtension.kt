package com.kursivee.core.view.ext

import android.app.Application
import com.kursivee.core.view.App
import com.kursivee.core.view.di.CoreComponent

val Application.coreComponent: CoreComponent
    get() = (this as App).component