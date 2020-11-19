package com.cloudwell.paywell.uiBusiness.cards.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.model.CardPOjo

/**
 * Created by Sepon on 9/9/2020.
 */
class CardAdapter(mContext: Context, courselist: List<CardPOjo>) :
    RecyclerView.Adapter<CardAdapter.ViewHolder?>() {
    private val recyclerView: RecyclerView? = null
    private val selectedItem = UNSELECTED
    var mContext: Context
    private val courselist: List<CardPOjo>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     //   holder.amount.text = courselist[position].amount
        holder.name.text = courselist[position].name
        //holder.icon.setImageResource(courselist.get(position).icon!!)

        holder.icon.setImageResource(courselist.get(position).icon!!)
    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView
        var icon : ImageView

        init {
            name = itemView.findViewById(R.id.card_name)
            icon = itemView.findViewById(R.id.card_icon)
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
