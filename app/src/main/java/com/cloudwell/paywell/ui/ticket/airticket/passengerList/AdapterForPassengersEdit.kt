package com.cloudwell.paywell.ui.ticket.airticket.passengerList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.ui.ticket.airticket.flightDetails2.model.Passenger
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.passenger_list_item_defalt_edit.view.*

class AdapterForPassengersEdit(var context: Context, var items: List<Passenger>, private var onClickListener: OnClickListener) : RecyclerView.Adapter<AdapterForPassengersEdit.ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(context).inflate(R.layout.passenger_list_item_defalt_edit, parent, false)
        return ViewHolder(view)


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items.get(position)
        holder.tvShortFirstNameLastName.text = "${model.firstName} / ${model.lastName}"
//        holder.tvPassport.text = "${model.firstName} | ${model.lastName}"

        holder.ivEdit.setOnClickListener {
            onClickListener.onEditClick(model, position)
        }

        holder.ivDeleted.setOnClickListener {
            onClickListener.onDeleted(model, position)
        }

        if (!model.passportNumber.equals("")) {
            holder.tvPassport.text = model.passportNumber
        }

        if (!model.nIDnumber.equals("")) {
            holder.tvPassport.text = model.nIDnumber
        }

    }

    public fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvShortFirstNameLastName = view.tvShortFirstNameLastName
        val tvPassport = view.tvPasswordFinal
        val ivEdit = view.ivEdit
        val ivDeleted = view.ivDeleted


    }

    interface OnClickListener {
        fun onEditClick(model: Passenger, position: Int)

        fun onDeleted(model: Passenger, position: Int)
    }

}
