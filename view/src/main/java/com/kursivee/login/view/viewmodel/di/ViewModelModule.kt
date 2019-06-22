package com.kursivee.login.view.viewmodel.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kursivee.core.view.viewmodel.ViewModelFactory
import com.kursivee.core.view.viewmodel.di.ViewModelKey
import com.kursivee.login.view.di.FeatureScope
import com.kursivee.login.view.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @FeatureScope
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}