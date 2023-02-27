package com.example.testshop.data.network.model.latest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LatestListDto(
    @SerializedName("latest")
    @Expose
    var latestDto: MutableList<LatestDto>
)
