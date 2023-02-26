package com.example.testshop.domain.model.latest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LatestDto(
    @SerializedName("category")
    @Expose
    private val category: String?,
    @SerializedName("name")
    @Expose
    private val name: String?,
    @SerializedName("price")
    @Expose
    private val price: Int?,
    @SerializedName("image_url")
    @Expose
    private val image_url: Int?
)