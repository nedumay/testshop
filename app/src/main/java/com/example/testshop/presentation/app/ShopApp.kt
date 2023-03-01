package com.example.testshop.presentation.app

import android.app.Application
import com.example.testshop.di.DaggerApplicationComponent

class ShopApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

}