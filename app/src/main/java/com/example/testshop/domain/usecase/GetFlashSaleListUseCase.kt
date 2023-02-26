package com.example.testshop.domain.usecase

import com.example.testshop.domain.ListRepository

class GetFlashSaleListUseCase (private val repository: ListRepository) {

    operator fun invoke() = repository.getFlashSaleList()
}