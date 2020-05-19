package com.cloudwell.paywell.consumer.base

interface IBaseView {

    fun noInternetConnectionFound()
    fun showProgress()
    fun hiddenProgress()
    fun onFailure(message: String?)
}