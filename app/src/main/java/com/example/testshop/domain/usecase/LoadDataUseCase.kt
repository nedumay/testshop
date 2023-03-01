package com.example.testshop.domain.usecase

import com.example.testshop.domain.Repository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor (private val repository: Repository) {

    suspend operator fun invoke() = repository.loadData()
}