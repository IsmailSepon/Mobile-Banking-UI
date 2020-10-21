package com.cloudwell.paywell.uiCommon.pay.fragment.recurringBillPay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.PaymentAdapter
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo
import kotlinx.android.synthetic.main.recurring_profile_layout.view.*


class RecurringProfileFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recurring_profile_layout, container, false)

//        val pojo : String = requireArguments().getString("recurring", "")
//        val gson = Gson()
//        val recurring : RecurringBillPOjo = gson.fromJson(pojo, RecurringBillPOjo::class.java)

        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        val recycler = view.chooseservice_recycler
        recycler.layoutManager = layoutManager

        val payment : MyPaymentPOjo = MyPaymentPOjo()
        payment.name = "Top-up"
        payment.icon = R.drawable.pay_topup

        val payment1 : MyPaymentPOjo = MyPaymentPOjo()
        payment1.name = "Electricity"
        payment1.icon = R.drawable.electricity_ic

        val payment2 : MyPaymentPOjo = MyPaymentPOjo()
        payment2.name = "Water"
        payment2.icon = R.drawable.water_bill_ic

        val payment3 : MyPaymentPOjo = MyPaymentPOjo()
        payment3.name = "GAS"
        payment3.icon = R.drawable.gas_ic



        val paymentlist = ArrayList<MyPaymentPOjo>()
        paymentlist.add(payment)
        paymentlist.add(payment1)
        paymentlist.add(payment2)
        paymentlist.add(payment3)

        recycler.adapter  = activity?.applicationContext?.let { PaymentAdapter(it, paymentlist) }




        return view
    }




}
