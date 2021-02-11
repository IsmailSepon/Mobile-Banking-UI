package com.cloudwell.paywell.services.activity.notification.notificaitonFullView


import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.media.RingtoneManager
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.util.Linkify
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.services.R
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.base.newBase.MVVMBaseActivity
import com.cloudwell.paywell.services.activity.notification.ImageViewActivity
import com.cloudwell.paywell.services.activity.notification.allNotificaiton.NotificationAllActivity
import com.cloudwell.paywell.services.activity.notification.allNotificaiton.NotificationAllActivity.Companion.IS_NOTIFICATION_SHOWN
import com.cloudwell.paywell.services.activity.notification.model.NotificationDetailMessage
import com.cloudwell.paywell.services.activity.notification.model.RequestSDABalancceRetrun
import com.cloudwell.paywell.services.activity.notification.notificaitonFullView.view.NotificationFullViewStatus
import com.cloudwell.paywell.services.activity.notification.notificaitonFullView.viewModel.NotificationFullNotifcationViewModel
import com.cloudwell.paywell.services.activity.utility.pallibidyut.bill.PBBillPayNewActivity
import com.cloudwell.paywell.services.activity.utility.pallibidyut.model.REBNotification
import com.cloudwell.paywell.services.activity.utility.pallibidyut.registion.PBRegistrationActivity
import com.cloudwell.paywell.services.analytics.AnalyticsManager
import com.cloudwell.paywell.services.analytics.AnalyticsParameters
import com.cloudwell.paywell.services.app.AppController
import com.cloudwell.paywell.services.app.AppHandler
import com.cloudwell.paywell.services.retrofit.ApiUtils
import com.cloudwell.paywell.services.utils.AppHelper.startNotificationSyncService
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_notification_full_view.*
import okhttp3.ResponseBody
import org.apache.commons.lang3.StringEscapeUtils
import org.json.JSONException
import org.json.JSONObject


class NotificationFullViewActivity : MVVMBaseActivity() {

    private var mAppHandler: AppHandler? = null

    internal var isNotificationFlow: Boolean = false
    private lateinit var viewModel: NotificationFullNotifcationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_full_view)
        setToolbar(getString(R.string.home_notification_details))

        mAppHandler = AppHandler.getmInstance(applicationContext)

        initViewModel()

        handleLanguage()

        AnalyticsManager.sendScreenView(AnalyticsParameters.KEY_NOTIFICATION_PAPGE_DETAILS);

    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(NotificationFullNotifcationViewModel::class.java)

        viewModel.baseViewStatus.observe(this, Observer {
            handleViewCommonStatus(it)
        })

        viewModel.mViewStatus.observe(this, Observer {
            handleViewStatus(it)
        })

        viewModel.mListMutableLiveData.observe(this, Observer {
            displayData(it)
        })

        isNotificationFlow = this.getIntent().getBooleanExtra("isNotificationFlow", false)

        var fcmNotificationDetails = ""
        try {
            fcmNotificationDetails = intent.extras?.getString("Notification_Details", "") as String
        } catch (e: Exception) {
            fcmNotificationDetails = ""
        }

        viewModel.init(isNotificationFlow, fcmNotificationDetails)
    }

    private fun handleViewStatus(status: NotificationFullViewStatus?) {
        when (status) {
            NotificationFullViewStatus.START_NOTIFICATION_SERVICE -> startNotificationSyncService(applicationContext)
        }

    }

    fun handleLanguage() {
        if (mAppHandler?.getAppLanguage().equals("en")) {
            notiTitle?.setTypeface(AppController.getInstance().getOxygenLightFont())
            notiMessage?.setTypeface(AppController.getInstance().getOxygenLightFont())

        } else {
            notiTitle?.setTypeface(AppController.getInstance().getAponaLohitFont())
            notiMessage?.setTypeface(AppController.getInstance().getAponaLohitFont())
        }
    }

    private fun displayData(it: NotificationDetailMessage?) {
        Logger.v("" + Gson().toJson(it))

        val message = it?.message
        val messageSub = it?.messageSub
        val imageUrl = it?.imageUrl
        val dateTime = it?.addedDatetime
        val type = it?.type


        var testmessage = "" + message
        Logger.v(testmessage)
        testmessage = StringEscapeUtils.unescapeJava(testmessage)

        testmessage = testmessage.replace("\\", "")
        testmessage = testmessage.replace("\\\\".toRegex(), "")
        testmessage = testmessage.replace("\\\\\\\\".toRegex(), "")
        testmessage = testmessage.replace("\\\\\\\\\\\\".toRegex(), "")

        if (testmessage.contains("notification_action_type")) {
            // air ticket flow
            handleAirTicket(testmessage, messageSub, dateTime)

        } else {
            // normal

            btAccept.visibility = View.GONE
            btTicketCancel.visibility = View.GONE
            handleNormal(it)
        }


    }

    private fun handleNormal(model: NotificationDetailMessage?) {
        val s1 = StringEscapeUtils.unescapeJava(model?.message);

        val spannableString = SpannableString(s1);
        Linkify.addLinks(spannableString, Linkify.WEB_URLS);

        notiTitle.text = model?.messageSub
        notiMessage.text = spannableString
        date.text = model?.addedDatetime

        if (model?.imageUrl != null){

            if (!model.imageUrl.equals("")) {
                showProgressDialog();
                notiImg?.setVisibility(View.VISIBLE);
                val display = getWindowManager().getDefaultDisplay();
                val size = Point();
                display.getSize(size);
                val width = size.x;


                Picasso.get().load(model.imageUrl)
                        .resize(width, 0)
                        .into(notiImg, object : Callback {
                            override fun onError(e: Exception?) {
                                dismissProgressDialog();
                            }

                            override fun onSuccess() {
                                dismissProgressDialog();
                            }
                        })
                notiImg.setOnClickListener {
                    ImageViewActivity.TAG_IMAGE_URL = model?.imageUrl
                    val intent = Intent(this, ImageViewActivity::class.java)
                    startActivity(intent)

                }
            }
        }


        if (model?.type.equals("BalanceReturnPwl") || model?.messageSub.equals("PW Balance Return")) {
            notiEditText.setVisibility(View.VISIBLE)
            notiButton.setVisibility(View.VISIBLE)

            notiButton.setOnClickListener {

                if (!notiEditText.getText().toString().isEmpty()) {


                    val split = model?.balanceReturnData?.split("@")
                    val shadowId = split?.get(0)?.split("=")?.get(1)
                    val dealerId = split?.get(1)?.split("=")?.get(1)
                    val marchentId = split?.get(2)?.split("=")?.get(1)
                    val password = split?.get(3)?.split("=")?.get(1)
                    val imeiNo = split?.get(4)?.split("=")?.get(1)
                    val amount = split?.get(5)?.split("=")?.get(1)
                    Logger.v("")

                    val m = RequestSDABalancceRetrun()
                    m.merchentPassword = ""+notiEditText.getText().toString()
                    m.username = mAppHandler!!.userName
                    m.messageId = ""+model?.messageId
                    m.password = ""+password
                    m.amount = ""+amount
                    m.dealerId = ""+dealerId
                    m.shadowId= ""+shadowId
                    m.imeiNo = ""+imeiNo
                    m.marchentId = ""+marchentId

                    pinRequest(m)



                } else {
                    val snackbar = Snackbar.make(linearLayoutNotiFullView, R.string.pin_no_error_msg, Snackbar.LENGTH_LONG)
                    snackbar.setActionTextColor(Color.parseColor("#ffffff"))
                    val snackBarView = snackbar.view
                    snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"))
                    snackbar.show()
                }


            }

        }else {
            try {
                var message = StringEscapeUtils.unescapeJava(model?.balanceReturnData)

                message = message.replace("\\", "")
                message = message.replace("\\\\", "")
                message = message.replace("\\\\\\\\", "")
                message = message.replace("\\\\\\\\\\\\", "")

                val rn: REBNotification = Gson().fromJson(message, REBNotification::class.java)

                val m = StringEscapeUtils.unescapeJava(message)
                val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

                if (rn.ServiceType == "REB_BILL") {
                    if (rn.TrxData.StatusCode == 200 || rn.TrxData.StatusCode == 303 || rn.TrxData.StatusCode == 100 || rn.TrxData.StatusCode == 327) {

                    } else {
                        btResubmitREB.setText(getString(R.string.re_submit_reb));
                        btResubmitREB.visibility = View.VISIBLE
                        btResubmitREB.setOnClickListener {

                            val intentActionAccept = Intent(applicationContext, PBBillPayNewActivity::class.java)
                            intentActionAccept.putExtra("REBNotification", Gson().toJson(rn))
                            startActivity(intentActionAccept)

                        }
                    }
                } else if (rn.ServiceType == "REB_REG") {
                    if (rn.TrxData.StatusCode == 200 || rn.TrxData.StatusCode == 328 || rn.TrxData.StatusCode == 100) {

                    } else {
                        btResubmitREB.setText(getString(R.string.re_submit_reb));
                        btResubmitREB.visibility = View.VISIBLE
                        btResubmitREB.setOnClickListener {

                            val intentActionAccept = Intent(applicationContext, PBRegistrationActivity::class.java)
                            intentActionAccept.putExtra("REBNotification", Gson().toJson(rn))
                            startActivity(intentActionAccept)

                        }

                    }
                }
            }catch (e:java.lang.Exception){

            }
        }


        }

    private fun pinRequest(m: RequestSDABalancceRetrun) {

        showProgressDialog()

        ApiUtils.getAPIServiceV2().SDAToMerchentBalanceReturn(m).enqueue(object : retrofit2.Callback<ResponseBody> {

            override fun onResponse(call: retrofit2.Call<ResponseBody>, response: retrofit2.Response<ResponseBody>) {
                dismissProgressDialog()
                try {
                    val result = response.body()?.string()
                    val jsonObject = JSONObject(result)
                    val status = jsonObject.getString("Status")
                    val message = jsonObject.getString("StatusName")
                    showTransferMessage(status, message)
                } catch (ex: Exception) {
                    showTryAgainDialog()
                }

            }

            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                dismissProgressDialog()
                showTryAgainDialog()

            }



        })

    }


    private fun handleAirTicket(testmessage: String, messageSub: String?, dateTime: String?) {
        try {
            val jsonObject = JSONObject(testmessage)
            val notification_action_type = jsonObject.getString("notification_action_type")
            val original_message = jsonObject.getString("original_message")
            val id = jsonObject.getInt("id")

            val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val s1 = StringEscapeUtils.unescapeJava(original_message);

            val spannableString = SpannableString(s1);
            Linkify.addLinks(spannableString, Linkify.WEB_URLS);
            notiTitle.text = messageSub
            notiMessage.text = spannableString
            date.text = dateTime


            btAccept.visibility = View.VISIBLE
            btTicketCancel.visibility = View.VISIBLE
            btAccept.setOnClickListener {

                callAccept(id)
            }

            btTicketCancel.setOnClickListener {
                callReject(id)

            }



            try {
                //automatic call to API
                val action = intent.extras?.getString("action", "")
                if (!action.equals("")) {
                    if (action.equals("Accept")) {
                        callAccept(id)
                    } else {
                        callReject(id)
                    }
                }
            } catch (e: Exception) {
                Logger.e("" + e.message)
            }


        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun callReject(id: Int) {
        showProgressDialog()
        viewModel.callReScheduleNotificationAccept(id, 2).observeForever {
            dismissProgressDialog()
            if (it != null) {
                showdialogMessageWithFinishedActivity(it.message)
            }
        }
    }

    private fun callAccept(id: Int) {
        showProgressDialog()
        viewModel.callReScheduleNotificationAccept(id, 1).observeForever {
            dismissProgressDialog()
            if (it != null) {
                showdialogMessageWithFinishedActivity(it.message)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (isNotificationFlow) {
            val intent = Intent(this, NotificationAllActivity::class.java)
            intent.putExtra(IS_NOTIFICATION_SHOWN, true)
            startActivity(intent)
            finish()
        } else {
            finish()
        }
    }


    fun showTransferMessage(status_code: String, message: String) {

        val builder = AlertDialog.Builder(this)
        if (status_code.equals("200", ignoreCase = true)) {
            builder.setTitle(Html.fromHtml("<font color='#66cc00'>" + getString(R.string.success_msg) + "</font>"))
            builder.setMessage(getString(R.string.amount_transfer_msg))
        } else {
            builder.setTitle(Html.fromHtml("<font color='#e62e00'>" + getString(R.string.request_failed_msg) + "</font>"))
            builder.setMessage(message)
        }

        builder.setPositiveButton(R.string.okay_btn, DialogInterface.OnClickListener { dialogInterface, id ->
            dialogInterface.dismiss()
            if (status_code.equals("200")){
                finish()
            }

        })

        val alert = builder.create()
        alert.show()
        alert.setCanceledOnTouchOutside(false)
    }

}



