package com.cloudwell.paywell.consumer.ui.dashboard

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivityProfileHostBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.fragment.BeneficiaryFragment
import com.cloudwell.paywell.consumer.ui.dashboard.view.ProfileHostFactory
import com.cloudwell.paywell.consumer.ui.dashboard.viewmodel.ProfileHostViewModel
import com.cloudwell.paywell.consumer.ui.profile.fragment.ManageProfileFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ProfileHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: ProfileHostFactory by instance<ProfileHostFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile_host)

        val binding: ActivityProfileHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_profile_host)
        viewModel = ViewModelProviders.of(this, factory).get(ProfileHostViewModel::class.java)
        binding.viewModelProfileHost = viewModel as ProfileHostViewModel

        val manageProfileFragment = ManageProfileFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.profile_host_container, manageProfileFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}