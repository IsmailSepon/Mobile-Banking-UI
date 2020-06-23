package com.cloudwell.paywell.consumer.ui.dashboard

import android.os.Bundle
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.ui.dashboard.view.ProfileFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class DashboardHostActivity : BaseActivity(), KodeinAware {

    //lage nai

    override val kodein by kodein()

//    private val factory: DashboardFactory by instance<DashboardFactory>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_host)

//        val binding: ActivityDashboardHostBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_dashboard_host)
//        viewModel = ViewModelProviders.of(this, factory).get(DashboardViewModel::class.java)
//        binding.viewModel = viewModel as DashboardViewModel

        setViewModelObserver()


        val profileFragment = ProfileFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.dashboard_container, profileFragment)
        transaction.addToBackStack(null)
        transaction.commit()


    }

//    fun startActivity(type: Int) {
//        val intent = Intent(this, BeneficeryHostActivity::class.java)
//        intent.putExtra(this.getString(R.string.beneficery_type), type)
//        this.startActivity(intent)
//    }
}