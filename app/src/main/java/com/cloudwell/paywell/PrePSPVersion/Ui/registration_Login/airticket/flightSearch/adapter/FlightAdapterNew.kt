package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightSearch.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cloudwell.paywell.R
import com.cloudwell.paywell.data.network.AllUrl
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.RequestAirSearch
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.Result
import com.cloudwell.paywell.utils.CalculationHelper
import kotlinx.android.synthetic.main.flight_list_item_new.view.*


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 19/2/19.
 */
class FlightAdapterNew(val items: List<Result>, val requestAirSearch: RequestAirSearch, val context: Context, var isReSchuduler: Boolean, val onClickListener: OnClickListener) : RecyclerView.Adapter<ViewHolderNew>() {


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolderNew, position: Int) {


        val model = items.get(position)

        holder.tvAirlessName.text = model.segments.get(0).airline?.airlineName

        if (position == 0) {
            holder.ivTake.setImageResource(R.drawable.ic_tk_symbol_low)
            val parseColor = Color.parseColor("#f15a24")
            holder.tvPrices.setTextColor(parseColor)
        } else {
            holder.ivTake.setImageResource(R.drawable.ic_tk_symbol_normal)
            val parseColor = Color.BLACK
            holder.tvPrices.setTextColor(parseColor)
        }

        val fares = model.fares
        val totalPrice = CalculationHelper.getTotalFare(fares, model.segments.get(0).airline?.airlineCode)
        holder.tvPrices.text = totalPrice


        holder.tvAdult.text = "${requestAirSearch.adultQuantity}  Adult"
        holder.tvchildAndInfant.text = "${requestAirSearch.childQuantity}  Child, ${requestAirSearch.infantQuantity} Infant"


        val recyclerViewLayoutManager = GridLayoutManager(context, 2)


        holder.recyclerView.setLayoutManager(recyclerViewLayoutManager)

        holder.recyclerView.adapter = FlightRecycleViewAdapter(context, items.get(position).segments, requestAirSearch)


        val airlineCode = model.segments.get(0).airline?.airlineCode


        val options = RequestOptions()
                .placeholder(R.drawable.air_ticket)
                .error(R.drawable.air_ticket)

        val url = "${AllUrl.flightAdapter}${airlineCode}_40x35.png"
        Glide.with(context).load(url)
                .apply(options)
                .into(holder.airlineSerachIcon);

        if (isReSchuduler) {
            holder.btDetails.text = "Request"

        }

        holder.btDetails.setOnClickListener {
            if (isReSchuduler) {
                onClickListener.onClickRequestForReSchuder(model)

            } else {
                onClickListener.onClick(position)
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNew {
        val view = LayoutInflater.from(context).inflate(R.layout.flight_list_item_new, parent, false)
        return ViewHolderNew(view)
    }


    override fun getItemCount(): Int {
        return items.size
    }


}

interface OnClickListener {

    fun onClick(position: Int)
    fun onClickRequestForReSchuder(result: Result)
}


class ViewHolderNew(view: View) : RecyclerView.ViewHolder(view) {
    val tvTotalPrices = view.tvTotalPrices
    val tvAirlessName = view.tvAirlessName
    val tvPrices = view.tvPrices
    val btDetails = view.btDetails
    val ivTake = view.ivTake
    val tvAdult = view.tvAdult
    val tvchildAndInfant = view.tvchildAndInfant
    val recyclerView = view.recyclerView
    val airlineSerachIcon = view.airlineSerachIcon


}
