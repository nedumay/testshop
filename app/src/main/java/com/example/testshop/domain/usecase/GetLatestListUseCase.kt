package com.example.testshop.domain.usecase

import com.example.testshop.domain.ListRepository

class GetLatestListUseCase(private val repository: ListRepository) {
    operator fun invoke() = repository.getLatestList()
}