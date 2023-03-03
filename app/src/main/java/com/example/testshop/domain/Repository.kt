package com.example.testshop.domain

import androidx.lifecycle.LiveData
import com.example.testshop.domain.model.flashSale.FlashSale
import com.example.testshop.domain.model.latest.Latest
import com.example.testshop.domain.model.users.User

interface Repository {

    fun getFlashSaleList() : LiveData<List<FlashSale>>
    fun getLatestList() : LiveData<List<Latest>>
    suspend fun loadData()
    suspend fun  addUserToDb(user: User)
    suspend fun deleteUserFromDb(firstName: String)
    suspend fun getUserFromDb(firstName: String) : User

}