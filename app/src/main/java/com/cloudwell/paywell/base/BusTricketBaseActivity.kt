package com.cloudwell.paywell.base

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import androidx.appcompat.app.ActionBar
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.base.newBase.MVVMBaseActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.dialog.BusErrorMsgDialog
import java.util.*

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 30/1/19.
 */
open class BusTricketBaseActivity : MVVMBaseActivity() {
    internal open lateinit var mAppHandler: AppHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //switchToCzLocale(Locale.ENGLISH)
        mAppHandler = AppHandler.getmInstance(applicationContext)

        changeAppTheme()

//        assert(supportActionBar != null)
//
//        if (supportActionBar != null) {
//            supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.bus_ticket_toolbar_backgroud_color)))
//            setActionbarTextColor(supportActionBar!!, resources.getColor(R.color.bus_ticket_toolbar_title_text_color))
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                window.statusBarColor = resources.getColor(R.color.bus_ticket_status_color, this.theme)
//            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                window.statusBarColor = resources.getColor(R.color.bus_ticket_status_color)
//            }
//        }
    }

    fun setActionbarTextColor(actBar: ActionBar, color: Int) {
        val title = actBar.title.toString()
        val spannablerTitle = SpannableString(title)
        spannablerTitle.setSpan(ForegroundColorSpan(color), 0, spannablerTitle.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        actBar.title = spannablerTitle

    }


    private fun changeAppTheme() {
        val isEnglish = mAppHandler.appLanguage.equals("en", ignoreCase = true)
        if (isEnglish) {
            setTheme(R.style.EnglishAppThemeBus)
        } else {
            setTheme(R.style.EnglishAppThemeBus)
        }
    }


    fun changeAppBaseTheme() {
        setTheme(R.style.AppTheme)
    }


    override fun switchToCzLocale(locale: Locale) {
        val config = baseContext.resources.configuration
        Locale.setDefault(locale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale)
        }
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
    }


    fun showBusTicketErrorDialog(message: String, needFinishedActivity: Boolean = false) {

        val errorMsgDialog = BusErrorMsgDialog(message, needFinishedActivity)
        errorMsgDialog.show(supportFragmentManager, "oTPVerificationMsgDialog")

    }

    fun showBusTicketSuccessDialog(message: String, needFinishedActivity: Boolean = false) {

        val errorMsgDialog = BusErrorMsgDialog(message, needFinishedActivity)
        errorMsgDialog.show(supportFragmentManager, "oTPVerificationMsgDialog")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main_air_ticket, menu)
        return true
    }

}
