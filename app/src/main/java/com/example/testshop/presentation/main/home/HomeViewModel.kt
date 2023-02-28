package com.example.testshop.presentation.main.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshop.data.repository.ListRepositoryImpl
import com.example.testshop.domain.usecase.GetLatestListUseCase
import com.example.testshop.domain.usecase.LoadDataUseCase
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ListRepositoryImpl(application)
    private val getLatestListUseCase = GetLatestListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val latestInfoList = getLatestListUseCase()
    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}