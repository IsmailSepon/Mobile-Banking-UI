package com.cloudwell.paywell.uiCommon.pay.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo

/**
 * Created by Sepon on 9/9/2020.
 */
class PaymentAdapter(mContext: Context, courselist: List<MyPaymentPOjo>) :
    RecyclerView.Adapter<PaymentAdapter.ViewHolder?>() {
    private val recyclerView: RecyclerView? = null
    private val selectedItem = UNSELECTED
    var mContext: Context

    var index  = -1

    private var clickListener: PaymentClickListener? = null



    private val courselist: List<MyPaymentPOjo>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.mypayment_item, parent, false)
        return ViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n", "Range")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     //   holder.amount.text = courselist[position].amount
        holder.name.text = courselist[position].name
        //holder.icon.setImageResource(courselist.get(position).icon!!)
        holder.icon.setImageResource(courselist.get(position).icon!!)


        holder.itemView.setOnClickListener(View.OnClickListener {
            clickListener?.onPaymentClick(courselist.get(position), it, position)



            index = position
            notifyDataSetChanged()

        })

        if (index==position){

            holder.icon.setColorFilter(mContext.getColor(R.color.colorPrimaryDark))
            holder.name.setTextColor(mContext.getColor(R.color.colorPrimaryDark))
            holder.layout.alpha = 100f
        }else{

            holder.icon.setColorFilter(mContext.getColor(R.color.keypad_text_clr))
            holder.name.setTextColor(mContext.getColor(R.color.keypad_text_clr))

            if (index >= 0){
                holder.layout.alpha = 0.2f
            }

        }

    }

    override fun getItemCount(): Int {
        return courselist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView
        var icon : ImageView
        var layout : ConstraintLayout

        init {
            name = itemView.findViewById(R.id.paymenet_name)
            icon = itemView.findViewById(R.id.payment_icon)
            layout = itemView.findViewById(R.id.item_layout)
        }
    }

    companion object {
        private const val UNSELECTED = -1
    }

    init {
        this.mContext = mContext
        this.courselist = courselist
    }

    fun setClickListener(itemClickListener: PaymentClickListener) {
        clickListener = itemClickListener
    }

    interface PaymentClickListener {
        fun onPaymentClick(pojo : MyPaymentPOjo, view : View, position : Int)
    }

}
