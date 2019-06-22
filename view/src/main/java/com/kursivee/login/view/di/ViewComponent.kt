package com.kursivee.login.view.di

import com.kursivee.core.app.di.CoreComponent
import com.kursivee.login.view.login.LoginFragment
import com.kursivee.login.view.viewmodel.di.ViewModelModule
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [
        ViewModelModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
@FeatureScope
interface ViewComponent {
    fun inject(loginFragment: LoginFragment)
}