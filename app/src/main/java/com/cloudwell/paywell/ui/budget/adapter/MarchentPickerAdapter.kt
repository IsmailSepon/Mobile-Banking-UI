package com.cloudwell.paywell.ui.budget.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.budget.model.BudgetPOjo

class MarchentPickerAdapter : RecyclerView.Adapter<BudgetMarchentViewHolder>() {

    private val data: ArrayList<BudgetPOjo> = ArrayList()
    var callback: Callback? = null
    private val clickListener = View.OnClickListener { v -> v?.let { callback?.onItemClicked(it) } }
    private var selectedItem: Int? = -1
    private var ctx: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BudgetMarchentViewHolder {

        ctx = parent.context

        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.budget_slider_item, parent, false)

        itemView.setOnClickListener(clickListener)
        return BudgetMarchentViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BudgetMarchentViewHolder, position: Int) {
        holder.tvItem1?.text = data.get(position).amount//data[position]
        holder.tvItem2?.text = data.get(position).month//data[position]

        when (selectedItem) {
            position -> {
                holder.tvItem1?.setTextColor(ContextCompat.getColor(ctx!!, R.color.keypad_text_clr))
                holder.tvItem2?.setTextColor(ContextCompat.getColor(ctx!!, R.color.keypad_text_clr))
                selectedItem = -1
            }
            else -> holder.tvItem1?.setTextColor(ContextCompat.getColor(ctx!!, R.color.common_clr))
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

    fun setData(data: ArrayList<BudgetPOjo>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClicked(view: View)
    }
}