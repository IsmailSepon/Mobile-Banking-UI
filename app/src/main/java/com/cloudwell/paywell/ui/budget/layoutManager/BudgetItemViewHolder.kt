package com.cloudwell.paywell.ui.budget.layoutManager

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R

class BudgetItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    val tvItem: TextView? = itemView?.findViewById(R.id.budget_item)
    val tvItemmonth: TextView? = itemView?.findViewById(R.id.budget_month_txt)
}