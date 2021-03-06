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
import kotlinx.android.synthetic.main.recurring_bill_details_layout.view.*


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


        val pojo1 : RecurringBillPOjo = RecurringBillPOjo()
        pojo1.amount = "৳500"
        pojo1.details = "Created on 8 June, activated on 10 June"
        pojo1.icon = R.drawable.recurrnig_robi
        pojo1.number = "+880 1758712950, Prepaid"
        pojo1.name = "Grameenphone"

        val pojo2 : RecurringBillPOjo = RecurringBillPOjo()
        pojo2.amount = "৳500"
        pojo2.details = "Created on 8 June, activated on 10 June"
        pojo2.icon = R.drawable.recurring_wasa
        pojo2.number = "+880 1758712950, Prepaid"
        pojo2.name = "Grameenphone"

        list.add(pojo)
        list.add(pojo1)
        list.add(pojo2)


        val recurringAdapter : RecurringBillAdapter = RecurringBillAdapter(requireContext(), list)
        recurring_recycler.adapter = activity?.applicationContext?.let { recurringAdapter }
        recurringAdapter.setClickListener(this)


        view.new_recuring_bill.setOnClickListener(View.OnClickListener {
            val fg = RecurringProfileFragment()
            FragmentHelper.replaceFragment(
                fg, requireActivity().supportFragmentManager, R.id.payment_container
            )

        })


        view.recurring_back.setOnClickListener(View.OnClickListener {
           // FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
            activity?.finish()
        })

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
