package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.booking.model.BookingList
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransactionLog.BusTransactionLogActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.cencel.BusCancelActiivty
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.appController.AppController
import com.cloudwell.paywell.base.BusTricketBaseActivity
import com.cloudwell.paywell.constant.IconConstant
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.recentList.model.RecentUsedMenu
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.search.BusCitySearchActivity
import com.cloudwell.paywell.utils.ConnectionDetector
import com.cloudwell.paywell.utils.LanuageConstant.KEY_BANGLA
import com.cloudwell.paywell.utils.LanuageConstant.KEY_ENGLISH
import com.cloudwell.paywell.utils.StringConstant
import kotlinx.android.synthetic.main.activity_bus_tricket_menu.*
import java.util.*


class BusTicketMenuActivity : BusTricketBaseActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    val KEY_TAG = BusTicketMenuActivity::class.java.name
    val BOOKING_TAG = "BOOKING"
    val TRX_TAG = "TRX_LOG"


    lateinit var mConstraintLayout: ConstraintLayout


    internal var radioButton_five: RadioButton? = null
    internal var radioButton_ten: RadioButton? = null
    internal var radioButton_twenty: RadioButton? = null
    internal var radioButton_fifty: RadioButton? = null
    internal var radioButton_hundred: RadioButton? = null
    internal var radioButton_twoHundred: RadioButton? = null
    var selectedLimit = 5
    lateinit var cd: ConnectionDetector


    companion object {
        val KEY_LIMIT = "LIMIT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_tricket_menu)


        val isBusTicket = AppStorageBox.get(applicationContext, AppStorageBox.Key.IS_BUS_Ticket_USER_FLOW) as Boolean
        if (isBusTicket) {
            setToolbar(getString(R.string.home_eticket_bus), resources.getColor(R.color.bus_ticket_toolbar_title_text_color))
            constraintLayoutBookingList.setBackgroundResource(R.drawable.bus_menu_bg)
        }else{
            setToolbar(getString(R.string.launch), resources.getColor(R.color.bus_ticket_toolbar_title_text_color))
            constraintLayoutBookingList.setBackgroundResource(R.drawable.backgourd_lunch_menu)
        }


        btViewTricket.setOnClickListener(this)
        btTransationLog.setOnClickListener(this)
        btCancel.setOnClickListener(this)



        //callnewApiTest()


        cd = ConnectionDetector(AppController.getContext())
        mConstraintLayout = findViewById(R.id.constraintLayoutBookingList)
        mAppHandler = AppHandler.getmInstance(applicationContext)


        addRecentUsedList(isBusTicket)


    }

    private fun addRecentUsedList(isBusTicket: Boolean) {
        if (isBusTicket) {
            val recentUsedMenu = RecentUsedMenu(StringConstant.KEY_home_bus, StringConstant.KEY_home_ticket, IconConstant.KEY_ic_ticket, 0, 34)
         //   addItemToRecentListInDB(recentUsedMenu)
        } else {
            val recentUsedMenu = RecentUsedMenu(StringConstant.KEY_launch, StringConstant.KEY_launch, IconConstant.KEY_ic_launch_ticket, 0, 35)
         //   addItemToRecentListInDB(recentUsedMenu)

        }
    }


    override fun onResume() {
        super.onResume()
        selectedLimit = 5
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btViewTricket -> {
                startActivity(Intent(applicationContext, BusCitySearchActivity::class.java))
            }


            R.id.btTransationLog -> {
                showLimitPrompt(TRX_TAG)

            }

            R.id.btBooking -> {

                showLimitPrompt(BOOKING_TAG)

            }
            R.id.btCancel -> {
                startActivity(Intent(applicationContext, BusCancelActiivty::class.java))
            }
        }
    }


    private fun showReposeUI(response: BookingList) {
        val builder = AlertDialog.Builder(this@BusTicketMenuActivity)
        builder.setTitle("Result")
        builder.setMessage(response.message)
        builder.setPositiveButton(R.string.okay_btn) { dialogInterface, id ->
            dialogInterface.dismiss()
        }
        val alert = builder.create()
        alert.show()

    }

    private fun showLimitPrompt(tag: String) {
        val dialog = AppCompatDialog(this)
        if (tag.equals(BOOKING_TAG)) {
            dialog.setTitle(R.string.book)
        } else if (tag.equals(TRX_TAG)) {
            dialog.setTitle(R.string.booking_log_limit_title_msg)
        }

        dialog.setContentView(R.layout.dialog_trx_limit)

        val btn_okay = dialog.findViewById<Button>(R.id.buttonOk)
        val btn_cancel = dialog.findViewById<Button>(R.id.cancelBtn)

        radioButton_five = dialog.findViewById(R.id.radio_five)
        radioButton_ten = dialog.findViewById(R.id.radio_ten)
        radioButton_twenty = dialog.findViewById(R.id.radio_twenty)
        radioButton_fifty = dialog.findViewById(R.id.radio_fifty)
        radioButton_hundred = dialog.findViewById(R.id.radio_hundred)
        radioButton_twoHundred = dialog.findViewById(R.id.radio_twoHundred)

        radioButton_five?.setOnCheckedChangeListener(this)
        radioButton_ten?.setOnCheckedChangeListener(this)
        radioButton_twenty?.setOnCheckedChangeListener(this)
        radioButton_fifty?.setOnCheckedChangeListener(this)
        radioButton_hundred?.setOnCheckedChangeListener(this)
        radioButton_twoHundred?.setOnCheckedChangeListener(this)

        assert(btn_okay != null)
        btn_okay!!.setOnClickListener {
            dialog.dismiss()
            if (isInternetConnection) {

                val intent = Intent(application, BusTransactionLogActivity::class.java)
                intent.putExtra(KEY_LIMIT, selectedLimit)
                startActivity(intent)

            } else {
                showNoInternetConnectionFound()
            }


        }
        assert(btn_cancel != null)
        btn_cancel!!.setOnClickListener { dialog.dismiss() }
        dialog.setCancelable(true)
        dialog.show()
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        if (isChecked) {
            if (buttonView.id == R.id.radio_five) {
                selectedLimit = 5
                radioButton_ten?.isChecked = false
                radioButton_twenty?.isChecked = false
                radioButton_fifty?.isChecked = false
                radioButton_hundred?.isChecked = false
                radioButton_twoHundred?.isChecked = false
            }
            if (buttonView.id == R.id.radio_ten) {
                selectedLimit = 10
                radioButton_five?.isChecked = false
                radioButton_twenty?.isChecked = false
                radioButton_fifty?.isChecked = false
                radioButton_hundred?.isChecked = false
                radioButton_twoHundred?.isChecked = false
            }
            if (buttonView.id == R.id.radio_twenty) {
                selectedLimit = 20
                radioButton_five?.isChecked = false
                radioButton_ten?.isChecked = false
                radioButton_fifty?.isChecked = false
                radioButton_hundred?.isChecked = false
                radioButton_twoHundred?.isChecked = false
            }
            if (buttonView.id == R.id.radio_fifty) {
                selectedLimit = 50
                radioButton_five?.isChecked = false
                radioButton_ten?.isChecked = false
                radioButton_twenty?.isChecked = false
                radioButton_hundred?.isChecked = false
                radioButton_twoHundred?.isChecked = false
            }
            if (buttonView.id == R.id.radio_hundred) {
                selectedLimit = 100
                radioButton_five?.isChecked = false
                radioButton_ten?.isChecked = false
                radioButton_twenty?.isChecked = false
                radioButton_fifty?.isChecked = false
                radioButton_twoHundred?.isChecked = false
            }
            if (buttonView.id == R.id.radio_twoHundred) {
                selectedLimit = 200
                radioButton_five?.isChecked = false
                radioButton_ten?.isChecked = false
                radioButton_twenty?.isChecked = false
                radioButton_fifty?.isChecked = false
                radioButton_hundred?.isChecked = false
            }
        }
    }

    override fun onBackPressed() {

        val isEnglish = mAppHandler.appLanguage.equals("en", ignoreCase = true)
        if (isEnglish) {
            switchToCzLocale(Locale(KEY_ENGLISH, ""))
        } else {
            switchToCzLocale(Locale(KEY_BANGLA, ""))
        }


        super.onBackPressed()
    }
}
