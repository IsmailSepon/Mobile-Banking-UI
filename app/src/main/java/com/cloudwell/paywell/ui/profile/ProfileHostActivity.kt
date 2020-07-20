package com.cloudwell.paywell.ui.profile

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.databinding.ActivityProfileHostBinding
import com.cloudwell.paywell.ui.profile.view.ProfileHostFactory
import com.cloudwell.paywell.ui.profile.viewmodel.ProfileHostViewModel
import com.cloudwell.paywell.ui.profile.fragment.ManageProfileFragment
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