package com.example.testshop.presentation.main.home.adapters.flashsale

import androidx.recyclerview.widget.DiffUtil
import com.example.testshop.domain.model.flashSale.FlashSale

object FlashSaleDiffCallback : DiffUtil.ItemCallback<FlashSale>() {
    override fun areItemsTheSame(oldItem: FlashSale, newItem: FlashSale): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: FlashSale, newItem: FlashSale): Boolean {
        return oldItem == newItem
    }
}