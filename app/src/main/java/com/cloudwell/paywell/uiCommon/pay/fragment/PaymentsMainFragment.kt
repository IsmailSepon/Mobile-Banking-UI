package com.cloudwell.paywell.uiCommon.pay.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.PaymentMainActivity
import com.cloudwell.paywell.uiCommon.pay.adapter.PayAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.PaymentAdapter
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo
import com.cloudwell.paywell.uiCommon.pay.model.PaytoPOjo
import kotlinx.android.synthetic.main.payments_main_layout.view.*


class PaymentsMainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.payments_main_layout, container, false)


        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        val layoutManager1 =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        val recycler = view.horizental_payto_recycler
        recycler.layoutManager = layoutManager


        val recycler1 = view.mypayment_recycler
        recycler1.layoutManager = layoutManager1


        val pojo : PaytoPOjo = PaytoPOjo()
        pojo.name = "Amzad Hossain"


        val list = ArrayList<PaytoPOjo>()
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)


        recycler.adapter  = activity?.applicationContext?.let { PayAdapter(it, list) }


        val payment : MyPaymentPOjo = MyPaymentPOjo()
        payment.name = "Bus ticket"
        payment.icon = R.drawable.bus_ticket_ic

        val payment1 : MyPaymentPOjo = MyPaymentPOjo()
        payment1.name = "Air ticket"
        payment1.icon = R.drawable.air_ticket

        val payment2 : MyPaymentPOjo = MyPaymentPOjo()
        payment2.name = "Shopping"
        payment2.icon = R.drawable.shopping_ic

        val payment3 : MyPaymentPOjo = MyPaymentPOjo()
        payment3.name = "Visa fee"
        payment3.icon = R.drawable.visa_fee

        val payment4 : MyPaymentPOjo = MyPaymentPOjo()
        payment4.name = "Water bill"
        payment4.icon = R.drawable.water_bill_ic

        val payment5 : MyPaymentPOjo = MyPaymentPOjo()
        payment5.name = "GAS"
        payment5.icon = R.drawable.gas_ic


        val paymentlist = ArrayList<MyPaymentPOjo>()
        paymentlist.add(payment)
        paymentlist.add(payment1)
        paymentlist.add(payment2)
        paymentlist.add(payment3)
        paymentlist.add(payment4)
        paymentlist.add(payment5)

        recycler1.adapter  = activity?.applicationContext?.let { PaymentAdapter(it, paymentlist) }




        view.username_txt.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "1")
            view.context.startActivity(intent)

        })


        view.search_location.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "2")
            view.context.startActivity(intent)

        })






        return view
    }


}