package com.cloudwell.paywell.uiCommon.pay.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.model.PaytoPOjo

/**
 * Created by Sepon on 9/9/2020.
 */
class PayAdapter(mContext: Context, courselist: List<PaytoPOjo>) :
    RecyclerView.Adapter<PayAdapter.ViewHolder?>() {
    private val recyclerView: RecyclerView? = null
    private val selectedItem = UNSELECTED
    var mContext: Context
    private val courselist: List<PaytoPOjo>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.payto_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     //   holder.amount.text = courselist[position].amount
        holder.name.text = courselist[position].name
        //holder.icon.setImageResource(courselist.get(position).icon!!)

      //  holder.icon.setImageResource(courselist.get(position).icon!!)
    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView

        init {
            name = itemView.findViewById(R.id.paytoName)
        }
    }

    companion object {
        private const val UNSELECTED = -1
    }

    init {
        this.mContext = mContext
        this.courselist = courselist
    }
}
