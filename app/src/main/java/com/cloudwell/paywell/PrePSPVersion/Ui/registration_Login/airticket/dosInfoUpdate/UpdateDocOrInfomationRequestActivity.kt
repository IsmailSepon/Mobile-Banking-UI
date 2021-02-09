package com.cloudwell.paywell.services.activity.eticket.airticket.dosInfoUpdate

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.base.AirTricketBaseActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.retrofit.ApiUtils
import com.cloudwell.paywell.services.activity.eticket.airticket.booking.model.Datum
import com.cloudwell.paywell.services.activity.eticket.airticket.booking.model.Passenger
import com.cloudwell.paywell.services.activity.eticket.airticket.bookingCencel.fragment.ShowMessageFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.dosInfoUpdate.adapter.AdapterForPassengersReIssue
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.dosInfoUpdate.editReissuePassengerActivity.DosInfoUpdatePassengerActivity
import com.cloudwell.paywell.services.activity.eticket.airticket.dosInfoUpdate.model.ReissuePassenger
import com.cloudwell.paywell.utils.UniqueKeyGenerator
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_docs_update_ticket.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateDocOrInfomationRequestActivity : AirTricketBaseActivity(), ShowMessageFragment.MyInterface {
    override fun onOkButtonClick() {

    }

   // private val rvJoiner = RvJoiner(true)//auto update ON, stable ids ON

    companion object {
        lateinit var item: Datum
        lateinit var passengers: MutableList<Passenger>
        fun newIntent(context: Context, item: Datum): Intent {
            val intent = Intent(context, UpdateDocOrInfomationRequestActivity::class.java)
            this.item = item
            this.passengers = item.passengers as MutableList<Passenger>
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docs_update_ticket)
        setToolbar(getString(R.string.title_docs_update))


    }

    override fun onResume() {
        super.onResume()

        initializationViewNew()
    }

    private fun initializationViewNew() {

        passengers.toMutableList().let {

            val recyclerListAdapter = AdapterForPassengersReIssue(this, it, object : AdapterForPassengersReIssue.OnClickListener {
                override fun onEditClick(model: Passenger, position: Int) {

                    val intent = Intent(applicationContext, DosInfoUpdatePassengerActivity::class.java)
                    intent.putExtra("id", position)
                    startActivity(intent)
                }

                override fun onDeleted(model: Passenger, position: Int) {

                }

            })


            val glm = LinearLayoutManager(applicationContext)
            recycler_view.layoutManager = glm
            recycler_view.itemAnimator = DefaultItemAnimator()
            recycler_view.setHasFixedSize(true)
            recycler_view.isNestedScrollingEnabled = true
            recycler_view.adapter = recyclerListAdapter

        }


        btReissueRequest.setOnClickListener {

            handleReissueRequest()

        }

    }

    private fun handleReissueRequest() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Reason")

        val pinNoET = EditText(this)
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        pinNoET.gravity = Gravity.CENTER_HORIZONTAL
        pinNoET.layoutParams = lp
        builder.setView(pinNoET)

        builder.setPositiveButton(R.string.okay_btn) { dialogInterface, id ->
            val inMethMan = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inMethMan.hideSoftInputFromWindow(pinNoET.windowToken, 0)

            if (pinNoET.text.toString().length != 0) {
                dialogInterface.dismiss()
                var resoun = pinNoET.text.toString()
                if (isInternetConnection) {

                    askForPin(resoun)

                } else {
                    val snackbar = Snackbar.make(linearLayout12, R.string.connection_error_msg, Snackbar.LENGTH_LONG)
                    snackbar.setActionTextColor(Color.parseColor("#ffffff"))
                    val snackBarView = snackbar.view
                    snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"))
                    snackbar.show()
                }
            } else {
                val snackbar = Snackbar.make(linearLayout12, "Please enter a reason", Snackbar.LENGTH_LONG)
                snackbar.setActionTextColor(Color.parseColor("#ffffff"))
                val snackBarView = snackbar.view
                snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"))
                snackbar.show()
            }
        }
        builder.setNegativeButton(R.string.cancel) { dialogInterface, i -> dialogInterface.dismiss() }
        val alert = builder.create()
        alert.show()

    }

    private fun askForPin(cancelReason: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.pin_no_title_msg)

        val pinNoET = EditText(this)
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        pinNoET.gravity = Gravity.CENTER_HORIZONTAL
        pinNoET.layoutParams = lp
        pinNoET.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_TEXT_VARIATION_PASSWORD
        pinNoET.transformationMethod = PasswordTransformationMethod.getInstance()
        builder.setView(pinNoET)

        builder.setPositiveButton(R.string.okay_btn) { dialogInterface, id ->
            val inMethMan = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inMethMan.hideSoftInputFromWindow(pinNoET.windowToken, 0)

            if (pinNoET.text.toString().length != 0) {
                dialogInterface.dismiss()
                val PIN_NO = pinNoET.text.toString()
                if (isInternetConnection) {

                    val mAppHandler = AppHandler.getmInstance(application)
                    val userName = mAppHandler.userName



                    submitRescheduleAPI(userName, PIN_NO, item.bookingId, cancelReason, "json")


                } else {
                    val snackbar = Snackbar.make(linearLayout12, R.string.connection_error_msg, Snackbar.LENGTH_LONG)
                    snackbar.setActionTextColor(Color.parseColor("#ffffff"))
                    val snackBarView = snackbar.view
                    snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"))
                    snackbar.show()
                }
            } else {
                val snackbar = Snackbar.make(linearLayout12, R.string.pin_no_error_msg, Snackbar.LENGTH_LONG)
                snackbar.setActionTextColor(Color.parseColor("#ffffff"))
                val snackBarView = snackbar.view
                snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"))
                snackbar.show()
            }
        }
        builder.setNegativeButton(R.string.cancel) { dialogInterface, i -> dialogInterface.dismiss() }
        val alert = builder.create()
        alert.show()
    }

    private fun submitRescheduleAPI(userName: String, pass: String, bookingId: String?, cancelReason: String, apiFormat: String) {
        showProgressDialog()


        val apiNameReissuePassenger = mutableListOf<ReissuePassenger>()
        passengers.forEach {
            val p = ReissuePassenger()
            p.title = it.nameTitle
            p.paxtype = it.paxType
            p.firstname = it.firstName
            p.lastname = it.lastName
            p.gender = it.gender
            p.contactnumber = it.contactNumber
            p.countrycode = it.countryCode
            p.dateofbirth = it.dateOfBirth
            p.email = it.email
            p.nationality = it.nationality
            p.passportExpiryDate = it.passportExpiryDate
            p.passportNationality = it.passportNationality
            p.passportNumber = it.passportNumber
            apiNameReissuePassenger.add(p)
        }

        val uniqueKey = UniqueKeyGenerator.getUniqueKey(AppHandler.getmInstance(this)!!.rid)

        ApiUtils.getAPIService().infoUpdateTicket(userName, pass, bookingId, cancelReason, Gson().toJson(apiNameReissuePassenger),uniqueKey).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                dismissProgressDialog()

                if (response.isSuccessful) {
                    if (response.isSuccessful) {
                        val jsonObject = response.body()
                        val message = jsonObject!!.get("message_details").asString
                        val status = jsonObject.get("status").asInt

                        if (status == 200) {
                            showMsg(message, status)
                        } else {
                            showMsg(message, status)
                        }

                    }
                }

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(this@UpdateDocOrInfomationRequestActivity, "Network error!!!", Toast.LENGTH_SHORT).show()
                dismissProgressDialog()
            }
        })

    }

    private fun showMsg(msg: String, status: Int) {

        val showMessageFragment = ShowMessageFragment()
        ShowMessageFragment.message = msg
        showMessageFragment.mListener = object : ShowMessageFragment.MyInterface {
            override fun onOkButtonClick() {
                if (status == 200) {
                    finish()
                }
            }
        }
        showMessageFragment.show(supportFragmentManager, "dialog")

    }




    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
    }
}
