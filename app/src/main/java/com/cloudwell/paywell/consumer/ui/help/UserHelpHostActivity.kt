package com.cloudwell.paywell.consumer.ui.help

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivityUserHelpHostBinding
import com.cloudwell.paywell.consumer.ui.help.fragment.UserHelpFragment
import com.cloudwell.paywell.consumer.ui.help.view.UserHelpHostFactory
import com.cloudwell.paywell.consumer.ui.help.viewModel.UserHelpHostViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class UserHelpHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: UserHelpHostFactory by instance<UserHelpHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile_host)

        val binding: ActivityUserHelpHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user_help_host)
        viewModel = ViewModelProviders.of(this, factory).get(UserHelpHostViewModel::class.java)
        binding.viewModelUserHelpHost = viewModel as UserHelpHostViewModel

        val manageSwitchAccountFragment = UserHelpFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.user_help_host_container, manageSwitchAccountFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}