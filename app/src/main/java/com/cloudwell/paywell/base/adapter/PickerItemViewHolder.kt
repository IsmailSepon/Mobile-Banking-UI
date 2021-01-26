package com.cloudwell.paywell.base.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R

class PickerItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

  val tvItem: TextView? = itemView?.findViewById(R.id.tv_item)
}