package com.example.testshop.domain.model.latest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LatestListDto(
    @SerializedName("latest")
    @Expose
    private val latestDto: List<LatestDto>?
)
