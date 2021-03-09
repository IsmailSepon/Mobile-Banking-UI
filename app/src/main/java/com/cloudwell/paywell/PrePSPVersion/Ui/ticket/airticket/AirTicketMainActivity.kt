package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.util.Base64
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import com.cloudwell.paywell.BuildConfig
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.base.AirTricketBaseActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.booking.model.Datum
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.retrofit.ApiUtils
import com.cloudwell.paywell.retrofit.RequestAppsAuth
import com.cloudwell.paywell.retrofit.ResposeAppsAuth
import com.cloudwell.paywell.utils.AndroidIDUtility
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_air_ticket_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class AirTicketMainActivity : AirTricketBaseActivity() {


    private var mAppHandler: AppHandler? = null

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

        mAppHandler = AppHandler.getmInstance(this)
        mAppHandler?.userName = "01912250477"
        mAppHandler?.rid = "S12050043936"



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

        getFCMTokenAndSave()

        val androidID1 = AndroidIDUtility.getAndroidID(applicationContext)
        AppHandler.getmInstance(getApplicationContext()).setAndroidID(androidID1)


        val androidId: String = AppHandler.getmInstance(applicationContext).androidID

        val firebaseId = AppHandler.getmInstance(applicationContext).firebaseId

        callGetTokenAPI("01912250477", "1234", androidID1, firebaseId)

    }


    fun getFCMTokenAndSave() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Logger.w("getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token
                AppHandler.getmInstance(applicationContext).setFirebaseId(token)
            })


    }



    private fun callGetTokenAPI(userName: String, password: String, androidId: String, firebaseId: String) {

        showProgressDialog()

        val base = userName + ":" + password;
        val authHeader = "Basic " + Base64.encodeToString(base.toByteArray(), Base64.NO_WRAP);


        val channel = "android"
        val currentTimestamp = System.currentTimeMillis()


        val privateKey = AppHandler.getmInstance(applicationContext).getRSAKays().get(1);


        var isDebug = 0
        if (BuildConfig.DEBUG) {
            isDebug = 0
        } else {
            isDebug = 1
        }


        val authRequestModel = RequestAppsAuth(isDebug, androidId, privateKey, channel, "" + currentTimestamp, firebaseId)

        ApiUtils.getAPIServiceV2().getAppsAuthToken(authHeader, authRequestModel).enqueue(object :
            Callback<ResposeAppsAuth> {
            override fun onResponse(call: Call<ResposeAppsAuth>, response: Response<ResposeAppsAuth>) {

                dismissProgressDialog()

                val m = response.body()

                m.let {
                    if (m?.status == 200) {

                        AppHandler.getmInstance(applicationContext).setSealedData(m?.sealedData)
                        AppHandler.getmInstance(applicationContext).setEnvlope(m?.envlope)
                        AppHandler.getmInstance(applicationContext).setAppsSecurityToken(m?.token?.securityToken)
                        AppHandler.getmInstance(applicationContext).setAppsTokenExpTime(m?.token?.tokenExpTime)
                        AppHandler.getmInstance(applicationContext).setUserName(userName)


                    } else {
                        it?.message?.let { it1 -> showErrorMessagev1(it1) }
                    }

                }


            }

            override fun onFailure(call: Call<ResposeAppsAuth>, t: Throwable) {
                dismissProgressDialog();
                showTryAgainDialog()

            }
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

//        val arrow = layout.findViewById<LinearLayout>(R.id.setting_liner)
////
////
//        val layoutParams = layout.layoutParams as LinearLayout.LayoutParams
//        layoutParams.setMargins(30, 20, 30, 0)
////        arrow.layoutParams = layoutParams
//        layout.layoutParams = layoutParams

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
