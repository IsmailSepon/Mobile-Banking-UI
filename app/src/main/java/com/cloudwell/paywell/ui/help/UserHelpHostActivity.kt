package com.cloudwell.paywell.ui.help

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.databinding.ActivityUserHelpHostBinding
import com.cloudwell.paywell.ui.help.fragment.UserHelpFragment
import com.cloudwell.paywell.ui.help.view.UserHelpHostFactory
import com.cloudwell.paywell.ui.help.viewModel.UserHelpHostViewModel
import com.cloudwell.paywell.ui.switchAccount.fragment.ManageSwitchAccountFragment
import com.cloudwell.paywell.utils.FragmentHelper
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class UserHelpHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: UserHelpHostFactory by instance<UserHelpHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile_host)

        val binding: ActivityUserHelpHostBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_help_host)
        viewModel = ViewModelProviders.of(this, factory).get(UserHelpHostViewModel::class.java)
        binding.viewModelUserHelpHost = viewModel as UserHelpHostViewModel

        FragmentHelper.addFirstFragment(UserHelpFragment(), supportFragmentManager, R.id.user_help_host_container)

    }

}