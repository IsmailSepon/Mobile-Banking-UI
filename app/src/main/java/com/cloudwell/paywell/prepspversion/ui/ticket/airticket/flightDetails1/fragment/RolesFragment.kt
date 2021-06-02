package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.BaggageAndPoliciesActiivty
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.model.RequestAirPriceSearch
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.model.airRules.Datum
import com.cloudwell.paywell.R
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.FlightDetails1Status
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.adapter.ExpandableListAdapter
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.viewModel.FlightDetails1ViewModel
import kotlinx.android.synthetic.main.fragment_roles.view.*


class RolesFragment : Fragment() {

    private lateinit var mFlightDetails1ViewModel: FlightDetails1ViewModel


    // view
    var listAdapter: ExpandableListAdapter? = null
    var listDataHeader = mutableListOf<String>()
    var listDataChild = mutableMapOf<String, ArrayList<String>>()
    lateinit var lvExp: ExpandableListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mFlightDetails1ViewModel = ViewModelProviders.of(requireActivity()).get(FlightDetails1ViewModel::class.java!!)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_roles, container, false)


        // preparing list data
        lvExp = v.lvExp as ExpandableListView

        mFlightDetails1ViewModel.baseViewStatus.observe(this, Observer {
            val baggageAndPoliciesActiivty = activity as BaggageAndPoliciesActiivty
            baggageAndPoliciesActiivty.handleViewCommonStatus(it)

        })


        mFlightDetails1ViewModel.mViewStatus.observe(this, Observer {
            it?.let { it1 -> handleViewStatus(it1) }
        })


        mFlightDetails1ViewModel.mListMutableLiveDataAirRules.observe(  this, Observer {

            it?.let { it1 -> displayData(it1) }

        })

        val serachId = activity?.applicationContext?.let { AppStorageBox.get(it, AppStorageBox.Key.SERACH_ID) } as String
        val requestID = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.Request_ID) as String


        val requestAirPriceSearch = RequestAirPriceSearch()
        requestAirPriceSearch.resultID = requestID
        requestAirPriceSearch.searchId = serachId


        if (listDataHeader.size == 0) {
            mFlightDetails1ViewModel.callAirRolesAPI(requestAirPriceSearch)
        }



        return v
    }

    private fun handleViewStatus(it: FlightDetails1Status) {

        val baggageAndPoliciesActiivty = activity as BaggageAndPoliciesActiivty

        if (it.isShowProcessIndicator) {
            baggageAndPoliciesActiivty.showProgressDialog()

        } else {
            baggageAndPoliciesActiivty.dismissProgressDialog()

        }
    }

    private fun displayData(it1: List<Datum>) {

        listDataHeader.clear()
        listDataChild.clear()

        it1.forEach {

            listDataHeader.add(it.ruleType)
            val arrayListOf = arrayListOf<String>()
            arrayListOf.add(it.ruleDetails)


            listDataChild.put(it.ruleType, arrayListOf)

        }


        listAdapter = ExpandableListAdapter(activity?.applicationContext!!, listDataHeader, listDataChild)

        // setting list mAdapter
        lvExp.setAdapter(listAdapter)

        listAdapter?.notifyDataSetChanged()

    }


}
