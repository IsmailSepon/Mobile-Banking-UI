package com.cloudwell.paywell.ui.authentication

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.databinding.ActivityUserAuthenticationHostBinding
import com.cloudwell.paywell.ui.authentication.fragment.UserAuthenticateWithPasscodeFragment
import com.cloudwell.paywell.ui.authentication.fragment.UserAuthenticateWithPhnFragment     //this for forgot password
import com.cloudwell.paywell.ui.authentication.view.UserAuthenticationHostFactory
import com.cloudwell.paywell.ui.authentication.viewModel.UserAuthenticationHostViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class UserAuthenticationHostActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_authentication_host)




        FragmentHelper.addFirstFragment(
            UserAuthenticateWithPasscodeFragment(),
                this.supportFragmentManager,
                R.id.user_auth_host_container
            )






    }

}