package com.example.testshop.data.network

import com.example.testshop.data.network.model.flashSale.FlashSaleListDto
import com.example.testshop.data.network.model.latest.LatestListDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestInfo(): Response<LatestListDto>

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSaleInfo(): Response<FlashSaleListDto>

}