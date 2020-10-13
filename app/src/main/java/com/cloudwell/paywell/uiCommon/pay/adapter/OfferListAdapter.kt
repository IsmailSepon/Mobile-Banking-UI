package com.cloudwell.paywell.uiCommon.pay.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp.ComboOfferFragment


/**
 * Created by Sepon on 9/9/2020.
 */
class OfferListAdapter(mContext: Context, courselist: List<String>) :
    RecyclerView.Adapter<OfferListAdapter.ViewHolder?>() {

    var mContext: Context
    private val courselist: List<String>
    private var clickListener: OfferClickListener? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.topup_offer_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.offer_details.text = courselist[position]

        holder.offer_selection_btn.setOnClickListener(View.OnClickListener {

            (mContext as Activity).finish()

        })
        //holder.icon.setImageResource(courselist.get(position).icon!!)


//        holder.itemView.setOnClickListener(View.OnClickListener {
//            clickListener?.onClick(courselist.get(position))
//        })


    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var offer_details : TextView
        var offer_selection_btn : RadioButton

        init {
            offer_details = itemView.findViewById(R.id.offer_details)
            offer_selection_btn = itemView.findViewById(R.id.offer_selection_btn)
        }
    }

    companion object {
        private const val UNSELECTED = -1
    }

    init {
        this.mContext = mContext
        this.courselist = courselist
    }

    fun setClickListener(itemClickListener: ComboOfferFragment) {
        clickListener = itemClickListener
    }

    interface OfferClickListener {
        fun onClick(pojo : String)
    }

}
