package com.kursivee.login.view.viewmodel.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kursivee.core.view.viewmodel.ViewModelFactory
import com.kursivee.core.view.viewmodel.di.ViewModelKey
import com.kursivee.login.dux.LoginViewModel
import com.kursivee.login.view.di.FeatureScope
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
    internal abstract fun bindLoginVM(loginViewModel: LoginViewModel): ViewModel
}
