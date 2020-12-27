package com.cloudwell.paywell.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.MenuItem
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cloudwell.paywell.appController.AppController
import com.cloudwell.paywell.ui.registration.SignupActivity
import com.cloudwell.paywell.ui.registration.SignupPasswordActivity


/**
 * Created by Ismail Hossain Sepon Email: ismailhossainsepon@gmail.com  Mobile: +8801612250477
 */
open class BaseActivity : AppCompatActivity(), LogOutTimerUtil.LogOutListener, IBaseView {

    val class_Name: String = this.javaClass.simpleName
    lateinit var viewModel: BaseViewModel

        override fun onStart() {
            super.onStart()
            LogOutTimerUtil.startLogoutTimer(this, this)
            Log.e(class_Name, "OnStart () &&& Starting timer")
            //disable screenShoot..........
//            this.window.setFlags(
//                WindowManager.LayoutParams.FLAG_SECURE,
//                WindowManager.LayoutParams.FLAG_SECURE
//            )
        }


    override fun onUserInteraction() {
        super.onUserInteraction()
        LogOutTimerUtil.startLogoutTimer(this, this)
        Log.e(class_Name, "User interacting with screen")
    }

    override fun doLogout() {
        Log.e(class_Name, "Time Out + log out")
        val intent = Intent(this, SignupPasswordActivity::class.java)
        finishAffinity()
        this.finish()
        startActivity(intent)

    }



    @SuppressLint("Assert")
    fun setToolbar(title: String, color: Int) {
        assert(supportActionBar != null)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            val spannablerTitle = SpannableString(title)
            spannablerTitle.setSpan(
                ForegroundColorSpan(color),
                0,
                spannablerTitle.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            supportActionBar!!.title = spannablerTitle
        }
    }

    fun setToolbar(title: String) {
        assert(supportActionBar != null)
        if (supportActionBar != null) {
            supportActionBar!!.title = title
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    fun setToolbarWithOutBack(title: String) {
        assert(supportActionBar != null)
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun hideUserKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun hiddenSoftKeyboard() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }



    open fun getApp(): AppController {
        return this.application as AppController
    }

    override fun noInternetConnectionFound() {

    }

    override fun showProgress() {
    }

    override fun hiddenProgress() {
    }

    override fun onFailure(message: String?) {
    }


    fun setViewModelObserver() {
        viewModel.isShowProcessBar.observe(this, Observer {
            if (it) {
                showProgress()
            } else {
                hiddenProgress()
            }
        })

    }


//    override fun onUserInteraction() {
//        super.onUserInteraction()
//        getApp().touch()
//        Log.e("Tuch", "User interaction to $this")
//    }
}