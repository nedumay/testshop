package com.example.testshop.domain.model.flashSale

data class FlashSale(
    val category: String,
    val name: String,
    val price: Int,
    val discount: Int,
    val image_url: String
)
