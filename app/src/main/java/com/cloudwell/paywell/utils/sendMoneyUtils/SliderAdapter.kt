package com.example.nbtk.slider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R


class SliderAdapter(mContext: Context) : RecyclerView.Adapter<SliderItemViewHolder>() {

    private val mContext = mContext
    private var selectedItem: Int? = -1
    private val data: ArrayList<String> = ArrayList()
    var callback: Callback? = null
    val clickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            v?.let { callback?.onItemClicked(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderItemViewHolder {
        val itemView: View =
            LayoutInflater.from(mContext).inflate(R.layout.layout_slider_item, parent, false)

        itemView.setOnClickListener(clickListener)

        val horizontalViewHolder = SliderItemViewHolder(itemView)
        return horizontalViewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SliderItemViewHolder, position: Int) {
        holder.tvItem?.text = data[position]


        when (selectedItem) {
            position -> {
                holder.tvItem?.setTextColor(ContextCompat.getColor(mContext, R.color.keypad_text_clr))
                selectedItem = -1
            }
            else -> holder.tvItem?.setTextColor(ContextCompat.getColor(mContext, R.color.common_clr))
        }
    }
    fun setSelectedItem(position: Int) {
        selectedItem = position
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