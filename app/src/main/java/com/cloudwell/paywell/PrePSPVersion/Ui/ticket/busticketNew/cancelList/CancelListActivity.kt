package com.cloudwell.paywell.services.activity.eticket.busticketNew.cancelList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.services.R
import com.cloudwell.paywell.services.activity.base.BusTricketBaseActivity
import com.cloudwell.paywell.services.activity.eticket.busticketNew.cancelList.adapter.CancelListAdapter
import com.cloudwell.paywell.services.activity.eticket.busticketNew.cancelList.adapter.CancelListAdapter.OnClick
import com.cloudwell.paywell.services.activity.eticket.busticketNew.cencel.BusTicketCancelOtpActivity
import com.cloudwell.paywell.services.activity.eticket.busticketNew.cencel.model.RequestTicketInformationForCancel
import com.cloudwell.paywell.services.activity.eticket.busticketNew.cencel.model.ResponseTicketInformationCancel
import com.cloudwell.paywell.services.activity.eticket.busticketNew.cencel.model.TicketInfo
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.RequestRenerateOtpForCancelTicket
import com.cloudwell.paywell.services.retrofit.ApiUtils
import kotlinx.android.synthetic.main.activity_cancel_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CancelListActivity : BusTricketBaseActivity() {
    var busTransactionRV: RecyclerView? = null
    var allDataArrayList: ArrayList<*> = ArrayList<Any?>()
    var adapter: CancelListAdapter? = null
    var limit = 0
    private var date = ""
    lateinit var password: String
    lateinit var requestTicketInformationForCancel: RequestTicketInformationForCancel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancel_list)
        setToolbar(getString(R.string.title_ticket_cancel_list), resources.getColor(R.color.bus_ticket_toolbar_title_text_color))

        requestTicketInformationForCancel = intent.getParcelableExtra<RequestTicketInformationForCancel>("RequestTicketInformationForCancel")


    }

    override fun onResume() {
        super.onResume()
        val userName = mAppHandler.userName
        callToBookingListAPI()
    }


    fun callToBookingListAPI() {
        showProgressDialog()

        ApiUtils.getAPIServiceV2().ticketInformationForCancel(requestTicketInformationForCancel).enqueue(object : Callback<ResponseTicketInformationCancel?> {
            override fun onResponse(call: Call<ResponseTicketInformationCancel?>, response: Response<ResponseTicketInformationCancel?>) {
                dismissProgressDialog()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body?.statusCode == 200) {

                        setupAdapter(body)

                    } else {
                        // body?.message?.let { showBusTicketErrorDialog(it) }
                        finish()
                    }
                } else {
                    showBusTicketErrorDialog(getString(R.string.network_error), true)
                }
            }

            override fun onFailure(call: Call<ResponseTicketInformationCancel?>, t: Throwable) {
                toast(getString(R.string.network_error))
                dismissProgressDialog()

            }
        })

    }

    private fun setupAdapter(body: ResponseTicketInformationCancel) {
        if (body.ticketInfo?.size ?: 0 == 0) {
            finish()
        } else {
            busTransactionLogRV.setLayoutManager(LinearLayoutManager(applicationContext))
            adapter = body.ticketInfo?.let {
                CancelListAdapter(it, object : OnClick {
                    override fun onClick(ticketInfo: TicketInfo) {

                        askForPin(ticketInfo)

                       // generateOtpForCancelTicket(ticketInfo, password)
                    }
                })
            }
            busTransactionLogRV.setAdapter(adapter)
        }

    }


    private fun generateOtpForCancelTicket(ticketInfo: TicketInfo, password: String) {

        showProgressDialog()

        val userName = mAppHandler.userName

        val m = RequestRenerateOtpForCancelTicket()
        m.trxId = "" + ticketInfo.trxId
        m.ticketNo = "" + ticketInfo.ticketNo
        m.username = userName
        m.password = password

        ApiUtils.getAPIServiceV2().generateOtpForCancelTicket(m).enqueue(object : Callback<ResponseTicketInformationCancel?> {
            override fun onResponse(call: Call<ResponseTicketInformationCancel?>, response: Response<ResponseTicketInformationCancel?>) {
                dismissProgressDialog()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body?.statusCode == 205) {
                        val intent = Intent(this@CancelListActivity, BusTicketCancelOtpActivity::class.java).also {
                            it.putExtra("data", ticketInfo)
                            it.putExtra("pin", password)
                        }
                        startActivity(intent)

                    } else {
                        body?.message?.let { showBusTicketErrorDialog(it, true) }
                    }
                } else {
                    showBusTicketErrorDialog(getString(R.string.network_error))
                }

            }

            override fun onFailure(call: Call<ResponseTicketInformationCancel?>, t: Throwable) {
                toast(getString(R.string.network_error))
                dismissProgressDialog()

            }
        })

    }

    private fun askForPin(ticketInfo: TicketInfo) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.pin_no_title_msg)
        val pinNoET = EditText(this)
        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        pinNoET.gravity = Gravity.CENTER_HORIZONTAL
        pinNoET.layoutParams = lp
        pinNoET.inputType = InputType.TYPE_CLASS_NUMBER or
                InputType.TYPE_TEXT_VARIATION_PASSWORD
        pinNoET.transformationMethod = PasswordTransformationMethod.getInstance()
        builder.setView(pinNoET)
        builder.setPositiveButton(R.string.okay_btn) { dialogInterface, id ->
            val inMethMan = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inMethMan.hideSoftInputFromWindow(pinNoET.windowToken, 0)
            if (pinNoET.text.toString().length != 0) {
                dialogInterface.dismiss()
                var PIN_NO = pinNoET.text.toString()

                if (isInternetConnection) {
                    val userName = mAppHandler.userName
                    generateOtpForCancelTicket(ticketInfo, PIN_NO)
                } else {
                    showBusTicketErrorDialog(getString(R.string.connection_error_msg), false)

                }
            } else {

                showBusTicketErrorDialog(getString(R.string.pin_no_error_msg), false)


            }
        }
        builder.setNegativeButton(R.string.cancel_btn) { dialogInterface, i -> dialogInterface.dismiss() }
        val alert = builder.create()
        alert.show()
    }
}


