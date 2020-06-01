package com.vu.mobile.base

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.base.IView
import com.cloudwell.paywell.consumer.ui.auth.model.UserLoginResponse

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2020-05-10.
 */
open class BaseFragment() : Fragment(), IView {
package com.cloudwell.paywell.consumer.base

import androidx.fragment.app.Fragment

class BaseFragment : Fragment(), IView {
    override fun noInternetConnectionFound() {

    }

    override fun showProgress() {

    }

    override fun hiddenProgress() {
    }

    override fun onSuccess(userLoginResponse: UserLoginResponse?) {

    }

    override fun onFailure(message: String?) {
        Toast.makeText(activity?.applicationContext, message, Toast.LENGTH_LONG).show()

    }

    override fun hiddenProgress() {

    }


    override fun onFailure(message: String?) {

    }


}