package com.example.testshop.domain

import androidx.lifecycle.LiveData
import com.example.testshop.domain.model.flashSale.FlashSaleDto
import com.example.testshop.domain.model.latest.LatestListDto

interface ListRepository {

    fun getFlashSaleList() : LiveData<List<FlashSaleDto>>

    fun getLatestList() : LiveData<List<LatestListDto>>

    fun loadData()

}