package com.cloudwell.paywell.consumer.ui.freeCard

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivityFreeCardHostBinding
import com.cloudwell.paywell.consumer.ui.freeCard.fragment.GetFreeCardFirstFragment
import com.cloudwell.paywell.consumer.ui.freeCard.view.FreeCardHostFactory
import com.cloudwell.paywell.consumer.ui.freeCard.viewModel.FreeCardHostViewModel
import com.cloudwell.paywell.consumer.ui.switchAccount.fragment.ManageSwitchAccountFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class FreeCardHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: FreeCardHostFactory by instance<FreeCardHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile_host)

        val binding: ActivityFreeCardHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_free_card_host)
        viewModel = ViewModelProviders.of(this, factory).get(FreeCardHostViewModel::class.java)
        binding.viewModelFreeCardHost = viewModel as FreeCardHostViewModel

        val getFreeCardFirstFragment = GetFreeCardFirstFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.free_card_host_container, getFreeCardFirstFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}