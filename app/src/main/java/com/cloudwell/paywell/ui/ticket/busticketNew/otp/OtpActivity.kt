package com.cloudwell.paywell.ui.ticket.busticketNew.otp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import com.cloudwell.paywell.ui.ticket.busticketNew.cencel.model.RequestOtpCheck
import com.cloudwell.paywell.ui.ticket.busticketNew.cencel.model.ResposeOptCheck
import com.cloudwell.paywell.R
import com.cloudwell.paywell.activity.ChangePinActivity
import com.cloudwell.paywell.activity.dialog.ErrorMsgDialog
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.broadcast.SmsBroadcastReceiver
import com.cloudwell.paywell.retrofit.ApiUtils
import com.cloudwell.paywell.services.activity.eticket.busticketNew.cencel.OTPVerificationMsgDialog
import com.cloudwell.paywell.activity.model.ReposeGenerateOTP
import com.cloudwell.paywell.services.activity.home.model.RequestGenerateOTP
import com.cloudwell.paywell.utils.AppsStatusConstant
import com.dhruv.timerbutton.ButtonAnimationListener
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.otp_dialog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class OtpActivity : com.cloudwell.paywell.ui.BaseActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
    OtpReceivedInterface {

    var userNeedToChangePassword = false;
    var OTPMessaage = ""
    var pin = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_dialog)

        setToolbar(getString(R.string.title_otp_verfication));

        userNeedToChangePassword = intent.getBooleanExtra("userNeedToChangePassword", false)
        OTPMessaage = intent.getStringExtra("OTPMessaage")
        pin = intent.getStringExtra("pin")

        tvOtpMessage.text = OTPMessaage


        btNextOtp.setOnClickListener {

            val otp = etMobileOrRID.text

            callCheckOTP("" + otp)

        }

        etMobileOrRID.requestFocus();

        btCancel.setOnClickListener {
            finish()
        }


        timer_button.setDuration(60000L);


        timer_button.setButtonAnimationListener(object : OnClickHandler, ButtonAnimationListener {
            override fun otpAutoCall(mobileNumber: String) {

            }

            override fun otpManualCall(mobileNumber: String) {

            }

            override fun onAnimationEnd() {


            }

            override fun onAnimationStart() {
                calledResendOtp();
            }

            override fun onAnimationReset() {
                Logger.v("")

            }


        })


    }

    private fun calledResendOtp() {
        showProgressDialog()

        val m = RequestGenerateOTP()
        m.username = AppHandler.getmInstance(applicationContext).userName

        ApiUtils.getAPIServiceV2().generateOTP(m).enqueue(object : Callback<ReposeGenerateOTP> {
            override fun onResponse(call: Call<ReposeGenerateOTP>, response: Response<ReposeGenerateOTP>) {
                dismissProgressDialog()
                if (response.isSuccessful) {

                    response.body().let {
                        if (it?.apiStatus ?: 0 == 200) {
                            if (it?.responseDetails!!.status == 200) {
                                Toast.makeText(applicationContext, it?.responseDetails?.statusName, Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(applicationContext, it?.responseDetails?.statusName, Toast.LENGTH_LONG).show()
                                timer_button.reset()
                            }
                        } else {
                            val errorMsgDialog = it?.apiStatusName?.let { it1 -> ErrorMsgDialog(it1) }
                            errorMsgDialog?.show(supportFragmentManager, "oTPVerificationMsgDialog")
                        }
                    }

                }
            }

            override fun onFailure(call: Call<ReposeGenerateOTP>, t: Throwable) {
                dismissProgressDialog()
                showTryAgainDialog()
            }
        })


    }

    private var mGoogleApiClient: GoogleApiClient? = null
    private lateinit var mSmsBroadcastReceiver: SmsBroadcastReceiver


    override fun onOtpReceived(otp: String?) {
        Toast.makeText(applicationContext, "" + otp, Toast.LENGTH_LONG).show()
        val parseCode = parseCode(otp)
        etMobileOrRID.setText(parseCode)

        callCheckOTP("" + parseCode)


    }


    override fun onOtpTimeout() {
    }

    override fun onConnectionFailed(p0: ConnectionResult) {


    }

    override fun onConnected(p0: Bundle?) {


    }

    override fun onConnectionSuspended(p0: Int) {
    }


    override fun onStart() {
        super.onStart()
        try {
            if (mGoogleApiClient == null) {

                mSmsBroadcastReceiver = SmsBroadcastReceiver()


                mGoogleApiClient = GoogleApiClient.Builder(this)
                        .addConnectionCallbacks(this)
                        .addApi(Auth.CREDENTIALS_API)
                        .enableAutoManage(this, this)
                        .build()
                mSmsBroadcastReceiver.setOnOtpListeners(this)
                val intentFilter = IntentFilter()
                intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION)
                registerReceiver(mSmsBroadcastReceiver, intentFilter)

                startSMSListener()

            }
        } catch (e: Exception) {

        }


    }


    override fun onStop() {
        super.onStop()
        if (mGoogleApiClient != null && mGoogleApiClient!!.isConnected) {
            mGoogleApiClient!!.stopAutoManage(this)
            mGoogleApiClient!!.disconnect()
            mGoogleApiClient = null
        }

        try {
            if (mSmsBroadcastReceiver != null) {
                unregisterReceiver(mSmsBroadcastReceiver)
            }
        } catch (e: Exception) {

        }


    }


    fun startSMSListener() {
        val mClient = SmsRetriever.getClient(this)
        val mTask = mClient.startSmsRetriever()
        mTask.addOnSuccessListener {

//            Toast.makeText(this, "SMS Retriever starts", Toast.LENGTH_LONG).show()
        }
        mTask.addOnFailureListener { Toast.makeText(this, "Error", Toast.LENGTH_LONG).show() }
    }


    public interface OnClickHandler {

        public fun otpAutoCall(mobileNumber: String)
        public fun otpManualCall(mobileNumber: String)
    }

    fun parseCode(message: String?): String? {
        val p: Pattern = Pattern.compile("\\b\\d{4}\\b")
        val m: Matcher = p.matcher(message)
        var code = ""
        while (m.find()) {
            code = m.group(0)
        }
        return code
    }

    private fun callCheckOTP(otp: String) {
        showProgressDialog()

        val m = RequestOtpCheck()
        m.format = "json"
        m.otp = otp
        m.username = AppHandler.getmInstance(applicationContext).userName

        ApiUtils.getAPIServiceV2().checkOTP(m).enqueue(object : Callback<ResposeOptCheck> {
            override fun onResponse(call: Call<ResposeOptCheck>, response: Response<ResposeOptCheck>) {
                dismissProgressDialog()

                response.body().let {
                    if (it?.apiStatus ?: 0 == 200) {

                        if (it?.responseDetails?.status == 200) {


                            val oTPVerificationMsgDialog = OTPVerificationMsgDialog(object : OTPVerificationMsgDialog.OnClickHandler {
                                override fun onSubmit() {


                                    if (userNeedToChangePassword) {
                                        val i = Intent(this@OtpActivity, ChangePinActivity::class.java)
                                        i.putExtra("isFirstTime", true);
                                        i.putExtra("pin", pin)
                                        startActivity(i)
                                        finish()

                                    } else {
                                        AppHandler.getmInstance(applicationContext).appStatus = AppsStatusConstant.KEY_login
//                                        val i = Intent(this@OtpActivity, AppLoadingActivity::class.java)
//                                        i.putExtra("pin", pin)
//                                        startActivity(i)i
                                        finish()
                                    }


                                }

                            }, it?.responseDetails!!.statusName)
                            oTPVerificationMsgDialog.show(supportFragmentManager, "oTPVerificationMsgDialog");
                        } else {
                            showErrorMessagev1(it?.responseDetails?.statusName)
                        }

                    } else {
                        val errorMsgDialog = it?.apiStatusName?.let { it1 ->

                            ErrorMsgDialog(it1)

                        }
                        errorMsgDialog?.show(supportFragmentManager, "oTPVerificationMsgDialog")
                    }
                }
            }

            override fun onFailure(call: Call<ResposeOptCheck>, t: Throwable) {
                dismissProgressDialog();
                showTryAgainDialog()
            }
        })

    }




    private fun toHexString(bytes: ByteArray): String? {
        val formatter = Formatter()
        for (b in bytes) {
            formatter.format("%02x", b)
        }
        return formatter.toString()
    }

}
