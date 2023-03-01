package com.example.testshop.presentation.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshop.domain.usecase.GetFlashSaleListUseCase
import com.example.testshop.domain.usecase.GetLatestListUseCase
import com.example.testshop.domain.usecase.LoadDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getLatestListUseCase: GetLatestListUseCase,
    private val getFlashSaleListUseCase: GetFlashSaleListUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val latestInfoList = getLatestListUseCase()
    val flashSaleInfoList = getFlashSaleListUseCase()
    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}