package com.cloudwell.paywell.ui.profile

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.RequestMoneyMainFragment
import com.cloudwell.paywell.databinding.ActivityProfileHostBinding
import com.cloudwell.paywell.ui.profile.fragment.ManageSubscriptionPlanFragment
import com.cloudwell.paywell.ui.profile.fragment.PricePlanManageFragment
import com.cloudwell.paywell.ui.profile.view.ProfileHostFactory
import com.cloudwell.paywell.ui.profile.viewmodel.ProfileHostViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ProfileHostSecondActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: ProfileHostFactory by instance<ProfileHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile_host)

        val binding: ActivityProfileHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_profile_host)
        viewModel = ViewModelProviders.of(this, factory).get(ProfileHostViewModel::class.java)
        binding.viewModelProfileHost = viewModel as ProfileHostViewModel

//        val managePricePlanFragment = ManageSubscriptionPlanFragment()
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        transaction.replace(R.id.profile_host_container, managePricePlanFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

//        val managePricePlanFragment = PricePlanManageFragment()
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        transaction.replace(R.id.profile_host_container, managePricePlanFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

        FragmentHelper.addFirstFragment(
            PricePlanManageFragment(),
            supportFragmentManager,
            R.id.profile_host_container
        )
    }

}