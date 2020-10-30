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
import com.cloudwell.paywell.uiCommon.pay.adapter.PaymentAdapter
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo


class RecurringBillScheduleFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recurring_bill_schedule_layout, container, false)



        val recurring_recycler : RecyclerView = view.findViewById(R.id.recuring_service_recycler)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recurring_recycler.layoutManager = linearLayoutManager


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

        recurring_recycler.adapter  = activity?.applicationContext?.let { PaymentAdapter(it, paymentlist) }


//        val navmenu : BottomNavigationView = view.recurring_schedule_bottomnav
//        navmenu.visibility = View.INVISIBLE
//
//
//        view.schedule_scrollview.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
//            //Log.d(TAG, "onScrollChangeForY - scrollY: $scrollY oldScrollY: $oldScrollY")
//            var MOVE = -1
//            val SCROLL_UP = 0
//            val SCROLL_DOWN = 1
//            val initialPositionY: Float = view.scrollview.y
//            MOVE = if (scrollY > oldScrollY) SCROLL_UP else SCROLL_DOWN
//            if (MOVE == SCROLL_UP) {
//                navmenu.visibility =  View.VISIBLE
//            }
//        })



        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }





}
