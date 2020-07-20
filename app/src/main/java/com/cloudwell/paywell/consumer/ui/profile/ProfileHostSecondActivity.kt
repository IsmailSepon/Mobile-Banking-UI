package com.cloudwell.paywell.consumer.ui.profile

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivityProfileHostBinding
import com.cloudwell.paywell.consumer.ui.profile.fragment.ManageSubscriptionPlanFragment
import com.cloudwell.paywell.consumer.ui.profile.view.ProfileHostFactory
import com.cloudwell.paywell.consumer.ui.profile.viewmodel.ProfileHostViewModel
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

        val managePricePlanFragment = ManageSubscriptionPlanFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.profile_host_container, managePricePlanFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}