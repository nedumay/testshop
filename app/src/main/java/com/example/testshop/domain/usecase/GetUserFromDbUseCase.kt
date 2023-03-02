package com.example.testshop.domain.usecase

import com.example.testshop.domain.Repository
import javax.inject.Inject

class GetUserFromDbUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(firstName: String) = repository.getUserFromDb(firstName)
}