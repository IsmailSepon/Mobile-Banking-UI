package com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.adapter.FareListAdapter
import com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.model.Fare
import com.cloudwell.paywell.services.app.storage.AppStorageBox
import com.cloudwell.paywell.services.utils.CalculationHelper
import kotlinx.android.synthetic.main.fragment_flight_fare_fragment.view.*


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 4/3/19.
 */

class FlightFareFragment : Fragment() {
    var fare = mutableListOf<Fare>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fare = AppStorageBox.get(activity?.applicationContext, AppStorageBox.Key.FARE_DATA) as MutableList<Fare>

        val v = inflater.inflate(com.cloudwell.paywell.services.R.layout.fragment_flight_fare_fragment, container, false)



        v.rvFareList.setNestedScrollingEnabled(false)
        val mLayoutManager = LinearLayoutManager(activity!!.applicationContext)
        v.rvFareList.setLayoutManager(mLayoutManager)
        v.rvFareList.setItemAnimator(DefaultItemAnimator())


        val temp = mutableListOf<Fare>()

        val AIRLINE_CODE = AppStorageBox.get(activity?.applicationContext, AppStorageBox.Key.AIRLINE_CODE) as String


        for (f in fare) {
            val calculatorFare = CalculationHelper.getFare(f, AIRLINE_CODE)
            temp.add(calculatorFare)
        }


        fare = AppStorageBox.get(activity?.applicationContext, AppStorageBox.Key.FARE_DATA) as MutableList<Fare>

        val total = CalculationHelper.getTotalFareDetati(fare, AIRLINE_CODE)
        val fare1 = Fare()
        fare1.amount = total
        temp.add(fare1)

        val recyclerListAdapter = FareListAdapter(activity?.applicationContext!!, temp)
        v.rvFareList.adapter = recyclerListAdapter

        val dividerItemDecoration = DividerItemDecoration(v.rvFareList.getContext(), mLayoutManager.getOrientation())
        v.rvFareList.addItemDecoration(dividerItemDecoration);

        return v
    }


}
