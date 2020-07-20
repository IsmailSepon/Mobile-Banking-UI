package com.cloudwell.paywell.consumer.ui.switchAccount

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivitySwitchAccountHostBinding
import com.cloudwell.paywell.consumer.ui.switchAccount.fragment.ManageSwitchAccountFragment
import com.cloudwell.paywell.consumer.ui.switchAccount.view.SwitchAccountHostFactory
import com.cloudwell.paywell.consumer.ui.switchAccount.viewModel.SwitchAccountHostViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SwitchAccountHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: SwitchAccountHostFactory by instance<SwitchAccountHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile_host)

        val binding: ActivitySwitchAccountHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_switch_account_host)
        viewModel = ViewModelProviders.of(this, factory).get(SwitchAccountHostViewModel::class.java)
        binding.viewModelSwitchAccountHost = viewModel as SwitchAccountHostViewModel

        val manageSwitchAccountFragment = ManageSwitchAccountFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.switch_account_host_container, manageSwitchAccountFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}