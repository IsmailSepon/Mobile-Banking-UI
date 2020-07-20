package com.cloudwell.paywell.consumer.ui.authentication

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivityUserAuthenticationHostBinding
import com.cloudwell.paywell.consumer.ui.authentication.fragment.UserAuthenticateWithFingerPrintFragment
import com.cloudwell.paywell.consumer.ui.authentication.fragment.UserAuthenticateWithPasscodeFragment
import com.cloudwell.paywell.consumer.ui.authentication.view.UserAuthenticationHostFactory
import com.cloudwell.paywell.consumer.ui.authentication.viewModel.UserAuthenticationHostViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class UserAuthenticationHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: UserAuthenticationHostFactory by instance<UserAuthenticationHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityUserAuthenticationHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user_authentication_host)
        viewModel = ViewModelProviders.of(this, factory).get(UserAuthenticationHostViewModel::class.java)
        binding.viewModelUserAuthenticationHost = viewModel as UserAuthenticationHostViewModel

//        val userAuthWithFingerPrintFragment = UserAuthenticateWithFingerPrintFragment()
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        transaction.replace(R.id.user_auth_host_container, userAuthWithFingerPrintFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

        val userAuthWithFingerPrintFragment = UserAuthenticateWithPasscodeFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.user_auth_host_container, userAuthWithFingerPrintFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}