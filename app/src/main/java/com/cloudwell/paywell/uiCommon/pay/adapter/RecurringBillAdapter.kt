package com.cloudwell.paywell.uiCommon.pay.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.model.RecurringBillPOjo

/**
 * Created by Sepon on 9/9/2020.
 */
class RecurringBillAdapter(mContext: Context, courselist: List<RecurringBillPOjo>) :
    RecyclerView.Adapter<RecurringBillAdapter.ViewHolder?>() {


    var mContext: Context
    private val courselist: List<RecurringBillPOjo>
  //  private var clickListener: OnItemClickListener? = null


    private var clickListener: RecurringItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recurring_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     //   holder.amount.text = courselist[position].amount
        holder.name.text = courselist[position].name
        holder.icon.setImageResource(courselist.get(position).icon!!)

        holder.itemView.setOnClickListener(View.OnClickListener {
            clickListener?.onRecClick(courselist.get(position))
        })

    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    fun setClickListener(itemClickListener: RecurringItemClickListener?) {
        clickListener = itemClickListener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name : TextView
        var number : TextView
        var details : TextView
        var icon : ImageView


        init {
            name = itemView.findViewById(R.id.name)
            number = itemView.findViewById(R.id.number)
            details = itemView.findViewById(R.id.details)
            icon = itemView.findViewById(R.id.recurring_pic)

        }

    }

    companion object {
        private const val UNSELECTED = -1
    }

    init {
        this.mContext = mContext
        this.courselist = courselist
    }

    interface RecurringItemClickListener {
        fun onRecClick(pojo : RecurringBillPOjo)
    }
}
