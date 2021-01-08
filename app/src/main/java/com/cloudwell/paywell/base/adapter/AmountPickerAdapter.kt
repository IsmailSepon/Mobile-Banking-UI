package com.cloudwell.paywell.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R

class AmountPickerAdapter : RecyclerView.Adapter<PickerItemViewHolder>() {

    private val data: ArrayList<String> = ArrayList()
    var callback: Callback? = null
    private val clickListener = View.OnClickListener { v -> v?.let { callback?.onItemClicked(it) } }
    private var selectedItem: Int? = -1
    private var ctx: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PickerItemViewHolder {

        ctx = parent.context

        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_slider_item, parent, false)

        itemView.setOnClickListener(clickListener)
        return PickerItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PickerItemViewHolder, position: Int) {
        holder.tvItem?.text = data[position]

        when (selectedItem) {
            position -> {
                holder.tvItem?.setTextColor(ContextCompat.getColor(ctx!!, R.color.keypad_text_clr))
                selectedItem = -1
            }
            else -> holder.tvItem?.setTextColor(ContextCompat.getColor(ctx!!, R.color.common_clr))
        }
    }

    fun setSelectedItem(position: Int) {
        selectedItem = position
        notifyDataSetChanged()
    }

    fun checkedItem(pos: Int) {
        selectedItem = pos
        notifyDataSetChanged()
    }

    fun setData(data: ArrayList<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClicked(view: View)
    }
}