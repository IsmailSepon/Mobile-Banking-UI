package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.transationLog.viewBookingInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.base.AirTricketBaseActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.booking.model.Datum
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.flightDetails1.model.Airport
import com.cloudwell.paywell.R
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.transationLog.viewBookingInfo.adapter.AdapterForPassengersBookingInfo
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.transationLog.viewBookingInfo.adapter.AirportListBookingInfoAdapter
import su.j2e.rvjoiner.JoinableAdapter
import su.j2e.rvjoiner.JoinableLayout
import su.j2e.rvjoiner.RvJoiner

class ViewBookingInfoActivity : AirTricketBaseActivity() {

    private val rvJoiner = RvJoiner(true)//auto update ON, stable ids ON

    companion object {
        lateinit var item: Datum
        fun newIntent(context: Context, item: Datum): Intent {
            val intent = Intent(context, ViewBookingInfoActivity::class.java)
            Companion.item = item
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_booking_info_new)
        setToolbar(getString(R.string.booking_info))

        //initializationView()
        initializationViewNew()

    }

    private fun initializationViewNew() {
        val trips = item.trips

        val airportList = mutableSetOf<Airport>()

        trips.forEach {

            val originAirport = Airport()
            originAirport.airportCode = it.originAirportCode
            originAirport.airportName = it.originAirportName
            originAirport.terminal = it.originTerminal
            originAirport.countryName = it.originCountry
            originAirport.cityName = it.originCity
            airportList.add(originAirport)

            val destinationAirport = Airport()
            destinationAirport.airportCode = it.destinationAirportCode
            destinationAirport.airportName = it.destinationAirportName
            destinationAirport.terminal = it.destinationTerminal
            destinationAirport.countryName = it.destinationCountry
            destinationAirport.cityName = it.destinationCity

            airportList.add(destinationAirport)
        }

        val recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        setLinearLayoutManager(recyclerView)
        val airportListBookingInfoAdapter = AirportListBookingInfoAdapter(this, airportList.toList())
        rvJoiner.add(JoinableAdapter(airportListBookingInfoAdapter))

        rvJoiner.add(JoinableLayout(R.layout.activity_view_booking_info, object : JoinableLayout.Callback {
            override fun onInflateComplete(view: View?, parent: ViewGroup?) {
                val tvAirlineCode = view?.findViewById(R.id.tvAirlineCode) as TextView
                val tvAirlesscode = view?.findViewById(R.id.tvAirlesscode) as TextView
                val tvFlghtNumber = view?.findViewById(R.id.tvFlghtNumber) as TextView
                val tvBookingClass = view?.findViewById(R.id.tvBookingClass) as TextView
                val tvOperatorCarrier = view?.findViewById(R.id.tvOperatorCarrier) as TextView
                val tvCabinClass = view?.findViewById(R.id.tvCabinClass) as TextView
                val tvBaggage = view?.findViewById(R.id.tvBaggage) as TextView
                val tveDpartureTime = view?.findViewById(R.id.tveDpartureTime) as TextView


                val trip = item.trips[0]
                tvAirlineCode.text = getString(R.string.airline_code) + " ${trip.airlineCode}"
                tvAirlesscode.text = getString(R.string.airport_name) + " ${trip.airlineName}"
                tvFlghtNumber.text = getString(R.string.flight_number) + " ${trip.flightNumber}"
                tvBookingClass.text = getString(R.string.booking_class) + " ${trip.bookingClass}"
                tvOperatorCarrier.text = getString(R.string.operating_carrier) + " ${trip.operatingCareer}"
                tvCabinClass.text = getString(R.string.cabin_class) + " ${trip.cabinClass}"



                tvBaggage.text = getString(R.string.baggage) + trips[0].baggage + " " + getString(R.string.kg_per_adult)
                var text = ""


                for ((i, value) in trips.withIndex()) {
                    val arrivalTime = value.arrivalTime
                    val departureTime = value.departureTime

                    text = text + "Departure Time " + (i + 1) + ": " + departureTime + "\n"
                    text = text + "Arrival Time " + (i + 1) + ": " + arrivalTime + "\n\n"

                }

                text = text.substring(0, text.length - 2)
                tveDpartureTime.text = "" + text

            }

        }))


        item.passengers?.toMutableList()?.let {

            val recyclerListAdapter = AdapterForPassengersBookingInfo(this, it)

            val glm = LinearLayoutManager(applicationContext)
            recyclerView.layoutManager = glm
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.layoutManager = glm
            recyclerView.setHasFixedSize(true)
            recyclerView.isNestedScrollingEnabled = true
            recyclerView.adapter = recyclerListAdapter

            rvJoiner.add(JoinableAdapter(recyclerListAdapter))
            recyclerView.adapter = rvJoiner.adapter

        }


    }

    private fun setLinearLayoutManager(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }




//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        if (item!!.itemId == android.R.id.home)
//            onBackPressed()
//        return super.onOptionsItemSelected(item)
//    }

    override fun onBackPressed() {
        finish()
    }
}
