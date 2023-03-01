package com.example.testshop.di

import android.app.Application
import com.example.testshop.data.database.AppDataBase
import com.example.testshop.data.database.UsersDao
import com.example.testshop.data.network.ApiFactory
import com.example.testshop.data.network.ApiService
import com.example.testshop.data.repository.RepositoryImpl
import com.example.testshop.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepositoryImpl(impl: RepositoryImpl): Repository

    companion object{

        @Provides
        @ApplicationScope
        fun provideUsersDao(application: Application): UsersDao{
            return AppDataBase.getInstance(application).UsersDao()
        }

        @Provides
        @ApplicationScope
        fun porovideApiService(): ApiService{
            return ApiFactory.apiService
        }
    }
}