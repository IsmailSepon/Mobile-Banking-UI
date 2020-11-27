package com.cloudwell.paywell.uiCommon.pay.fragment.recurringBillPay

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.PaymentAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.TooltipAdapter
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.recurring_profile_layout.view.*


class RecurringProfileFragment : Fragment(), PaymentAdapter.PaymentClickListener,
    TooltipAdapter.tooltipClickListener {

    var select: Int = 1


    var p: Point? = null
    var bill_profile_pic : ImageView? = null
    var popup : PopupWindow? = null
    var bgLayout : LinearLayout? = null
    var part2 : ConstraintLayout? = null
    var recycler_title: TextView? = null
    lateinit var bottomNavigationView : BottomNavigationView // = null

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recurring_profile_layout, container, false)

        bill_profile_pic = view.recu_profile

        bgLayout  = view.hader_layout
        part2 = view.part2
        recycler_title = view.recycler_hader
        bottomNavigationView = view.recurring_bottom_navigation


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

     //   recycler.adapter  = activity?.applicationContext?.let { PaymentAdapter(it, paymentlist) }

        val adapter : PaymentAdapter = PaymentAdapter(requireContext(), paymentlist)
        recycler.adapter = adapter
        adapter.setClickListener(this)


        view.day_radio_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.recur_everyday_btn -> {
                    view.weekRadio.visibility = View.GONE
                    view.calender_lay.visibility = View.GONE
                }
                R.id.recur_everyweek_btn -> {
                    view.weekRadio.visibility = View.VISIBLE
                    view.calender_lay.visibility = View.GONE
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
                bottomMenu.visibility = View.VISIBLE
            }
        })





        view.recurring_bottom_navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.saveas -> {
                    FragmentHelper.replaceFragment(
                        RecurringSuccesfulFragment(),
                        requireActivity().supportFragmentManager,
                        R.id.payment_container
                    )
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

    override fun onPaymentClick(pojo: MyPaymentPOjo, view: View, position: Int) {
        val myViewRect = Rect()
        view.getGlobalVisibleRect(myViewRect)
        val x: Int = myViewRect.left
        val y: Int = myViewRect.top
        Log.e("margin-x", x.toString())
        Log.e("margin-y", y.toString())


        setAlpha()

        val location = IntArray(2)
        view.getLocationOnScreen(location)
        p = Point()
        p!!.x = location[0]
        p!!.y = location[1]

        if (p != null) showPopup(requireActivity(), p!!, position, view, x, y)
    }


    fun setAlpha(){
        part2!!.alpha = 0.1f
        bgLayout!!.alpha = 0.1f
        recycler_title!!.alpha = 0.1f
        bottomNavigationView.alpha = 0.1f

    }



    @SuppressLint("Range")
    fun removeAlpha(){
        part2!!.alpha = 100f
        bgLayout!!.alpha = 100f
        recycler_title!!.alpha =100f
        bottomNavigationView.alpha = 100f

    }

    // The method that displays the popup.
    private fun showPopup(
        context: Activity,
        p: Point,
        position: Int,
        view: View,
        marginLeft: Int,
        marginTop: Int
    ) {


        val popupWidth = LinearLayout.LayoutParams.MATCH_PARENT
        val popupHeight = LinearLayout.LayoutParams.WRAP_CONTENT
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.recur_tooltip_layout, null)


        // Creating the PopupWindow
        popup = PopupWindow(context)
        popup!!.contentView = layout
        popup!!.width = popupWidth
        popup!!.height = popupHeight
        popup!!.isFocusable = true
        popup!!.isOutsideTouchable = true


        val OFFSET_X = 30
        val OFFSET_Y = 30


        //Clear the default translucent background
        popup!!.setBackgroundDrawable(null)
        popup!!.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y)


        val arrow = layout.findViewById<ImageView>(R.id.arrow_up2)
        //val cardView = layout.findViewById<CardView>(R.id.cardView)
        val cardView = layout.findViewById<LinearLayout>(R.id.view)
        val recyclerView : RecyclerView  = layout.findViewById(R.id.tooltipRecycler)


        if (position==1){
            electricRecycler(recyclerView)

        }else if (position == 2){
            waterRecycler(recyclerView)

        }else if (position == 3){
            gasRecycler(recyclerView)

        }else if (position == 0){
            topupRecycler(recyclerView, cardView)
        }



        val lparams = arrow.layoutParams as LinearLayout.LayoutParams
        lparams.setMargins(marginLeft, 150, 0, 0)
        arrow.layoutParams = lparams


    }

    private fun waterRecycler(recyclerView: RecyclerView) {

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.layoutManager = linearLayoutManager


        val p1 : MyPaymentPOjo = MyPaymentPOjo()
        p1.name = "Dhaka WASA"
        p1.icon = R.drawable.wasa_ic

        val p2 : MyPaymentPOjo = MyPaymentPOjo()
        p2.name = "Rajshahi WASA"
        p2.icon = R.drawable.r_wasa


        val paymentlist = ArrayList<MyPaymentPOjo>()
        paymentlist.add(p1)
        paymentlist.add(p2)

        val adapter : TooltipAdapter = TooltipAdapter(requireContext(), paymentlist)
        recyclerView.adapter = adapter
        adapter.setClickListener(this)

    }

    private fun topupRecycler(recyclerView: RecyclerView, cardView: LinearLayout) {

        recyclerView.layoutManager = GridLayoutManager(context, 4)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.LEFT
        params.setMargins(40, -80, 40, 15)
        cardView.layoutParams = params

        // cardView.gravity = Gravity.START



        val p1 : MyPaymentPOjo = MyPaymentPOjo()
        p1.name = "GP"
        p1.icon = R.drawable.gp_ic

        val p2 : MyPaymentPOjo = MyPaymentPOjo()
        p2.name = "Robi"
        p2.icon = R.drawable.robi_ic

        val p3 : MyPaymentPOjo = MyPaymentPOjo()
        p3.name = "BL"
        p3.icon = R.drawable.banglalink_ic

        val p4 : MyPaymentPOjo = MyPaymentPOjo()
        p4.name = "Airtel"
        p4.icon = R.drawable.airtel_ic

        val p5 : MyPaymentPOjo = MyPaymentPOjo()
        p5.name = "Teletalk"
        p5.icon = R.drawable.teletalk_ic

        val p6 : MyPaymentPOjo = MyPaymentPOjo()
        p6.name = "Skitto"
        p6.icon = R.drawable.skitto

        val p7 : MyPaymentPOjo = MyPaymentPOjo()
        p7.name = "Brilliant"
        p7.icon = R.drawable.brillient


        val paymentlist = ArrayList<MyPaymentPOjo>()
        paymentlist.add(p1)
        paymentlist.add(p2)
        paymentlist.add(p3)
        paymentlist.add(p4)
        paymentlist.add(p5)
        paymentlist.add(p6)
        paymentlist.add(p7)

        val adapter : TooltipAdapter = TooltipAdapter(requireContext(), paymentlist)
        recyclerView.adapter = adapter
        adapter.setClickListener(this)


    }

    private fun gasRecycler(recyclerView: RecyclerView) {


        recyclerView.layoutManager = GridLayoutManager(context, 3)


        val p1 : MyPaymentPOjo = MyPaymentPOjo()
        p1.name = "Titas Non-Meter\n" +
                "GAS"
        p1.icon = R.drawable.titas_gas

        val p2 : MyPaymentPOjo = MyPaymentPOjo()
        p2.name = "TITAS Commercial\n" +
                "GAS"
        p2.icon = R.drawable.titas_gas

        val p3 : MyPaymentPOjo = MyPaymentPOjo()
        p3.name = "Karnaphuli\n" +
                "Non-Meter GAS"
        p3.icon = R.drawable.karnaphuli_gas

        val p4 : MyPaymentPOjo = MyPaymentPOjo()
        p4.name = "Karnaphuli Commercial\n" +
                "Metered GAS"
        p4.icon = R.drawable.karnaphuli_gas

        val p5 : MyPaymentPOjo = MyPaymentPOjo()
        p5.name = "Bakhrabad GAS"
        p5.icon = R.drawable.bakhrabad


        val paymentlist = ArrayList<MyPaymentPOjo>()
        paymentlist.add(p1)
        paymentlist.add(p2)
        paymentlist.add(p3)
        paymentlist.add(p4)
        paymentlist.add(p5)

        val adapter : TooltipAdapter = TooltipAdapter(requireContext(), paymentlist)
        recyclerView.adapter = adapter
        adapter.setClickListener(this)


    }

    private fun electricRecycler(recyclerView: RecyclerView) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.layoutManager = linearLayoutManager
        //  recyclerView.layoutManager = GridLayoutManager(context, 5)


        val p1 : MyPaymentPOjo = MyPaymentPOjo()
        p1.name = "DESCO"
        p1.icon = R.drawable.desco_ic

        val p2 : MyPaymentPOjo = MyPaymentPOjo()
        p2.name = "DPDC"
        p2.icon = R.drawable.dpdc

        val p3 : MyPaymentPOjo = MyPaymentPOjo()
        p3.name = "Westzone"
        p3.icon = R.drawable.west_zone

        val p4 : MyPaymentPOjo = MyPaymentPOjo()
        p4.name = "Polli Biddyut"
        p4.icon = R.drawable.polli_biddut_ic


        val paymentlist = ArrayList<MyPaymentPOjo>()
        paymentlist.add(p1)
        paymentlist.add(p2)
        paymentlist.add(p3)
        paymentlist.add(p4)
        paymentlist.add(p4)

        val adapter : TooltipAdapter = TooltipAdapter(requireContext(), paymentlist)
        recyclerView.adapter = adapter
        adapter.setClickListener(this)


    }

    override fun onTooltipClick(pojo: MyPaymentPOjo) {
        removeAlpha()
        popup!!.dismiss()
        bill_profile_pic?.setImageResource(pojo.icon!!)


    }
}
