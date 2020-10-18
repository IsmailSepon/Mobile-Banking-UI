package com.cloudwell.paywell.uiCommon.pay.fragment.recurringBillPay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.model.RecurringBillPOjo
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.google.gson.Gson


class RecurringDetailsFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recurring_details_layout, container, false)

        val pojo : String = requireArguments().getString("recurring", "")
        val gson = Gson()

        val recurring : RecurringBillPOjo = gson.fromJson(pojo, RecurringBillPOjo::class.java)


        val recurring_recycler : RecyclerView = view.findViewById(R.id.recuring_details_recyclerview)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recurring_recycler.layoutManager = linearLayoutManager

      //  val list = ArrayList<RecurringPOjo>()
        val list = ArrayList<UtilityPOjo>()

        val recuringPojo : UtilityPOjo = UtilityPOjo()
        recuringPojo.name = "GP"
        recuringPojo.icon = R.drawable.gp_ic



        return view
    }




}
