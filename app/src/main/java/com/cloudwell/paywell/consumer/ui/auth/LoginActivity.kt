package com.cloudwell.paywell.consumer.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.base.customView.BusTicketStatusFragment
import com.cloudwell.paywell.consumer.databinding.ActivityLoginBinding
import com.cloudwell.paywell.consumer.ui.auth.authViewModelFactory.AuthViewModelFactory
import com.cloudwell.paywell.consumer.ui.auth.model.UserLoginResponse
import com.cloudwell.paywell.consumer.ui.auth.view.IAuthViewListener.IAuthListener
import com.cloudwell.paywell.consumer.utils.viewUtil.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : BaseActivity(), IAuthListener, KodeinAware {

    override val kodein by kodein()
    private val authViewModelFactory : AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding :  ActivityLoginBinding  = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, authViewModelFactory).get(AuthViewModel::class.java)
        binding.viewmode = viewModel
        viewModel.iAuthListener= this


        val t = BusTicketStatusFragment()
        BusTicketStatusFragment.message = "test"
        t.show(supportFragmentManager, "dialog")


       // setSupportActionBar(toolbar)

    }

    override fun showProgress() {
        //showProgressDialog()
    }

    override fun hiddenProgress() {

        //dismissProgressDialog()
    }

    override fun onSuccess(userLoginResponse: UserLoginResponse) {
        toast("onSuccess"+ userLoginResponse.userName)

    }

    override fun onFailure(message:String) {
        toast(message)
    }

    override fun noInternetConnectionFound() {
        toast("No internet connection found!!!")
    }
}
