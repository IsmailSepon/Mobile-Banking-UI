package com.cloudwell.paywell.ui.budget.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.budget.model.BudgetPOjo
import com.example.nbtk.slider.SliderItemViewHolder

class BudgetAdapter (mContext: Context) : RecyclerView.Adapter<SliderItemViewHolder>() {

    private val mContext = mContext
    private var selectedItem: Int? = -1
    private val data: ArrayList<String> = ArrayList()
    private val data2: ArrayList<BudgetPOjo> = ArrayList()
    var callback: Callback? = null


    val clickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            v?.let { callback?.onItemClicked(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderItemViewHolder {
        val itemView: View = LayoutInflater.from(mContext).inflate(R.layout.budget_slider_item, parent, false)

        itemView.setOnClickListener(clickListener)

        val horizontalViewHolder = SliderItemViewHolder(itemView)



        return horizontalViewHolder
    }

    override fun getItemCount(): Int {
        return data2.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: SliderItemViewHolder, position: Int) {
       // holder.tvItem?.text = data[position]
        holder.tvItem?.text = data2.get(position).amount
        holder.tvItemmonth?.text = data2.get(position).month

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

    fun setData(data: ArrayList<BudgetPOjo>) {
        this.data2.clear()
        this.data2.addAll(data)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClicked(view: View)
    }
}