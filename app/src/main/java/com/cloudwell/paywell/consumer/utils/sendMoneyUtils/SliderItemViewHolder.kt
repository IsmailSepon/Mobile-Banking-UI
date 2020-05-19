package com.example.nbtk.slider

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SliderItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    val tvItem: TextView? = itemView?.findViewById(com.cloudwell.paywell.consumer.R.id.tv_item)
}