package com.cloudwell.paywell.ui.budget.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R

class BudgetMarchentViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

  val tvItem1: TextView? = itemView?.findViewById(R.id.budget_item)
  val tvItem2: TextView? = itemView?.findViewById(R.id.budget_month_txt)
}