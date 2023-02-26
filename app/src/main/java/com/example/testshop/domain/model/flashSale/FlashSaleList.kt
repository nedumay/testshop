package com.example.testshop.domain.model.flashSale

import com.google.gson.annotations.SerializedName

data class FlashSaleList(
    @SerializedName("flash_sale")
    private val flashSaleDto: List<FlashSaleDto>? = null
)
