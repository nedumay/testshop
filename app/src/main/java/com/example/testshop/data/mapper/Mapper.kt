package com.example.testshop.data.mapper

import com.example.testshop.data.network.model.latest.LatestDto
import com.example.testshop.domain.model.latest.Latest

class Mapper {

    fun mapDtoModelToLatest(dto: LatestDto) = Latest(
        category = dto.category.toString(),
        name = dto.name.toString(),
        price = dto.price ?: 0,
        image_url = dto.image_url.toString()
    )
}