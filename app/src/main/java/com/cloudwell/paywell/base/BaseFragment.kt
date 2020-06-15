package com.vu.mobile.base

import androidx.fragment.app.Fragment
import com.cloudwell.paywell.base.IView

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2020-05-10.
 */
open class BaseFragment : Fragment(), IView {
    override fun onFailure(message: String?) {
    }

    override fun hiddenProgress() {
    }

    override fun noInternetConnectionFound() {

    }

    override fun showProgress() {
    }

}