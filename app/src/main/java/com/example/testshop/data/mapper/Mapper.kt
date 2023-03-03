package com.example.testshop.data.mapper

import com.example.testshop.data.database.UserDbModel
import com.example.testshop.data.network.model.flashSale.FlashSaleDto
import com.example.testshop.data.network.model.latest.LatestDto
import com.example.testshop.domain.model.flashSale.FlashSale
import com.example.testshop.domain.model.latest.Latest
import com.example.testshop.domain.model.users.User
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapDtoModelToLatest(dto: LatestDto) = Latest(
        category = dto.category.toString(),
        name = dto.name.toString(),
        price = dto.price ?: 0,
        image_url = dto.image_url.toString()
    )

    fun mapDtoModelToFlashSale(dto: FlashSaleDto) = FlashSale(
        category = dto.category.toString(),
        name = dto.name.toString(),
        price = dto.price ?: 0.0,
        discount = dto.discount ?: 0,
        image_url = dto.image_url.toString()
    )

    fun mapEntityToDbModel(user: User) = UserDbModel(
        firstName = user.firstName,
        lastName = user.lastName,
        email = user.email,
    )

    fun mapDbModelToEntity(userDbModel: UserDbModel?) = User(
        firstName = userDbModel?.firstName ?: "",
        lastName = userDbModel?.lastName ?: "",
        email = userDbModel?.email ?: "",
    )
}