package com.example.testshop.presentation.main.home.adapters.flashsale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testshop.databinding.ItemFlashSaleBinding
import com.example.testshop.domain.model.flashSale.FlashSale
import com.squareup.picasso.Picasso


class FlashSaleAdapter
    : ListAdapter<FlashSale, FlashSaleViewHolder>(FlashSaleDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val binding = ItemFlashSaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlashSaleViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val flashSale = getItem(position)
        with(holder.binding){
            with(flashSale){
                textViewCategory.text = category
                textViewName.text = name
                textViewSale.text = "${discount}%off"
                textViewPrice.text= "$${price}"
                Picasso.get().load(flashSale.image_url).into(imageViewUrl)
            }

        }
    }

}