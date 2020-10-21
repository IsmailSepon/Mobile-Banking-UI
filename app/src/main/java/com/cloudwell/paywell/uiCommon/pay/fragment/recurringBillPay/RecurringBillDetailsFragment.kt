package com.cloudwell.paywell.uiCommon.pay.fragment.recurringBillPay

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.RecurringBillAdapter
import com.cloudwell.paywell.uiCommon.pay.model.RecurringBillPOjo
import com.cloudwell.paywell.utils.FragmentHelper


class RecurringBillDetailsFragment : Fragment(), RecurringBillAdapter.RecurringItemClickListener {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recurring_bill_details_layout, container, false)



        val recurring_recycler : RecyclerView = view.findViewById(R.id.recuring_recyclerview)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recurring_recycler.layoutManager = linearLayoutManager

        val list = ArrayList<RecurringBillPOjo>()

        val pojo : RecurringBillPOjo = RecurringBillPOjo()

        pojo.amount = "৳500"
        pojo.details = "Created on 8 June, activated on 10 June"
        pojo.icon = R.drawable.recurring_gp
        pojo.number = "+880 1758712950, Prepaid"
        pojo.name = "Grameenphone"

        list.add(pojo)
        list.add(pojo)


        val recurringAdapter : RecurringBillAdapter = RecurringBillAdapter(requireContext(), list)
        recurring_recycler.adapter = activity?.applicationContext?.let { recurringAdapter }
        recurringAdapter.setClickListener(this)




        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }



    override fun onRecClick(pojo: RecurringBillPOjo) {
        val fg = RecurringProfileFragment()
//        val bundle  = Bundle()
//        val gson = Gson()
//        val json = gson.toJson(pojo)
//        bundle.putString("recurring", json)
//        fg.arguments = bundle
        FragmentHelper.replaceFragment(
            fg, requireActivity().supportFragmentManager, R.id.payment_container
        )

    }


}
