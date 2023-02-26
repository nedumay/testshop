package com.example.testshop.domain.usecase

import com.example.testshop.domain.ListRepository

class LoadDataUseCase (private val repository: ListRepository) {

    operator fun invoke() = repository.loadData()
}