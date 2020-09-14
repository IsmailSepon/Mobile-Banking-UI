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
import com.cloudwell.paywell.uiBusiness.cards.model.PaidExpencePOjo

/**
 * Created by Sepon on 9/8/2020.
 */

class PaidIRecyclerAdapter(mContext: Context, courselist: List<PaidExpencePOjo>) :
    RecyclerView.Adapter<PaidIRecyclerAdapter.ViewHolder?>() {
    var mContext: Context
    private val courselist: List<PaidExpencePOjo>
    var tempDate : String = ""



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.paid_ex_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


            if (tempDate.equals("")){
                tempDate = courselist.get(position).date!!
                holder.divider.visibility = View.GONE
                holder.date_hader.visibility = View.VISIBLE
                holder.date_hader.text = tempDate
            }else if (tempDate.equals(courselist.get(position).date)){

                holder.divider.visibility = View.GONE
                holder.date_hader.visibility = View.GONE
            }else{

                tempDate = courselist.get(position).date!!
                holder.divider.visibility = View.VISIBLE
                holder.date_hader.visibility = View.VISIBLE
                holder.date_hader.text = tempDate
            }








    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var date: TextView
        var date_hader: TextView
        var divider: ImageView

        init {
            name = itemView.findViewById(R.id.name_txt)
            date = itemView.findViewById(R.id.date_txt)
            date_hader = itemView.findViewById(R.id.date_hader)
            divider = itemView.findViewById(R.id.item_dividere)
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
