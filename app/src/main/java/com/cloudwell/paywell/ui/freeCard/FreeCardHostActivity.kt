package com.cloudwell.paywell.ui.freeCard

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.databinding.ActivityFreeCardHostBinding
import com.cloudwell.paywell.ui.freeCard.fragment.GetFreeCardFirstFragment
import com.cloudwell.paywell.ui.freeCard.view.FreeCardHostFactory
import com.cloudwell.paywell.ui.freeCard.viewModel.FreeCardHostViewModel
import com.cloudwell.paywell.ui.help.fragment.UserHelpFragment
import com.cloudwell.paywell.ui.switchAccount.fragment.ManageSwitchAccountFragment
import com.cloudwell.paywell.utils.FragmentHelper
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class FreeCardHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: FreeCardHostFactory by instance<FreeCardHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_host)

//        val binding: ActivityFreeCardHostBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_free_card_host)
//        viewModel = ViewModelProviders.of(this, factory).get(FreeCardHostViewModel::class.java)
//        binding.viewModelFreeCardHost = viewModel as FreeCardHostViewModel

//        val getFreeCardFirstFragment = GetFreeCardFirstFragment()
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        transaction.replace(R.id.free_card_host_container, getFreeCardFirstFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

        FragmentHelper.addFirstFragment(GetFreeCardFirstFragment(), supportFragmentManager, R.id.profile_host_container)

    }

}