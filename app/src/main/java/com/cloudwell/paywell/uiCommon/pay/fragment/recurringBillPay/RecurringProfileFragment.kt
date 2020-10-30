package com.cloudwell.paywell.uiCommon.pay.fragment.recurringBillPay

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.PaymentAdapter
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.recurring_profile_layout.view.*


class RecurringProfileFragment : Fragment() {

    var select: Int = 1

    @RequiresApi(Build.VERSION_CODES.M)
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

        val layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
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




        view.day_radio_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.recur_everyday_btn -> {
                    view.weekRadio.visibility = View.GONE
                }
                R.id.recur_everyweek_btn -> {
                    view.weekRadio.visibility = View.VISIBLE
                }
                R.id.recur_everymonth_btn -> {
                    view.weekRadio.visibility = View.GONE
                    view.calender_lay.visibility = View.VISIBLE
                }
            }
        })


        val bottomMenu : BottomNavigationView = view.recurring_bottom_navigation
        bottomMenu.visibility =  View.INVISIBLE


        view.scrollview.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            //Log.d(TAG, "onScrollChangeForY - scrollY: $scrollY oldScrollY: $oldScrollY")
            var MOVE = -1
            val SCROLL_UP = 0
            val SCROLL_DOWN = 1
            val initialPositionY: Float = view.scrollview.y
            MOVE = if (scrollY > oldScrollY) SCROLL_UP else SCROLL_DOWN
            if (MOVE == SCROLL_UP) {
                bottomMenu.visibility =  View.VISIBLE
            }
        })





        view.recurring_bottom_navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.saveas -> {
                    FragmentHelper.replaceFragment(RecurringSuccesfulFragment(), requireActivity().supportFragmentManager, R.id.payment_container)
                    true
                }
                R.id.activeDeactive -> {


                    true
                }
                R.id.cancel -> {

                    FragmentHelper.removeFragment(requireActivity().supportFragmentManager)

                    true
                }
                else -> false
            }
        }


        return view
    }




}
