package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment.model.ClaimModel

/**
 * Created by Sepon on 9/8/2020.
 */

class ClaimAdapter(mContext: Context, courselist: List<ClaimModel>) :
    RecyclerView.Adapter<ClaimAdapter.ViewHolder?>() {
    private val recyclerView: RecyclerView? = null
    private val selectedItem = UNSELECTED
    var mContext: Context
    private val courselist: List<ClaimModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.claim_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = courselist[position].name
        holder.reporting.text = courselist[position].reportingBy
        holder.accounting.text = courselist[position].accounting
    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var reporting: TextView
        var accounting: TextView

        init {
            name = itemView.findViewById(R.id.claim_name)
            reporting = itemView.findViewById(R.id.reporting_txt)
            accounting = itemView.findViewById(R.id.accounting)
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
