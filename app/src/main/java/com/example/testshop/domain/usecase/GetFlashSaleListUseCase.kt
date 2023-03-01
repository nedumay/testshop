package com.example.testshop.domain.usecase

import com.example.testshop.domain.Repository
import javax.inject.Inject

class GetFlashSaleListUseCase @Inject constructor (private val repository: Repository) {

    operator fun invoke() = repository.getFlashSaleList()
}