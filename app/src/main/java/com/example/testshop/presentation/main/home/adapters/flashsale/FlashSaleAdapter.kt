package com.example.testshop.presentation.main.home.adapters.flashsale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testshop.data.network.model.flashSale.FlashSaleDto
import com.example.testshop.databinding.ItemFlashSaleBinding

import com.squareup.picasso.Picasso


class FlashSaleAdapter
    : ListAdapter<FlashSaleDto, FlashSaleViewHolder>(FlashSaleDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val binding = ItemFlashSaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlashSaleViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val flashSale = getItem(position)
        with(holder.binding){
            textViewCategory.text = flashSale.category
            textViewName.text = flashSale.name
            textViewPrice.text= flashSale.price.toString()
            Picasso.get().load(flashSale.image_url).into(imageViewUrl)

        }
    }

}