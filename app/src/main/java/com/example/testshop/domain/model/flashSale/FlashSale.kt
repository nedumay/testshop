package com.example.testshop.domain.model.flashSale

import com.google.gson.annotations.SerializedName

data class FlashSale(
    @SerializedName("category")
    private val category: String? = null,
    @SerializedName("name")
    private val name: String? = null,
    @SerializedName("price")
    private val price: Int? = null,
    @SerializedName("discount")
    private val discount: Int? = null,
    @SerializedName("image_url")
    private val image_url: Int? = null
)
