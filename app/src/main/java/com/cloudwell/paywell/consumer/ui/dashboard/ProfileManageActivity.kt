package com.cloudwell.paywell.consumer.ui.dashboard

import android.os.Bundle
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.BaseActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

class ProfileManageActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_manage_acc_profile)
    }
}