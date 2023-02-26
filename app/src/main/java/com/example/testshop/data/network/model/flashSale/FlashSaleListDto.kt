package com.example.testshop.domain.model.flashSale

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlashSaleListDto(
    @SerializedName("flash_sale")
    @Expose
    private val flashSaleDto: List<FlashSaleDto>?
)
