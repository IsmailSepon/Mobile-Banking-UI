package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.base.AirTricketBaseActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.booking.model.Datum
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.activity_air_ticket_main.*

open class AirTicketMainActivity : AirTricketBaseActivity() {

    companion object {
        var item: Datum = Datum()
        fun newIntent(context: Context, item: Datum): Intent {
            val intent = Intent(context, AirTicketMainActivity::class.java)
            Companion.item = item
            return intent
        }
    }


    var popup : PopupWindow? = null
    var p: Point? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_ticket_main)

//        assert(supportActionBar != null)
//        if (supportActionBar != null) {
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//            supportActionBar!!.setTitle(getString(R.string.search_flights))
//            supportActionBar!!.elevation = 0f
//            supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#189d49")));
//        }

        val fragmentAdapter = SearchFlightAdapter(supportFragmentManager, item)
        viewpager_main.adapter = fragmentAdapter

        tabLayout_main.setupWithViewPager(viewpager_main)

        search_flight_back.setOnClickListener(View.OnClickListener {
            this.finish()
        })

        air_control.setOnClickListener(View.OnClickListener {


            val view: View = air_control//window.decorView.rootView
            val location = IntArray(2)
            view.getLocationOnScreen(location)

            p = Point()
            p!!.x = location[0]
            p!!.y = location[1]

            if (p != null) showPopup(this, p!!)

        })
    }


    // The method that displays the popup.
    private fun showPopup(
        context: Activity,
        p: Point
    ) {


        val popupWidth = LinearLayout.LayoutParams.MATCH_PARENT
        val popupHeight = LinearLayout.LayoutParams.WRAP_CONTENT
        val inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.airticket_control_popup, null)


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

        val arrow = layout.findViewById<LinearLayout>(R.id.setting_liner)


        val layoutParams = arrow.layoutParams as LinearLayout.LayoutParams

        layoutParams.setMargins(30, 20, 30, 0)


        arrow.layoutParams = layoutParams



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {
        item = Datum()
        finish()
        super.onBackPressed()
    }
}
