package com.example.testshop.data.network.model.latest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LatestDto(
    @SerializedName("category")
    @Expose
    val category: String?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("price")
    @Expose
    val price: Int?,
    @SerializedName("image_url")
    @Expose
    val image_url: String?
)