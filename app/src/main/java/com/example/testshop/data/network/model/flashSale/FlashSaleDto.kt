package com.example.testshop.data.network.model.flashSale

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlashSaleDto(
    @SerializedName("category")
    @Expose
    val category: String?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("price")
    @Expose
    val price: Double?,
    @SerializedName("discount")
    @Expose
    val discount: Int?,
    @SerializedName("image_url")
    @Expose
    val image_url: String?
)
