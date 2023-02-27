package com.example.testshop.presentation.main.home.adapters.latest

import androidx.recyclerview.widget.DiffUtil
import com.example.testshop.domain.model.latest.Latest

object LatestDiffCallback : DiffUtil.ItemCallback<Latest>() {
    override fun areItemsTheSame(oldItem: Latest, newItem: Latest): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: Latest, newItem: Latest): Boolean {
        return oldItem == newItem
    }
}