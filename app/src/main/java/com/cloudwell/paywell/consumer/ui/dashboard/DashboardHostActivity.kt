package com.cloudwell.paywell.consumer.ui.dashboard

import android.os.Bundle
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein


class DashboardHostActivity : BaseActivity(), KodeinAware {

    //lage nai

    override val kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_host)
    }

}