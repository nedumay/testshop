package com.example.testshop.domain.model.flashSale

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlashSaleDto(
    @SerializedName("category")
    @Expose
    private val category: String?,
    @SerializedName("name")
    @Expose
    private val name: String?,
    @SerializedName("price")
    @Expose
    private val price: Int?,
    @SerializedName("discount")
    @Expose
    private val discount: Int?,
    @SerializedName("image_url")
    @Expose
    private val image_url: Int?
)
