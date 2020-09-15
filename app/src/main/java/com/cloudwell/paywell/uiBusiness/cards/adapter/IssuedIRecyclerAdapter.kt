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
import com.cloudwell.paywell.uiBusiness.cards.model.IssuedPOjo

/**
 * Created by Sepon on 9/8/2020.
 */

class IssuedIRecyclerAdapter(mContext: Context, courselist: List<IssuedPOjo>) :
    RecyclerView.Adapter<IssuedIRecyclerAdapter.ViewHolder?>() {
    var mContext: Context
    private val courselist: List<IssuedPOjo>
    var tempDate : String = ""



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.issued_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


            if (tempDate.equals("")){
                tempDate = courselist.get(position).date!!
                holder.divider.visibility = View.GONE
                holder.date_hader.visibility = View.VISIBLE
                holder.date_hader.text = tempDate
                holder.name.text = courselist.get(position).name
                holder.profile_txt.text = courselist.get(position).profile
                holder.linktxt.text = courselist.get(position).link
            }else if (tempDate.equals(courselist.get(position).date)){

                holder.divider.visibility = View.GONE
                holder.date_hader.visibility = View.GONE
                holder.name.text = courselist.get(position).name
                holder.profile_txt.text = courselist.get(position).profile
                holder.linktxt.text = courselist.get(position).link
            }else{

                tempDate = courselist.get(position).date!!
                holder.divider.visibility = View.VISIBLE
                holder.date_hader.visibility = View.VISIBLE
                holder.date_hader.text = tempDate
                holder.name.text = courselist.get(position).name
                holder.profile_txt.text = courselist.get(position).profile
                holder.linktxt.text = courselist.get(position).link
            }

    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var date_hader: TextView
        var profile_txt: TextView
        var linktxt: TextView
        var divider: ImageView

        init {
            divider = itemView.findViewById(R.id.item_dividere)
            date_hader = itemView.findViewById(R.id.date_hader)
            name = itemView.findViewById(R.id.issue_name)
            linktxt = itemView.findViewById(R.id.link_txt)
            profile_txt = itemView.findViewById(R.id.profile_txt)
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
