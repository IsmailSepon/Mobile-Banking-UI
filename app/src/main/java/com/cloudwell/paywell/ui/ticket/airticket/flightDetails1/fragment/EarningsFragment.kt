package com.cloudwell.paywell.ui.ticket.airticket.flightDetails1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.ticket.airticket.flightDetails1.model.Fare
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.utils.CalculationHelper
import kotlinx.android.synthetic.main.fragment_earnings.view.*


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 4/3/19.
 */

class EarningsFragment() : Fragment() {
    var fare = mutableListOf<Fare>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fare = activity?.applicationContext?.let { AppStorageBox.get(it, AppStorageBox.Key.FARE_DATA) } as MutableList<Fare>
        val v = inflater.inflate(R.layout.fragment_earnings, container, false)


        val retailerEaring = CalculationHelper.retailerEarning(fare)


        v.tvEarning.text = retailerEaring


        return v
    }


}
