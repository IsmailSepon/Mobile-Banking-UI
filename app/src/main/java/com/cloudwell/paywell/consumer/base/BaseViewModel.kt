package com.cloudwell.paywell.consumer.base

import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.utils.exception.ApiException
import com.cloudwell.paywell.consumer.utils.exception.NoInternetException

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-08.
 */
open class BaseViewModel : ViewModel() {

    public fun handleException(ex: Exception, view: IView?) {
        if (ex is ApiException) {
            view?.onFailure(ex.message)
        } else if (ex is NoInternetException) {
            view?.onFailure(ex.message)
        }
    }
}