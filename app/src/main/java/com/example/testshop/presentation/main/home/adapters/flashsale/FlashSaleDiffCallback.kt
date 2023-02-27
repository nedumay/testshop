package com.example.testshop.presentation.main.home.adapters.flashsale

import androidx.recyclerview.widget.DiffUtil
import com.example.testshop.data.network.model.flashSale.FlashSaleDto

object FlashSaleDiffCallback : DiffUtil.ItemCallback<FlashSaleDto>() {
    override fun areItemsTheSame(oldItem: FlashSaleDto, newItem: FlashSaleDto): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: FlashSaleDto, newItem: FlashSaleDto): Boolean {
        return oldItem == newItem
    }
}