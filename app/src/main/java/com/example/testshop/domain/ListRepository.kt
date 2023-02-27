package com.example.testshop.domain

import androidx.lifecycle.LiveData
import com.example.testshop.domain.model.flashSale.FlashSale
import com.example.testshop.domain.model.latest.Latest

interface ListRepository {

    fun getFlashSaleList() : LiveData<List<FlashSale>>

    fun getLatestList() : LiveData<List<Latest>>

    suspend fun loadData()

}