package com.example.testshop.domain.model.latest

import com.google.gson.annotations.SerializedName

data class LatestList(
    @SerializedName("latest")
    private val latestDto: List<LatestDto>? = null
)
