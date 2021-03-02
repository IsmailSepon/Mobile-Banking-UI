package com.cloudwell.paywell.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.base.newBase.SingleLiveEvent
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.base.newBase.BaseViewState
import com.cloudwell.paywell.utils.exception.ApiException
import com.cloudwell.paywell.utils.exception.NoInternetException

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-08.
 */
open class BaseViewModel : ViewModel() {


    val baseViewStatus = SingleLiveEvent<BaseViewState>()

    val isShowProcessBar = MutableLiveData<Boolean>()
    val onFailureString = MutableLiveData<String>()


    fun handleException(ex: Exception, view: IView?) {
        if (ex is ApiException) {
            view?.onFailure(ex.message)
        } else if (ex is NoInternetException) {
            view?.onFailure(ex.message)
        }
    }

}