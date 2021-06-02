package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.ticketCencel

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.Spinner
import androidx.constraintlayout.widget.ConstraintLayout
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.base.AirTricketBaseActivity
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.booking.model.Datum
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.bookingCencel.fragment.CancellationStatusMessageFragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.utils.ConnectionDetector
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_ticket_cencel.*
import mehdi.sakout.fancybuttons.FancyButton


class TicketCancelActivity : AirTricketBaseActivity() {

    private var bookingCancelReasonSPNR: Spinner? = null
    private var cancelBookingBtn: FancyButton? = null
    private var cd: ConnectionDetector? = null
    private var cancelMainLayout: ConstraintLayout? = null
    var mAppHandler: AppHandler? = null
    private var bookingId = String()
    private var title = String()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_cencel)

        if (supportActionBar != null) {

        }
        if (intent.getStringExtra(KEY_BOOKING_ID) != null) {
            bookingId = intent.getStringExtra(KEY_BOOKING_ID)
        }

        if (intent.getStringExtra(KEY_TITLE) != null) {
            title = intent.getStringExtra(KEY_TITLE)
//            supportActionBar!!.title = title
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        cd = ConnectionDetector(applicationContext)
        mAppHandler = AppHandler.getmInstance(applicationContext)

        cancelMainLayout = findViewById(R.id.cancelMainLayout)
        bookingCancelReasonSPNR = findViewById(R.id.cancelReasonSPNR)


        cancelBookingBtn = findViewById(R.id.cancelBookingBtn)


        if (model != null){
            bookingIdET.setText(model!!.bookingId)
            bookingIdET.setKeyListener(null)
        }


        cancelBookingBtn!!.setText(title)
        cancelBookingBtn!!.setOnClickListener {
            if (!bookingIdET!!.text.toString().isEmpty() && !etReasons.text.toString().trim().equals("")) {

                val mAppHandler = AppHandler.getmInstance(applicationContext)
                val userName = mAppHandler.userName

                val reason = etReasons.text.toString().trim()

                callCancelMapping(userName, bookingIdET.getText().toString(), reason, title, Datum())


            } else {

                hideUserKeyboard()

                val snackbar = Snackbar.make(cancelMainLayout!!, "Please Enter all the fields first", Snackbar.LENGTH_LONG)
                snackbar.setActionTextColor(Color.parseColor("#ffffff"))
                val snackBarView = snackbar.view
                snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"))
                snackbar.show()
            }
        }

    }


    private fun showMsg(msg: String) {

        val priceChangeFragment = CancellationStatusMessageFragment()
        CancellationStatusMessageFragment.message = msg

        priceChangeFragment.show(supportFragmentManager, "dialog")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
    }

    companion object {
        var KEY_BOOKING_ID = "Booking_Id"
        var KEY_TITLE = "KEY_TITLE"
        var model: Datum? = null
    }

}
