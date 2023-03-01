package com.example.testshop.di

import android.app.Application
import com.example.testshop.presentation.app.ShopApp
import com.example.testshop.presentation.login.LoginActivity
import com.example.testshop.presentation.main.home.HomeFragment
import com.example.testshop.presentation.sign.SignActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class,ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: SignActivity)

    fun inject(activity: LoginActivity)

    fun inject(fragment: HomeFragment)

    fun inject(application: ShopApp)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application) : ApplicationComponent
    }


}