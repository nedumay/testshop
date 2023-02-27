package com.example.testshop.data.network.model.flashSale

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlashSaleListDto(
    @SerializedName("flash_sale")
    @Expose
    var flashSaleDto: List<FlashSaleDto>
)
