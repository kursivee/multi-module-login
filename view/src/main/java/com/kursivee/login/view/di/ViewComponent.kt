package com.kursivee.login.view.di

import com.kursivee.core.view.di.CoreComponent
import com.kursivee.login.view.LoginFragment
import com.kursivee.login.view.viewmodel.di.ViewModelModule
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [
        ViewModelModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        CacheModule::class
    ]
)
@FeatureScope
internal interface ViewComponent {
    fun inject(loginFragment: LoginFragment)
}