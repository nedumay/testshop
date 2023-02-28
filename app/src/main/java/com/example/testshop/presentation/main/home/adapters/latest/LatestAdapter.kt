package com.example.testshop.presentation.main.home.adapters.latest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testshop.databinding.ItemLatestBinding
import com.example.testshop.domain.model.latest.Latest
import com.squareup.picasso.Picasso


class LatestAdapter
    : ListAdapter<Latest, LatestViewHolder>(LatestDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding = ItemLatestBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val latest = getItem(position)
        with(holder.binding) {
            with(latest){
                textViewCategory.text = category
                textViewName.text = name
                textViewPrice.text = "$ ${price}"
                Picasso.get().load(image_url).into(imageViewUrl)
            }
        }
    }

}