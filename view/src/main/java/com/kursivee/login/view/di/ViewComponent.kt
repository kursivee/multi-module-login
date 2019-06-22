package com.kursivee.login.view.di

import com.kursivee.login.core.di.CoreComponent
import com.kursivee.login.view.login.LoginFragment
import com.kursivee.login.view.viewmodel.di.ViewModelModule
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [ViewModelModule::class]
)
@FeatureScope
interface ViewComponent {
    fun inject(loginFragment: LoginFragment)
}