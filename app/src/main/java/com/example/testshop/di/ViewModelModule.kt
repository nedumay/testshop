package com.example.testshop.di

import androidx.lifecycle.ViewModel
import com.example.testshop.presentation.login.LoginViewModel
import com.example.testshop.presentation.main.home.HomeViewModel
import com.example.testshop.presentation.main.profile.ProfileViewModel
import com.example.testshop.presentation.sign.SignViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(viewModel: LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignViewModel::class)
    fun bindSignViewModel(viewModel: SignViewModel) : ViewModel
}