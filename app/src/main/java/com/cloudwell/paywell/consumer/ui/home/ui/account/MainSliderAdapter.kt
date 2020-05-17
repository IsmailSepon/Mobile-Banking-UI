package com.cloudwell.paywell.consumer.ui.home.ui.account

import android.content.Context
import android.util.Log
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

/**
 * Created by Sepon on 4/20/2020.
 */
class MainSliderAdapter(imageUrls: ArrayList<String>) : SliderAdapter() {
    private val imageUrls: ArrayList<String>

    override fun getItemCount(): Int {
        return imageUrls.size
    }

    override fun onBindImageSlide(
        position: Int,
        viewHolder: ImageSlideViewHolder
    ) {
        try {
            val imageUrl = imageUrls[position]
            viewHolder.bindImageSlide(imageUrl)
        } catch (e: Exception) {
            Log.e("Slider Exception", e.toString())
        }
    }

    init {
        this.imageUrls = imageUrls
    }
}