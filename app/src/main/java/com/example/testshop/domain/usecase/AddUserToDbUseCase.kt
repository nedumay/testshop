package com.example.testshop.domain.usecase

import com.example.testshop.domain.Repository
import com.example.testshop.domain.model.users.User
import javax.inject.Inject

class AddUserToDbUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(user:User) = repository.addUserToDb(user)
}