package com.cloudwell.paywell.ui.ticket.airticket.finalReview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.ticket.airticket.flightDetails2.model.Passenger
import kotlinx.android.synthetic.main.passenger_list_item_final.view.*

class AdapterForPassengersFinalList(var context: Context, var items: List<Passenger>, private var onClickListener: OnClickListener) : RecyclerView.Adapter<AdapterForPassengersFinalList.ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.passenger_list_item_final, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items.get(position)

        val number = position + 1
        holder.tvShortFirstNameLastName.text = "Passenger No: " + number


        val paxType = model.paxType
        val capPaxType = paxType.substring(0, 1).toUpperCase() + paxType.substring(1)
        holder.tvPassengerType.text = "Passenger type: " + capPaxType

        if (model.isLeadPassenger) {
            holder.tvLeadPassenger.text = "Lead passenger: Yes"
        } else {
            holder.tvLeadPassenger.text = "Lead passenger: No"
        }

        holder.tvTitle.text = "Title: " + model.title
        holder.tvFirstName.text = "First Name: " + model.firstName
        holder.tvLastName.text = "Last Name: " + model.lastName
        holder.tvCountry.text = "Country: " + model.country
        holder.tvGender.text = "Gender: " + model.gender
        holder.tvContactNumber.text = "Contact Number: " + model.contactNumber
        holder.tvEmailAddress.text = "Email: " + model.email
        holder.tvDateOfBirth.text = "Date Of Birth: " + model.dateOfBirth

        if (model.passportNumber.equals("")) {
            holder.tvPassport.visibility = View.GONE
        } else {
            holder.tvPassport.visibility = View.VISIBLE
            holder.tvPassport.text = "Passport ID: " + model.passportNumber
        }

        if (model.nIDnumber.equals("")) {
            holder.tvNid.visibility = View.GONE
        } else {
            holder.tvNid.visibility = View.VISIBLE
            holder.tvNid.text = "National ID: " + model.nIDnumber
        }

        if (model.passportExpiryDate.equals("")) {
            holder.tvPassportExpiryDate.visibility = View.GONE
        } else {
            holder.tvPassportExpiryDate.visibility = View.VISIBLE
            holder.tvPassportExpiryDate.text = context.getString(R.string.passport_expiry_date) + ": " + model.passportExpiryDate
        }

        if (model.passportNationality.equals("")) {
            holder.tvPassportNationallity.visibility = View.GONE
        } else {
            holder.tvPassportNationallity.visibility = View.VISIBLE
            holder.tvPassportNationallity.text = context.getString(R.string.passport_nationality) + ": " + model.passportNationality
        }

        holder.ivEdit.setOnClickListener {

            onClickListener.onEditClick(model, position)
        }

        holder.viewBackgoud.setOnClickListener {
            onClickListener.onEditClick(model, position)
        }


    }

    public fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvShortFirstNameLastName = view.tvShortFirstNameLastName
        val ivEdit = view.ivEdit
        val tvPassengerType = view.tvPassengerTypeFinal
        val tvLeadPassenger = view.tvLeadPassenger
        val tvTitle = view.tvTitle
        val tvFirstName = view.tvFirstName
        val tvLastName = view.tvLastName
        val tvCountry = view.tvCountry
        val tvGender = view.tvGender
        val tvDateOfBirth = view.tvDateOfBirth
        val tvContactNumber = view.tvContactNumber
        val tvEmailAddress = view.tvEmailAddress
        val tvPassport = view.tvPasswordFinal
        val tvNid = view.tvNid
        val tvPassportExpiryDate = view.tvPassportExpiryDate
        val tvPassportNationallity = view.tvPassportNationallity
        val viewBackgoud = view.viewBackgoud


    }

    interface OnClickListener {
        fun onEditClick(model: Passenger, position: Int)

        fun onDeleted(model: Passenger, position: Int)
    }

}
