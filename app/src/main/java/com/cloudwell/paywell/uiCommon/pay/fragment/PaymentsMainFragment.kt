package com.cloudwell.paywell.uiCommon.pay.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.menu.AirTicketMenuActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.analytics.AnalyticsManager
import com.cloudwell.paywell.analytics.AnalyticsParameters
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.uiCommon.PaymentMainActivity
import com.cloudwell.paywell.uiCommon.pay.adapter.PayAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.PaymentAdapter
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo
import com.cloudwell.paywell.uiCommon.pay.model.PaytoPOjo
import kotlinx.android.synthetic.main.payments_main_layout.view.*


class PaymentsMainFragment : Fragment(), PaymentAdapter.PaymentClickListener {


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

        val adapter= PaymentAdapter(requireContext(), paymentlist)
        recycler1.adapter  = adapter //activity?.applicationContext?.let { PaymentAdapter(it, paymentlist) }
        adapter.setClickListener(this)


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


        view.recurinng_billpay.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "3")
            view.context.startActivity(intent)

        })






        view.utility_btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "4")
            view.context.startActivity(intent)

        })


        view.card_emi.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "5")
            view.context.startActivity(intent)

        })




        view.whoto_pay.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "6")
            view.context.startActivity(intent)

        })


        view.ticket_btn.setOnClickListener(View.OnClickListener {

            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "7")
            view.context.startActivity(intent)

        })




        return view
    }

    override fun onPaymentClick(pojo: MyPaymentPOjo, view: View, position: Int) {

        if (pojo.name.equals("Bus ticket")){

//            AppStorageBox.put(requireContext(), AppStorageBox.Key.IS_BUS_Ticket_USER_FLOW, true)
//            AnalyticsManager.sendScreenView(AnalyticsParameters.KEY_BUS_TICKET)
//            startActivity(Intent(requireContext(), BusTicketMenuActivity::class.java))

        }else if (pojo.name.equals("Air ticket")){
             val mainIntent = Intent(requireContext(), AirTicketMenuActivity::class.java)
            this.startActivity(mainIntent)
        }


    }


}