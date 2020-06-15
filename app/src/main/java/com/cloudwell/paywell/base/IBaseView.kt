package com.cloudwell.paywell.base

interface IBaseView {
    fun noInternetConnectionFound()
    fun showProgress()
    fun hiddenProgress()
    fun onFailure(message: String?)
}